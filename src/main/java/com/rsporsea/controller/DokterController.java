package com.rsporsea.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.rsporsea.model.Akun;
import com.rsporsea.model.Dokter;
//import com.rsporsea.model.Jadwal;
import com.rsporsea.model.jadwal_dokter;
import com.rsporsea.model.Pengganti;
//import com.rsporsea.service.AkunService;
import com.rsporsea.service.DokterService;
import com.rsporsea.service.JadwalService;
import com.rsporsea.service.JadwalPenggantiService;

@Controller
public class DokterController {

	//	private AkunService akunService;
	//	private Akun akunLogin;

	private DokterService dokterService;
	private JadwalService jadwalService;
	private JadwalPenggantiService jadwalPenggantiService;

	@Autowired	
	public void setDokterService(DokterService dokterService) {
		this.dokterService = dokterService;
	}

	@Autowired
	public void setJadwalService(JadwalService jadwalService){
		this.jadwalService = jadwalService;
	}

	@Autowired	
	public void setJadwalPenggantiService(JadwalPenggantiService jadwalPenggantiService) {
		this.jadwalPenggantiService = jadwalPenggantiService;
	}

	//	DOKTER =======================================================================================================================

	//	@RequestMapping("/dokter?q=")
	//	public String DokterList(Model model, HttpServletRequest request){
	//		if (request.getSession().getAttribute("akunLogin") == null) {
	//			return "redirect:/SIRMJD";
	//		}
	//		Akun akun = new Akun();
	//		akun = (Akun) request.getSession().getAttribute("akunLogin");
	//		model.addAttribute("akun", akun);
	//		if(akun.getRole().equals("Admin") || akun.getRole().equals("TataUsaha")){
	//			model.addAttribute("dokter", dokterService.listDokter());
	//			return "dokter/dokter";
	//		}
	//		return "restricted";
	//	}


	@RequestMapping(value="/dokter", method=RequestMethod.GET)
	public String DokterLista(Model model,@RequestParam(value="q") String dokter ,HttpServletRequest request){
		if (request.getSession().getAttribute("akunLogin") == null) {
			return "redirect:/SIRMJD";
		}
		Akun akun = new Akun();
		akun = (Akun) request.getSession().getAttribute("akunLogin");
		model.addAttribute("akun", akun);
		if(akun.getRole().equals("Admin") || akun.getRole().equals("TataUsaha")){
			model.addAttribute("dokter", dokterService.search(dokter));
			return "dokter/dokter";
		}
		return "restricted";
	}


	@RequestMapping(value = "/dokter", method = RequestMethod.POST)
	public String tampilkaanDataDokter(Model model,@RequestParam(value="q", required=false) String dokter, HttpServletRequest request){
		if (request.getSession().getAttribute("akunLogin") == null) {
			return "redirect:/SIRMJD";
		}
		Akun akun = new Akun();
		akun = (Akun) request.getSession().getAttribute("akunLogin");
		model.addAttribute("akun", akun);
		if(akun.getRole().equals("Admin") || akun.getRole().equals("TataUsaha")){
			model.addAttribute("dokter", dokterService.search(dokter));
			return "return:/dokter";
		}
		return "restricted";
	}

	@RequestMapping(value = "/dokter/new", method = RequestMethod.GET)
	public String tampilkanFormDokter(Model model, HttpServletRequest request){
		if (request.getSession().getAttribute("akunLogin") == null) {
			return "redirect:/SIRMJD";
		}
		Akun akun = new Akun();
		akun = (Akun) request.getSession().getAttribute("akunLogin");
		model.addAttribute("akun", akun);
		if(akun.getRole().equals("Admin") || akun.getRole().equals("TataUsaha")){
			model.addAttribute("dokter", new Dokter());
			return "dokter/formDokter";
		}
		return "restricted";
	}

	@RequestMapping(value = "/dokter/new",params ="save", method = RequestMethod.POST)
	public String simpanDataDokter(Model model, Dokter dokter, HttpServletRequest request){
		if (request.getSession().getAttribute("akunLogin") == null) {
			return "redirect:/SIRMJD";
		}
		Akun akun = new Akun();
		akun = (Akun) request.getSession().getAttribute("akunLogin");
		model.addAttribute("akun", akun);
		if(akun.getRole().equals("Admin") || akun.getRole().equals("TataUsaha")){
			model.addAttribute("dokter", dokterService.saveorUpdate(dokter));
			if(dokter.getId_dokter()==null){
				return "redirect:/detaildokter/"+dokterService.latest();				
			}
			if(dokter.getId_dokter()!=null){
				return "redirect:/detaildokter/"+dokter.getId_dokter();
			}
//			return "redirect:/dokter?q=";
		}
		return "restricted";
	}

