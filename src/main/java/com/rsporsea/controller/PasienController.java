package com.rsporsea.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rsporsea.model.Akun;
import com.rsporsea.model.Dokter;
import com.rsporsea.model.Pasien;
import com.rsporsea.model.PengobatanJalan;
import com.rsporsea.model.PengobatanInap;
import com.rsporsea.service.DokterService;
import com.rsporsea.service.PasienService;
import com.rsporsea.service.PengobatanInapService;
import com.rsporsea.service.PengobatanJalanService;

@Controller
public class PasienController {

	private PasienService pasienService;
	private PengobatanJalanService pengobatanJalanService;
	private PengobatanInapService pengobatanInapService;
	private DokterService dokterService;

	@Autowired	
	public void setPasienService(PasienService pasienService) {
		this.pasienService = pasienService;
	}

	@Autowired	
	public void setPengobatanJalanService(PengobatanJalanService pengobatanJalanServices) {
		this.pengobatanJalanService = pengobatanJalanServices;
	}

	@Autowired
	public void setPengobatanInapService(PengobatanInapService pengobatanInapService){
		this.pengobatanInapService = pengobatanInapService;
	}

	@Autowired	
	public void setDokterService(DokterService dokterService) {
		this.dokterService = dokterService;
	}


	//	PASIEN =====================================================================================================================

	@RequestMapping("/pasien")
	public String pasien(Model model, HttpServletRequest request){
		if (request.getSession().getAttribute("akunLogin") == null) {
			return "redirect:/SIRMJD";
		}
		Akun akun = new Akun();
		akun = (Akun) request.getSession().getAttribute("akunLogin");
		model.addAttribute("akun", akun);
		if(akun.getRole().equals("Admin") || akun.getRole().equals("Loket")){
			model.addAttribute("pasien", pasienService.listPasien());
			return "pasien/pasien";
		}
		return "restricted";

	}	

	@RequestMapping(value = "/pasien/create", method = RequestMethod.GET)
	public String tampilkanForm(Model model, HttpServletRequest request){
		if (request.getSession().getAttribute("akunLogin") == null) {
			return "redirect:/SIRMJD";
		}
		Akun akun = new Akun();
		akun = (Akun) request.getSession().getAttribute("akunLogin");
		model.addAttribute("akun", akun);
		if(akun.getRole().equals("Admin") || akun.getRole().equals("Loket")){
			model.addAttribute("pasien", new Pasien());
			return "pasien/pasienForm";
		}
		return "restricted";
	}

	@RequestMapping(value = "/pasien/create", params = "save", method = RequestMethod.POST)
	public String simpanDataPasien(Model model, Pasien pasien, HttpServletRequest request){
		if (request.getSession().getAttribute("akunLogin") == null) {
			return "redirect:/SIRMJD";
		}
		Akun akun = new Akun();
		akun = (Akun) request.getSession().getAttribute("akunLogin");
		model.addAttribute("akun", akun);
		if(akun.getRole().equals("Admin") || akun.getRole().equals("Loket")){
			model.addAttribute("pasien", pasienService.saveOrUpdate(pasien));
			if(pasien.getId_pasien()!=null){
				return "redirect:/detailpasien/"+pasien.getId_pasien();
			}
			if(pasien.getId_pasien()==null){
				return "redirect:/detailpasien/"+pasienService.latest();
			}
		}
		return "restricted";
	}

	@RequestMapping(value = "/pasien/create", params = "cancel", method = RequestMethod.POST)
	public String batalSimpanDataPasien(Model model, HttpServletRequest request){
		if (request.getSession().getAttribute("akunLogin") == null) {
			return "redirect:/SIRMJD";
		}
		Akun akun = new Akun();
		akun = (Akun) request.getSession().getAttribute("akunLogin");
		model.addAttribute("akun", akun);
		if(akun.getRole().equals("Admin") || akun.getRole().equals("Loket")){
			model.addAttribute("pasien", null);
			//			if(pasien==null){
			return "redirect:/pasien";
			//			}else{
			//				return "redirect:/detailpasien/"+pasien.getId_pasien();
			//			}
		}
		return "restricted";
	}

