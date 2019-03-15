package com.rsporsea.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rsporsea.model.Akun;
import com.rsporsea.service.AkunService;

@Controller
public class IndexController {

	@Autowired
	private AkunService akunService;
	private Akun akunLogin;

	@RequestMapping(value="/SIRMJD")
	public String loginPage(HttpServletRequest request, Model model){
		model.addAttribute("status",request.getSession().getAttribute("loginstatus"));
		return "login";
	}

	@RequestMapping("/restrict")
	public String restrictedPage(){
		return "restricted";
	}

	@RequestMapping(value = "/SIRMJD", method = RequestMethod.POST)
	public String loginProcess(HttpServletRequest request){
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if(akunService.login(username, password) != null){
			request.getSession().setAttribute("akunLogin", akunService.login(username, password));
			akunLogin = (Akun) request.getSession().getAttribute("akunLogin");
			if(akunLogin.getRole().equals("Admin")){
				return "redirect:/beranda";	
			}else if(akunLogin.getRole().equals("RekamMedik") || akunLogin.getRole().equals("Loket") || akunLogin.getRole().equals("TataUsaha")){
				return "redirect:/beranda";
			}
		}
		request.getSession().setAttribute("loginstatus", "Failed");
		return "redirect:/SIRMJD";
	}

	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:/SIRMJD";
	}

	
	
//	SSO ##########################################################################################################################
	
	@RequestMapping("/sso")
	public String sso(HttpServletRequest request, Model model) {
		if (request.getSession().getAttribute("akunLogin") == null) {
			return "redirect:/SIRMJD";
		}
		Akun akun = new Akun();
		akun = (Akun) request.getSession().getAttribute("akunLogin");
		model.addAttribute("akun", akun);
		if(akun.getRole().equals("Admin")){
			model.addAttribute("allakun",akunService.getAllAkun());
			return "sso";
		}
		return "restricted";
	}
	
	@RequestMapping(value="/sso/new", method= RequestMethod.GET)
	public String ssoForm(HttpServletRequest request, Model model) {
		if (request.getSession().getAttribute("akunLogin") == null) {
			return "redirect:/SIRMJD";
		}
		Akun akun = new Akun();
		akun = (Akun) request.getSession().getAttribute("akunLogin");
		model.addAttribute("akun", akun);
		if(akun.getRole().equals("Admin")){
			model.addAttribute("akun",new Akun());
			return "sso_form";
		}
		return "restricted";
	}
	
	@RequestMapping(value="/sso/new",params="save", method= RequestMethod.POST)
	public String ssoSave(HttpServletRequest request, Model model, Akun akuns) {
		if (request.getSession().getAttribute("akunLogin") == null) {
			return "redirect:/SIRMJD";
		}
		Akun akun = new Akun();
		akun = (Akun) request.getSession().getAttribute("akunLogin");
		model.addAttribute("akun", akun);
		if(akun.getRole().equals("Admin")){
			model.addAttribute("akun",akunService.saveOrUpdate(akuns));
			return "redirect:/sso";
		}
		return "restricted";
	}
	
	@RequestMapping(value="/sso/new",params="cancel", method= RequestMethod.POST)
	public String ssoCancel(HttpServletRequest request, Model model, Akun akuns) {
		if (request.getSession().getAttribute("akunLogin") == null) {
			return "redirect:/SIRMJD";
		}
		Akun akun = new Akun();
		akun = (Akun) request.getSession().getAttribute("akunLogin");
		model.addAttribute("akun", akun);
		if(akun.getRole().equals("Admin")){
			model.addAttribute("akun",null);
			return "redirect:/sso";
		}
		return "restricted";
	}
	
	@RequestMapping(value="/sso/edit/{id_akun}", method= RequestMethod.GET)
	public String ssoEdit(HttpServletRequest request, Model model, @PathVariable Integer id_akun) {
		if (request.getSession().getAttribute("akunLogin") == null) {
			return "redirect:/SIRMJD";
		}
		Akun akun = new Akun();
		akun = (Akun) request.getSession().getAttribute("akunLogin");
		model.addAttribute("akun", akun);
		if(akun.getRole().equals("Admin")){
			model.addAttribute("akun",akunService.getAkun(id_akun));
			return "sso_form";
		}
		return "restricted";
	}
	
	@RequestMapping(value="/sso/delete/{id_akun}")
	public String ssoDelete(HttpServletRequest request, Model model, @PathVariable Integer id_akun) {
		if (request.getSession().getAttribute("akunLogin") == null) {
			return "redirect:/SIRMJD";
		}
		Akun akun = new Akun();
		akun = (Akun) request.getSession().getAttribute("akunLogin");
		model.addAttribute("akun", akun);
		if(akun.getRole().equals("Admin")){
			akunService.delete(id_akun);
			return "redirect:/sso";
		}
		return "restricted";
	}
	
	
}