	@RequestMapping(value = "/dokter/new", params = "cancel", method = RequestMethod.POST)
	public String cancelUpdateUser(HttpServletRequest request, Model model) {
		if (request.getSession().getAttribute("akunLogin") == null) {
			return "redirect:/SIRMJD";
		}
		Akun akun = new Akun();
		akun = (Akun) request.getSession().getAttribute("akunLogin");
		model.addAttribute("akun", akun);
		if(akun.getRole().equals("Admin") || akun.getRole().equals("TataUsaha")){
			model.addAttribute("dokter", null);
			return "redirect:/dokter?q=";
		}
		return "restricted";
	}

	@RequestMapping(value = "/dokter/edit/{id_dokter}", method = RequestMethod.GET)
	public String editData(@PathVariable Integer id_dokter, Model model, HttpServletRequest request){
		if (request.getSession().getAttribute("akunLogin") == null) {
			return "redirect:/SIRMJD";
		}
		Akun akun = new Akun();
		akun = (Akun) request.getSession().getAttribute("akunLogin");
		model.addAttribute("akun", akun);
		if(akun.getRole().equals("Admin") || akun.getRole().equals("TataUsaha")){
			model.addAttribute("dokter", dokterService.getIdDokter(id_dokter));
			return "dokter/formDokter";	
		}
		return "restricted";
	}

	@RequestMapping(value = "/dokter/hapus/{id_dokter}")
	public String hapusData(@PathVariable Integer id_dokter, HttpServletRequest request, Model model){
		if (request.getSession().getAttribute("akunLogin") == null) {
			return "redirect:/SIRMJD";
		}
		Akun akun = new Akun();
		akun = (Akun) request.getSession().getAttribute("akunLogin");
		model.addAttribute("akun", akun);
		if(akun.getRole().equals("Admin") || akun.getRole().equals("TataUsaha")){
			dokterService.hapusDokter(id_dokter);
			return "redirect:/dokter?q=";
		}
		return "restricted";
	}


	//	DETAIL DOKTER ===============================================================================================================

	@RequestMapping(value = "/detaildokter/{id_dokter}", method = RequestMethod.GET)
	public String detailDokter(@PathVariable Integer id_dokter, Model model, HttpServletRequest request){
		if (request.getSession().getAttribute("akunLogin") == null) {
			return "redirect:/SIRMJD";
		}
		Akun akun = new Akun();
		akun = (Akun) request.getSession().getAttribute("akunLogin");
		model.addAttribute("akun", akun);
		if(akun.getRole().equals("Admin") || akun.getRole().equals("TataUsaha")){
			model.addAttribute("dokter", dokterService.getIdDokter(id_dokter));
			model.addAttribute("jadwal", jadwalService.getJadwalbyDokter(id_dokter));
			return "dokter/detaildokter";			
		}
		return "restricted";
	}


	//	JADWAL DOKTER ===============================================================================================================

//	@RequestMapping("/jadwaldokter")
//	public String JadwalDokter(Model model, HttpServletRequest request){
//		if (request.getSession().getAttribute("akunLogin") == null) {
//			return "redirect:/SIRMJD";
//		}
//		Akun akun = new Akun();
//		akun = (Akun) request.getSession().getAttribute("akunLogin");
//		model.addAttribute("akun", akun);
//		if(akun.getRole().equals("Admin") || akun.getRole().equals("TataUsaha")){
//			model.addAttribute("jadwal", jadwalService.listJadwalSpesialis());
//			model.addAttribute("jadwalumum", jadwalService.listJadwalUmum());
//			return "dokter/jadwaldokter";
//
//		}
//		return "restricted";
//	}