	@RequestMapping(value = "/pasien/edit/{id_pasien}", method = RequestMethod.GET)
	public String editDataPasien(@PathVariable Integer id_pasien, Model model, HttpServletRequest request){	
		if (request.getSession().getAttribute("akunLogin") == null) {
			return "redirect:/SIRMJD";
		}
		Akun akun = new Akun();
		akun = (Akun) request.getSession().getAttribute("akunLogin");
		model.addAttribute("akun", akun);
		if(akun.getRole().equals("Admin") || akun.getRole().equals("Loket")){
			model.addAttribute("pasien", pasienService.getIdPasien(id_pasien));
			return "pasien/pasienForm";
		}
		return "restricted";
	}

	@RequestMapping(value = "/pasien/hapus/{id_pasien}", method = RequestMethod.GET)
	public String hapusDataPasien(@PathVariable Integer id_pasien, Model model, HttpServletRequest request){	
		if (request.getSession().getAttribute("akunLogin") == null) {
			return "redirect:/SIRMJD";
		}
		Akun akun = new Akun();
		akun = (Akun) request.getSession().getAttribute("akunLogin");
		model.addAttribute("akun", akun);
		if(akun.getRole().equals("Admin") || akun.getRole().equals("Loket")){
			pasienService.hapusPasien(id_pasien);
			return "redirect:/pasien";
		}
		return "restricted";
	}

	//	DETAIL PASIEN =====================================================================================================================

	@RequestMapping(value = "/detailpasien/{id_pasien}", method = RequestMethod.GET)
	public String detailPasien(@PathVariable Integer id_pasien, Model model, HttpServletRequest request){	
		if (request.getSession().getAttribute("akunLogin") == null) {
			return "redirect:/SIRMJD";
		}
		Akun akun = new Akun();
		akun = (Akun) request.getSession().getAttribute("akunLogin");
		model.addAttribute("akun", akun);
		if(akun.getRole().equals("Admin") || akun.getRole().equals("Loket")){
			model.addAttribute("pasien", pasienService.getIdPasien(id_pasien));
			return "pasien/detailpasien";
		}
		return "restricted";
	}


	//	DETAIL PENGOBATAN =====================================================================================================================

	@RequestMapping(value = "/detailpengobatan/{id_pasien}", method = RequestMethod.GET)
	public String detailPengobatan(@PathVariable Integer id_pasien, Model model, HttpServletRequest request){
		if (request.getSession().getAttribute("akunLogin") == null) {
			return "redirect:/SIRMJD";
		}
		Akun akun = new Akun();
		akun = (Akun) request.getSession().getAttribute("akunLogin");
		model.addAttribute("akun", akun);
		if(akun.getRole().equals("Admin") || akun.getRole().equals("Loket")){
			model.addAttribute("pasien", pasienService.getIdPasien(id_pasien));
			model.addAttribute("pengobatanJalan",pengobatanJalanService.getAllPengobatanJalan(id_pasien));
			model.addAttribute("pengobatanInap", pengobatanInapService.getAllPengobatanInap(id_pasien));
			return "pasien/detailpengobatan";
		}
		return "restricted";
	}


	//	DETAIL PENGOBATAN JALAN =====================================================================================================================

	@RequestMapping(value = "/detailpengobatan/create/{id_pasien}", method = RequestMethod.GET)
	public String tampilkanFormPengobatanJalan(Model model,@PathVariable Integer id_pasien, HttpServletRequest request){	
		if (request.getSession().getAttribute("akunLogin") == null) {
			return "redirect:/SIRMJD";
		}
		Akun akun = new Akun();
		akun = (Akun) request.getSession().getAttribute("akunLogin");
		model.addAttribute("akun", akun);
		if(akun.getRole().equals("Admin") || akun.getRole().equals("Loket")){
			model.addAttribute("now",pengobatanJalanService.dateNow());
			model.addAttribute("pasien", pasienService.getIdPasien(id_pasien));
			PengobatanJalan pengobatanJalan = new PengobatanJalan();
			pengobatanJalan.setId_pasien(id_pasien);
			model.addAttribute("pengobatanJalan",pengobatanJalan);
			model.addAttribute("dokter", dokterService.listDokter());
			return "pasien/formpengobatanjalan";
		}
		return "restricted";
	}

