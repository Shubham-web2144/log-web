package com.lwp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.lwp.model.Contact;
import com.lwp.model.Content;
import com.lwp.model.Pages;
import com.lwp.repo.ContentRepo;
import com.lwp.service.ContactService;
import com.lwp.service.ContentService;

@Controller
public class MainController {
	
	@Autowired
	private ContentService service;
	
	@Autowired
	private ContactService contactService;
	
	@GetMapping(value = {"/", "", "/index", "/home"})
	public ModelAndView getIndex(Model model) {
		ModelAndView mv = new ModelAndView("index");
		Content air = service.getLatestContent(Pages.AIR_FREIGHT);
		Content ocean = service.getLatestContent(Pages.OCAN_FREIGHT);
		Content core = service.getLatestContent(Pages.CORE_VALUES);
		model.addAttribute("air", air);
		model.addAttribute("ocean", ocean);
		model.addAttribute("core", core);
		return mv;
	}
	
	@GetMapping("/air")
	public ModelAndView getAirPage(Model model) {
		ModelAndView mv = new ModelAndView("pages/air");
		Content latestContent = service.getLatestContent(Pages.AIR_FREIGHT);
		model.addAttribute("content", latestContent);
		return mv;
	}
	
	@GetMapping("/consult")
	public ModelAndView getConsultPage(Model model) {
		ModelAndView mv = new ModelAndView("pages/consult");
		Content latestContent = service.getLatestContent(Pages.CONSULTING_IMPL);
		model.addAttribute("content", latestContent);
		return mv;
	}
	@GetMapping("/contact")
	public ModelAndView getContactPage(Model model) {
		ModelAndView mv = new ModelAndView("pages/contact");
		List<Contact> allContacts = contactService.getAllContacts();
		model.addAttribute("contacts", allContacts);
		return mv;
	}
	@GetMapping("/corevalues")
	public ModelAndView getCoreValuePage(Model model) {
		ModelAndView mv = new ModelAndView("pages/core-values");
		Content latestContent = service.getLatestContent(Pages.CORE_VALUES);
		model.addAttribute("contetn", latestContent);
		return mv;
	}
	@GetMapping("/custome")
	public ModelAndView getCustomePage(Model model) {
		ModelAndView mv = new ModelAndView("pages/custome");
		Content latestContent = service.getLatestContent(Pages.CUSTOME_CLEARANCE);
		model.addAttribute("content", latestContent);
		return mv;
	}
	@GetMapping("/management")
	public ModelAndView getManagementPage(Model model) {
		ModelAndView mv = new ModelAndView("pages/management");
		Content latestContent = service.getLatestContent(Pages.MANGEMENT);
		model.addAttribute("content", latestContent);
		return mv;
	}
	@GetMapping("/ocean")
	public ModelAndView getOceanPage(Model model) {
		ModelAndView mv = new ModelAndView("pages/ocean");
		Content latestContent = service.getLatestContent(Pages.OCAN_FREIGHT);
		model.addAttribute("content", latestContent);
		return mv;
	}
	@GetMapping("/pms")
	public ModelAndView getPmsPage(Model model) {
		ModelAndView mv = new ModelAndView("pages/pms");
		Content latestContent = service.getLatestContent(Pages.PROJECT_SOLUTION_MANAGEMENT);
		model.addAttribute("content", latestContent);
		return mv;
	}
	@GetMapping("/ptm")
	public ModelAndView getPtmPage(Model model) {
		ModelAndView mv = new ModelAndView("pages/ptm");
		Content latestContent = service.getLatestContent(Pages.PROJECT_TRANSPORT_MANAGEMENT);
		model.addAttribute("content", latestContent);
		return mv;
	}
	@GetMapping("/sustain")
	public ModelAndView getSustainPage(Model model) {
		ModelAndView mv = new ModelAndView("pages/sustain");
		Content latestContent = service.getLatestContent(Pages.SUSTAINABILITY);
		model.addAttribute("content", latestContent);
		return mv;
	}
	@GetMapping("/vision-mission")
	public ModelAndView getVisionMissionPage(Model model) {
		ModelAndView mv = new ModelAndView("pages/vision-mission");
		Content latestContent = service.getLatestContent(Pages.VISION_MISSION);
		model.addAttribute("content", latestContent);
		return mv;
	}
	@GetMapping("/companyoverview")
	public ModelAndView getCOverPage(Model model) {
		ModelAndView mv = new ModelAndView("pages/c-overview");
		Content latestContent = service.getLatestContent(Pages.COMPANY_OVERVIEW);
		model.addAttribute("content", latestContent);
		return mv;
	}
}