	@RequestMapping(value = "/jadwaldokter/new", method = RequestMethod.GET)
	public String tampilkanFormJadwal(Model model, HttpServletRequest request){
		if (request.getSession().getAttribute("akunLogin") == null) {
			return "redirect:/SIRMJD";
		}
		Akun akun = new Akun();
		akun = (Akun) request.getSession().getAttribute("akunLogin");
		model.addAttribute("akun", akun);
		if(akun.getRole().equals("Admin") || akun.getRole().equals("TataUsaha")){
			model.addAttribute("dokter", dokterService.listDokter());
			model.addAttribute("jadwal", new jadwal_dokter());
			return "dokter/formJadwal";

		}
		return "restricted";
	}

	@RequestMapping(value = "/jadwaldokter/new",params ="save", method = RequestMethod.POST)
	public String simpanJadwal(Model model, jadwal_dokter jadwal, HttpServletRequest request){
		if (request.getSession().getAttribute("akunLogin") == null) {
			return "redirect:/SIRMJD";
		}
		Akun akun = new Akun();
		akun = (Akun) request.getSession().getAttribute("akunLogin");
		model.addAttribute("akun", akun);
		if(akun.getRole().equals("Admin") || akun.getRole().equals("TataUsaha")){
			String check = jadwalService.checkJadwal(jadwal);
			model.addAttribute("check", check);
			if(check=="not OK"){
//				return "redirect:/jadwaldokter/new";
				return "dokter/popup";
			}
			if(check=="OK"){
				model.addAttribute("jadwal", jadwalService.saveorUpdate(jadwal));
				if(jadwal.getId_jadwal()!=null){
					return "redirect:/jadwaldokter/detail/"+jadwal.getId_jadwal();
				}
				if(jadwal.getId_jadwal()==null){
					return "redirect:/jadwaldokter/detail/"+jadwalService.latest();
				}
			}
			
			return "restricted";

		}
		return "restricted";
	}

	@RequestMapping(value = "/jadwaldokter/new", params = "cancel", method = RequestMethod.POST)
	public String cancelJadwal(HttpServletRequest request, Model model) {
		if (request.getSession().getAttribute("akunLogin") == null) {
			return "redirect:/SIRMJD";
		}
		Akun akun = new Akun();
		akun = (Akun) request.getSession().getAttribute("akunLogin");
		model.addAttribute("akun", akun);
		if(akun.getRole().equals("Admin") || akun.getRole().equals("TataUsaha")){
			model.addAttribute("jadwal", null);
			return "redirect:/jadwaldokter";

		}
		return "restricted";
	}

	@RequestMapping(value = "/jadwaldokter/edit/{id_jadwal}", method = RequestMethod.GET)
	public String editDataJadwal(@PathVariable Integer id_jadwal, Model model, HttpServletRequest request){
		if (request.getSession().getAttribute("akunLogin") == null) {
			return "redirect:/SIRMJD";
		}
		Akun akun = new Akun();
		akun = (Akun) request.getSession().getAttribute("akunLogin");
		model.addAttribute("akun", akun);
		if(akun.getRole().equals("Admin") || akun.getRole().equals("TataUsaha")){
			model.addAttribute("dokter", dokterService.listDokter());
			model.addAttribute("jadwal",jadwalService.getIdJadwal(id_jadwal));
			return "dokter/formJadwal";
		}
		return "restricted";
	}

	@RequestMapping(value = "/jadwaldokter/hapus/{id_jadwal}")
	public String hapusJadwal(@PathVariable Integer id_jadwal, HttpServletRequest request, Model model){
		if (request.getSession().getAttribute("akunLogin") == null) {
			return "redirect:/SIRMJD";
		}
		Akun akun = new Akun();
		akun = (Akun) request.getSession().getAttribute("akunLogin");
		model.addAttribute("akun", akun);
		if(akun.getRole().equals("Admin") || akun.getRole().equals("TataUsaha")){
			jadwalService.hapusJadwal(id_jadwal);
			return "redirect:/jadwaldokter";

		}
		return "restricted";
	}


	//	JADWAL PENGGANTI =============================================================================================================

	@RequestMapping("/jadwalpengganti")
	public String JadwalPengganti(Model model, HttpServletRequest request){
		if (request.getSession().getAttribute("akunLogin") == null) {
			return "redirect:/SIRMJD";
		}
		Akun akun = new Akun();
		akun = (Akun) request.getSession().getAttribute("akunLogin");
		model.addAttribute("akun", akun);
		if(akun.getRole().equals("Admin") || akun.getRole().equals("TataUsaha")){
			model.addAttribute("pengganti", jadwalPenggantiService.listJadwalPengganti());
			return "dokter/jadwaldokterpengganti";
		}
		return "restricted";
	}