	@RequestMapping(value = "/detailpengobatan/create/{id_pasien}",params = "save", method = RequestMethod.POST)
	public String simpanDataPengobatanJalan(Model model, PengobatanJalan pengobatanJalan ,@PathVariable Integer id_pasien, HttpServletRequest request){		
		if (request.getSession().getAttribute("akunLogin") == null) {
			return "redirect:/SIRMJD";
		}
		Akun akun = new Akun();
		akun = (Akun) request.getSession().getAttribute("akunLogin");
		model.addAttribute("akun", akun);
		if(akun.getRole().equals("Admin") || akun.getRole().equals("Loket")){
			model.addAttribute("pengobatanJalan", pengobatanJalanService.saveorUpdate(pengobatanJalan));
			if(pengobatanJalan.getId_pengobatan_jalan()==null){
				return "redirect:/datapengobatanjalan/"+pengobatanJalanService.latest(id_pasien);
			}
			if(pengobatanJalan.getId_pengobatan_jalan()!=null){
				return "redirect:/datapengobatanjalan/"+pengobatanJalan.getId_pengobatan_jalan();
			}
			//			return "redirect:/detailpengobatan/"+pengobatanJalan.getId_pasien();	
		}
		return "restricted";
	}

	@RequestMapping(value = "/detailpengobatan/create/{id_pasien}", params = "cancel", method = RequestMethod.POST)
	public String batalSimpanDataPengobatanJalan(Model model, Pasien pasien, HttpServletRequest request){		
		if (request.getSession().getAttribute("akunLogin") == null) {
			return "redirect:/SIRMJD";
		}
		Akun akun = new Akun();
		akun = (Akun) request.getSession().getAttribute("akunLogin");
		model.addAttribute("akun", akun);
		if(akun.getRole().equals("Admin") || akun.getRole().equals("Loket")){
			model.addAttribute("pasien", null);
			return "redirect:/detailpengobatan/"+pasien.getId_pasien();
		}
		return "restricted";
	}


	//	DETAIL PENGOBATAN INAP =====================================================================================================================

	@RequestMapping(value = "/detailpengobatan/createInap/{id_pasien}", method = RequestMethod.GET)
	public String tampilkanFormPengobatanInap(Model model,@PathVariable Integer id_pasien, HttpServletRequest request){
		if (request.getSession().getAttribute("akunLogin") == null) {
			return "redirect:/SIRMJD";
		}
		Akun akun = new Akun();
		akun = (Akun) request.getSession().getAttribute("akunLogin");
		model.addAttribute("akun", akun);
		if(akun.getRole().equals("Admin") || akun.getRole().equals("Loket")){
			model.addAttribute("now",pengobatanInapService.dateNow());
			model.addAttribute("pasien", pasienService.getIdPasien(id_pasien));
			PengobatanInap pengobatanInap = new PengobatanInap();
			pengobatanInap.setId_pasien(id_pasien);
			model.addAttribute("pengobatanInap",pengobatanInap);
			model.addAttribute("dokter", dokterService.listDokter());
			return "pasien/formpengobataninap";
		}
		return "restricted";
	}

	@RequestMapping(value = "/detailpengobatan/createInap/{id_pasien}",params = "save", method = RequestMethod.POST)
	public String simpanDataPengobatanInap(Model model, PengobatanInap pengobatanInap ,@PathVariable Integer id_pasien, HttpServletRequest request){
		if (request.getSession().getAttribute("akunLogin") == null) {
			return "redirect:/SIRMJD";
		}
		Akun akun = new Akun();
		akun = (Akun) request.getSession().getAttribute("akunLogin");
		model.addAttribute("akun", akun);
		if(akun.getRole().equals("Admin") || akun.getRole().equals("Loket")){
			model.addAttribute("pengobatanInap", pengobatanInapService.saveorUpdate(pengobatanInap));
			if(pengobatanInap.getId_pengobatan_inap()==null){
				return "redirect:/datapengobataninap/"+pengobatanInapService.latest(id_pasien);
			}
			if(pengobatanInap.getId_pengobatan_inap()!=null){
				return "redirect:/datapengobataninap/"+pengobatanInap.getId_pengobatan_inap();
			}
			//			return "redirect:/detailpengobatan/"+id_pasien;
		}
		return "restricted";
	}

