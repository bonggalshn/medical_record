package com.rsporsea.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rsporsea.service.JadwalService;
import com.rsporsea.model.Akun;
import com.rsporsea.service.JadwalPenggantiService;

@Controller
public class BerandaController {
	
	private JadwalService jadwalService;
	private JadwalPenggantiService jadwalPenggantiService;
	
	@Autowired	
	public void setJadwalService(JadwalService jadwalService){
		this.jadwalService = jadwalService;
	}
	
	@Autowired
	public void setJadwalPenggantiService(JadwalPenggantiService jadwalPenggantiService){
		this.jadwalPenggantiService = jadwalPenggantiService;
	}
	
	@RequestMapping(value = "/beranda")
	public String beranda(HttpServletRequest request, Model model){
		if (request.getSession().getAttribute("akunLogin") == null) {
			return "redirect:/SIRMJD";
		}
		Akun akun = new Akun();
		akun = (Akun) request.getSession().getAttribute("akunLogin");
		model.addAttribute("akun", akun);
		
		model.addAttribute("jadwal", jadwalService.listJadwalSp());
		model.addAttribute("jadwalumum", jadwalService.listJadwalUm());
		model.addAttribute("pengganti", jadwalPenggantiService.listJadwalPengganti());
		return "beranda";
	}

}