	@RequestMapping(value = "/jadwalpengganti/new/{id_jadwal}", method = RequestMethod.GET)
	public String tampilkanFormJadwalPengganti(Model model, HttpServletRequest request, @PathVariable Integer id_jadwal){
		if (request.getSession().getAttribute("akunLogin") == null) {
			return "redirect:/SIRMJD";
		}
		Akun akun = new Akun();
		akun = (Akun) request.getSession().getAttribute("akunLogin");
		model.addAttribute("akun", akun);
		if(akun.getRole().equals("Admin") || akun.getRole().equals("TataUsaha")){
			
			jadwal_dokter j = jadwalService.getIdJadwal(id_jadwal);
			Dokter dok = dokterService.getIdDokter(j.getNama_dokter());
			
			model.addAttribute("jadwal",jadwalService.getIdJadwal(id_jadwal));
			model.addAttribute("j",j);
			model.addAttribute("pengganti", new Pengganti());
			model.addAttribute("dokter", dokterService.listDokterbySp(dok.getSpesialis_dokter()));	
			
			model.addAttribute("dokterdata",dok);
			return "dokter/formJadwalPengganti";

		}
		return "restricted";
	}

	@RequestMapping(value = "/jadwalpengganti/new",params ="save", method = RequestMethod.POST)
	public String simpanJadwalPengganti(Model model, Pengganti jadwalPengganti, HttpServletRequest request){
		if (request.getSession().getAttribute("akunLogin") == null) {
			return "redirect:/SIRMJD";
		}
		Akun akun = new Akun();
		akun = (Akun) request.getSession().getAttribute("akunLogin");
		model.addAttribute("akun", akun);
		if(akun.getRole().equals("Admin") || akun.getRole().equals("TataUsaha")){
			model.addAttribute("pengganti", jadwalPenggantiService.saveorUpdate(jadwalPengganti));
			if(jadwalPengganti.getId_jadwal_pengganti()==null){
				return "redirect:/jadwalpengganti/detail/"+jadwalPenggantiService.latest();
			}
			if(jadwalPengganti.getId_jadwal_pengganti()!=null){
				return "redirect:/jadwalpengganti/detail/"+jadwalPengganti.getId_jadwal_pengganti();
			}
//			return "redirect:/jadwalpengganti";
		}
		return "restricted";
	}

	@RequestMapping(value = "/jadwalpengganti/new", params = "cancel", method = RequestMethod.POST)
	public String cancelJadwalPengganti(HttpServletRequest request, Model model) {
		if (request.getSession().getAttribute("akunLogin") == null) {
			return "redirect:/SIRMJD";
		}
		Akun akun = new Akun();
		akun = (Akun) request.getSession().getAttribute("akunLogin");
		model.addAttribute("akun", akun);
		if(akun.getRole().equals("Admin") || akun.getRole().equals("TataUsaha")){
			model.addAttribute("pengganti", null);
			return "redirect:/jadwalpengganti";
		}
		return "restricted";
	}

	@RequestMapping(value = "/jadwalpengganti/edit/{id_jadwal_pengganti}", method = RequestMethod.GET)
	public String editDataJadwalPengganti(@PathVariable Integer id_jadwal_pengganti, Model model, HttpServletRequest request){
		if (request.getSession().getAttribute("akunLogin") == null) {
			return "redirect:/SIRMJD";
		}
		Akun akun = new Akun();
		akun = (Akun) request.getSession().getAttribute("akunLogin");
		model.addAttribute("akun", akun);
		if(akun.getRole().equals("Admin") || akun.getRole().equals("TataUsaha")){
			Pengganti p = jadwalPenggantiService.getIdJadwalPengganti(id_jadwal_pengganti);
			Integer id = p.getDokter_berhalangan();
			Dokter d = dokterService.getIdDokter(id);
			
			model.addAttribute("pengganti",jadwalPenggantiService.getIdJadwalPengganti(id_jadwal_pengganti));
			model.addAttribute("pengganti2",jadwalPenggantiService.getViewJadwalPengganti(id_jadwal_pengganti));
//			model.addAttribute("dokter", dokterService.listDokter());
			model.addAttribute("dokter", dokterService.listDokterbySp(d.getSpesialis_dokter()));
			return "dokter/formJadwalPengganti";
		}
		return "restricted";
	}