	@RequestMapping(value = "/detailpengobatan/createInap/{id_pasien}", params = "cancel", method = RequestMethod.POST)
	public String batalSimpanDataPengobatanInap(Model model, Pasien pasien, HttpServletRequest request){
		if (request.getSession().getAttribute("akunLogin") == null) {
			return "redirect:/SIRMJD";
		}
		Akun akun = new Akun();
		akun = (Akun) request.getSession().getAttribute("akunLogin");
		model.addAttribute("akun", akun);
		if(akun.getRole().equals("Admin") || akun.getRole().equals("Loket")){
			model.addAttribute("pasien", null);
			return "redirect:/detailpengobatan/"+pasien.getId_pasien();
		}
		return "restricted";
	}

	@RequestMapping(value ="/convert/{id_pengobatan_jalan}&{id_pasien}", method = RequestMethod.GET)
	public String convertRawatJalan(@PathVariable Integer id_pengobatan_jalan, @PathVariable Integer id_pasien, Model model, HttpServletRequest request){
		if (request.getSession().getAttribute("akunLogin") == null) {
			return "redirect:/SIRMJD";
		}
		Akun akun = new Akun();
		akun = (Akun) request.getSession().getAttribute("akunLogin");
		model.addAttribute("akun", akun);
		if(akun.getRole().equals("Admin") || akun.getRole().equals("Loket")){
			PengobatanJalan p = pengobatanJalanService.getPengobatanJalanForm(id_pengobatan_jalan);
			
			PengobatanInap pengobatanInap = new PengobatanInap();
			pengobatanInap.setId_pasien(id_pasien);
			
			model.addAttribute("convert","yes");
			model.addAttribute("pengobatan",p);
			model.addAttribute("pengobatanInap",pengobatanInap);
			model.addAttribute("dokter",dokterService.listDokter());
			model.addAttribute("now",pengobatanInapService.dateNow());
			return "pasien/formpengobataninap";
		}
		return "restricted";
	}
	
	@RequestMapping(value="/convert/{id_pasien}",params = "save", method = RequestMethod.POST)
	public String saveConvert(Model model, PengobatanInap pengobatanInap ,@PathVariable Integer id_pasien, HttpServletRequest request){
		if (request.getSession().getAttribute("akunLogin") == null) {
			return "redirect:/SIRMJD";
		}
		Akun akun = new Akun();
		akun = (Akun) request.getSession().getAttribute("akunLogin");
		model.addAttribute("akun", akun);
		if(akun.getRole().equals("Admin") || akun.getRole().equals("Loket")){
			model.addAttribute("pengobatanInap", pengobatanInapService.saveorUpdate(pengobatanInap));
			if(pengobatanInap.getId_pengobatan_inap()==null){
				return "redirect:/datapengobataninap/"+pengobatanInapService.latest(id_pasien);
			}
			if(pengobatanInap.getId_pengobatan_inap()!=null){
				return "redirect:/datapengobataninap/"+pengobatanInap.getId_pengobatan_inap();
			}
			//			return "redirect:/detailpengobatan/"+id_pasien;
		}
		return "restricted";
	}
	//	DATA PENGOBATAN JALAN =========================================================================================================

	@RequestMapping(value = "/datapengobatanjalan/{id_pengobatan_jalan}", method = RequestMethod.GET)
	public String dataPengobatanJalan(@PathVariable Integer id_pengobatan_jalan, Model model, HttpServletRequest request){		
		if (request.getSession().getAttribute("akunLogin") == null) {
			return "redirect:/SIRMJD";
		}
		Akun akun = new Akun();
		akun = (Akun) request.getSession().getAttribute("akunLogin");
		model.addAttribute("akun", akun);
		if(akun.getRole().equals("Admin") || akun.getRole().equals("Loket")){
			//			model.addAttribute("pasien", pasienService.getIdPasien(id_pasien));
			model.addAttribute("pengobatanJalan",pengobatanJalanService.getPengobatanJalan(id_pengobatan_jalan));
			return "pasien/datapengobatanjalan";
		}
		return "restricted";
	}

	@RequestMapping(value = "/datapengobatanjalan/edit/{id_pengobatan_jalan}&{id_pasien}", method = RequestMethod.GET)
	public String editDataPengobatanJalan(@PathVariable Integer id_pengobatan_jalan,@PathVariable Integer id_pasien, Model model, HttpServletRequest request){
		if (request.getSession().getAttribute("akunLogin") == null) {
			return "redirect:/SIRMJD";
		}
		Akun akun = new Akun();
		akun = (Akun) request.getSession().getAttribute("akunLogin");
		model.addAttribute("akun", akun);
		if(akun.getRole().equals("Admin") || akun.getRole().equals("Loket")){

			Integer id = pengobatanJalanService.getPengobatanJalanForm(id_pengobatan_jalan).getId_dokter_jalan();
			Dokter dok = dokterService.getIdDokter(id);

			model.addAttribute("pengobatanJalan",pengobatanJalanService.getPengobatanJalanForm(id_pengobatan_jalan));
			model.addAttribute("pasien",pasienService.getIdPasien(id_pasien));
			model.addAttribute("dokter", dokterService.listDokter());
			model.addAttribute("dok",dok);
			return "pasien/formpengobatanjalan";
		}
		return "restricted";
	}

