package com.rsporsea.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rsporsea.model.Akun;
import com.rsporsea.service.PasienService;
import com.rsporsea.service.RekamMedikPenyakitJalanService;
import com.rsporsea.service.RekamMedikPenyakitInapService;

@Controller
public class RekammedikController {
	private RekamMedikPenyakitJalanService rekamMedikPenyakitJalanService;
	private RekamMedikPenyakitInapService rekamMedikPenyakitInapService;
	private PasienService pasienService;

	@Autowired	
	public void setPasienService(PasienService pasienService) {
		this.pasienService = pasienService;
	}

	@Autowired
	public void setRekamMedikPenyakitJalanService(RekamMedikPenyakitJalanService rekamMedikPenyakitJalanService){
		this.rekamMedikPenyakitJalanService = rekamMedikPenyakitJalanService;
	}

	@Autowired
	public void setRekamMedikPenyakitInapService(RekamMedikPenyakitInapService rekamMedikPenyakitInapService){
		this.rekamMedikPenyakitInapService = rekamMedikPenyakitInapService;
	}

	@RequestMapping("/rekammedik")
	public String rekammedik(HttpServletRequest request, Model model){		
		if (request.getSession().getAttribute("akunLogin") == null) {
			return "redirect:/SIRMJD";
		}
		Akun akun = new Akun();
		akun = (Akun) request.getSession().getAttribute("akunLogin");
		model.addAttribute("akun", akun);
		if(akun.getRole().equals("Admin") || akun.getRole().equals("RekamMedik")){
			model.addAttribute("laporan",rekamMedikPenyakitJalanService.listLaporan());
			model.addAttribute("laporaninap",rekamMedikPenyakitInapService.listLaporan());
			model.addAttribute("linechartjalan",rekamMedikPenyakitJalanService.listJumlah());
			model.addAttribute("linechartinap",rekamMedikPenyakitInapService.listJumlah());
			model.addAttribute("jkjalan",rekamMedikPenyakitJalanService.JenisKelamin());
			model.addAttribute("jkinap",rekamMedikPenyakitInapService.JenisKelamin());
			//			model.addAttribute("tahun","2018");
			return "rekammedik/rekammedik";
		}
		return "restricted";
	}

	@RequestMapping(value="/rekammedik_penyakit")
	public String rekammedikPenyakit(HttpServletRequest request, Model model){
		if (request.getSession().getAttribute("akunLogin") == null) {
			return "redirect:/SIRMJD";
		}
		Akun akun = new Akun();
		akun = (Akun) request.getSession().getAttribute("akunLogin");
		model.addAttribute("akun", akun);
		if(akun.getRole().equals("Admin") || akun.getRole().equals("RekamMedik")){
			model.addAttribute("rmjalan",rekamMedikPenyakitJalanService.listPenyakit());
			model.addAttribute("rminap",rekamMedikPenyakitInapService.listPenyakit());
			model.addAttribute("pertahuninap", rekamMedikPenyakitInapService.penyakitPerTahun());
			model.addAttribute("totalinap", rekamMedikPenyakitInapService.totalPenyakit());
			model.addAttribute("pertahunjalan",rekamMedikPenyakitJalanService.penyakitPerTahun());
			model.addAttribute("totaljalan",rekamMedikPenyakitJalanService.totalPenyakit());
			return "rekammedik/rekammedik_penyakit";
		}
		return "restricted";
	}

	@RequestMapping("/rekammedik_pasien")
	public String rekammedikPasien(HttpServletRequest request, Model model){
		if (request.getSession().getAttribute("akunLogin") == null) {
			return "redirect:/SIRMJD";
		}
		Akun akun = new Akun();
		akun = (Akun) request.getSession().getAttribute("akunLogin");
		model.addAttribute("akun", akun);
		if(akun.getRole().equals("Admin") || akun.getRole().equals("RekamMedik")){
			model.addAttribute("total",pasienService.totalpasien());
			model.addAttribute("pasien",pasienService.listPasien());
			return "rekammedik/rekammedik_pasien";
		}
		return "restricted";
	}
}