	@RequestMapping(value = "/jadwalpengganti/hapus/{id_jadwal_pengganti}")
	public String hapusJadwalPengganti(@PathVariable Integer id_jadwal_pengganti, HttpServletRequest request, Model model){
		if (request.getSession().getAttribute("akunLogin") == null) {
			return "redirect:/SIRMJD";
		}
		Akun akun = new Akun();
		akun = (Akun) request.getSession().getAttribute("akunLogin");
		model.addAttribute("akun", akun);
		if(akun.getRole().equals("Admin") || akun.getRole().equals("TataUsaha")){
			jadwalPenggantiService.hapusJadwalPengganti(id_jadwal_pengganti);
			return "redirect:/jadwalpengganti";
		}
		return "restricted";
	}

	@RequestMapping(value = "/jadwalpengganti/detail/{id_jadwal_pengganti}")
	public String detailJadwalPengganti(@PathVariable Integer id_jadwal_pengganti, Model model, HttpServletRequest request){
		if (request.getSession().getAttribute("akunLogin") == null) {
			return "redirect:/SIRMJD";
		}
		Akun akun = new Akun();
		akun = (Akun) request.getSession().getAttribute("akunLogin");
		model.addAttribute("akun", akun);
		if(akun.getRole().equals("Admin") || akun.getRole().equals("TataUsaha")){
			model.addAttribute("pengganti",jadwalPenggantiService.getViewJadwalPengganti(id_jadwal_pengganti));
			return "dokter/detailjadwalpengganti";
		}
		return "restricted";
	}


	//	DETAIL JADWAL =========================================================================================================================
	@RequestMapping(value = "/jadwaldokter/detail/{id_jadwal}")
	public String detailJadwal(@PathVariable Integer id_jadwal, Model model, HttpServletRequest request){
		if (request.getSession().getAttribute("akunLogin") == null) {
			return "redirect:/SIRMJD";
		}
		Akun akun = new Akun();
		akun = (Akun) request.getSession().getAttribute("akunLogin");
		model.addAttribute("akun", akun);
		if(akun.getRole().equals("Admin") || akun.getRole().equals("TataUsaha")){
			model.addAttribute("jadwaldetail",jadwalService.getViewJadwal(id_jadwal));
			return "dokter/detailjadwal";
		}
		return "restricted";
	}
	
//	JADWAL DOKTER 2 =========================================================================================================================
	@RequestMapping("/jadwaldokter")
	public String tampilkanJadwalDokter(Model model, HttpServletRequest request){
		if (request.getSession().getAttribute("akunLogin") == null) {
			return "redirect:/SIRMJD";
		}
		Akun akun = new Akun();
		akun = (Akun) request.getSession().getAttribute("akunLogin");
		model.addAttribute("akun", akun);
		if(akun.getRole().equals("Admin") || akun.getRole().equals("TataUsaha")){
			model.addAttribute("spjadwal", jadwalService.listJadwalSp());
//			model.addAttribute("spjadwalselasa", jadwalService.listJadwalSp("selasa"));
//			model.addAttribute("spjadwalrabu", jadwalService.listJadwalSp("rabu"));
//			model.addAttribute("spjadwalkamis", jadwalService.listJadwalSp("kamis"));
//			model.addAttribute("spjadwaljumat", jadwalService.listJadwalSp("jumat"));
//			model.addAttribute("spjadwalsabtu", jadwalService.listJadwalSp("sabtu"));
//			model.addAttribute("spjadwalminggu", jadwalService.listJadwalSp("minggu"));
//			
			model.addAttribute("umjadwal", jadwalService.listJadwalUm());
//			model.addAttribute("umjadwalselasa", jadwalService.listJadwalUm("selasa"));
//			model.addAttribute("umjadwalrabu", jadwalService.listJadwalUm("rabu"));
//			model.addAttribute("umjadwalkamis", jadwalService.listJadwalUm("kamis"));
//			model.addAttribute("umjadwaljumat", jadwalService.listJadwalUm("jumat"));
//			model.addAttribute("umjadwalsabtu", jadwalService.listJadwalUm("sabtu"));
//			model.addAttribute("umjadwalminggu", jadwalService.listJadwalUm("minggu"));
			return "dokter/jadwaldokter";

		}
		return "restricted";
	}

}