	@RequestMapping(value = "/datapengobatanjalan/hapus/{id_pengobatan_jalan}&{id_pasien}", method = RequestMethod.GET)
	public String hapusDataPengobatanJalan(@PathVariable Integer id_pengobatan_jalan, @PathVariable Integer id_pasien, Model model, HttpServletRequest request){
		if (request.getSession().getAttribute("akunLogin") == null) {
			return "redirect:/SIRMJD";
		}
		Akun akun = new Akun();
		akun = (Akun) request.getSession().getAttribute("akunLogin");
		model.addAttribute("akun", akun);
		if(akun.getRole().equals("Admin") || akun.getRole().equals("Loket")){
			pengobatanJalanService.hapusPengobatanJalan(id_pengobatan_jalan);
			return "redirect:/detailpengobatan/{id_pasien}";
		}
		return "restricted";
	}


	//	DATA PENGOBATAN INAP ===========================================================================================================

	@RequestMapping(value = "/datapengobataninap/{id_pengobatan_inap}", method = RequestMethod.GET)
	public String dataPengobatanInap(@PathVariable Integer id_pengobatan_inap, Model model, HttpServletRequest request){
		if (request.getSession().getAttribute("akunLogin") == null) {
			return "redirect:/SIRMJD";
		}
		Akun akun = new Akun();
		akun = (Akun) request.getSession().getAttribute("akunLogin");
		model.addAttribute("akun", akun);
		if(akun.getRole().equals("Admin") || akun.getRole().equals("Loket")){
			model.addAttribute("pengobatanInap",pengobatanInapService.getViewPengobatanInap(id_pengobatan_inap));
			return "pasien/datapengobataninap";
		}
		return "restricted";
	}

	@RequestMapping(value = "/datapengobataninap/edit/{id_pengobatan_inap}&{id_pasien}", method = RequestMethod.GET)
	public String editDataPengobatanInap(@PathVariable Integer id_pengobatan_inap, @PathVariable Integer id_pasien, Model model, HttpServletRequest request){
		if (request.getSession().getAttribute("akunLogin") == null) {
			return "redirect:/SIRMJD";
		}
		Akun akun = new Akun();
		akun = (Akun) request.getSession().getAttribute("akunLogin");
		model.addAttribute("akun", akun);
		if(akun.getRole().equals("Admin") || akun.getRole().equals("Loket")){
			Integer id = pengobatanInapService.getPengobatanInap(id_pengobatan_inap).getId_dokter_inap();
			Dokter d = dokterService.getIdDokter(id);

			model.addAttribute("pengobatanInap",pengobatanInapService.getPengobatanInap(id_pengobatan_inap));
			model.addAttribute("pasien",pasienService.getIdPasien(id_pasien));
			model.addAttribute("dokter", dokterService.listDokter());
			model.addAttribute("dok",d);
			return "pasien/formpengobataninap";
		}
		return "restricted";
	}

	@RequestMapping(value = "/datapengobataninap/hapus/{id_pengobatan_inap}&{id_pasien}", method = RequestMethod.GET)
	public String hapusDataPengobatanInap(@PathVariable Integer id_pengobatan_inap, @PathVariable Integer id_pasien, Model model, HttpServletRequest request){
		if (request.getSession().getAttribute("akunLogin") == null) {
			return "redirect:/SIRMJD";
		}
		Akun akun = new Akun();
		akun = (Akun) request.getSession().getAttribute("akunLogin");
		model.addAttribute("akun", akun);
		if(akun.getRole().equals("Admin") || akun.getRole().equals("Loket")){
			pengobatanInapService.hapusPengobatanInap(id_pengobatan_inap);
			return "redirect:/detailpengobatan/{id_pasien}#inap";
		}
		return "restricted";
	}


}
