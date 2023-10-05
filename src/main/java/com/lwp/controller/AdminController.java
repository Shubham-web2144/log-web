package com.lwp.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.lwp.model.Contact;
import com.lwp.model.Content;
import com.lwp.model.Pages;
import com.lwp.model.User;
import com.lwp.repo.ContentRepo;
import com.lwp.repo.UserRepo;
import com.lwp.service.ContactService;
import com.lwp.service.ContentService;
import com.lwp.util.UploadImag;

import jakarta.servlet.http.HttpSession;

@Controller
public class AdminController {

	@Autowired
	private UserRepo repo;

	@Autowired
	private ContentService service;
	
	@Autowired
	private ContactService contactService;

	@RequestMapping("/admin-login")
	public ModelAndView getAdminLoginPage(Model model) {
		ModelAndView mv = new ModelAndView("pages/admin/admin-login");
		return mv;
	}

	@PostMapping("/handle-login")
	public ModelAndView handleLoginPage(Model model, @RequestParam("username") String username,
			@RequestParam("password") String password, HttpSession session) {
		
		User user = repo.findById(1).get();
		
		if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
			ModelAndView mv = new ModelAndView("pages/admin/admin-home");
			session.setAttribute("user", "admin");
			model.addAttribute("content", new Content());
			model.addAttribute("pages", Pages.values());
			model.addAttribute("contact",new Contact());
			model.addAttribute("contacts", contactService.getAllContacts());
			System.out.println(mv.getViewName() + ":  ");
			return mv;
		}
		ModelAndView mv = new ModelAndView();
		model.addAttribute("msg", "Username & password incorrect");
		mv.setViewName("pages/admin/admin-login");
		return mv;

	}

	@RequestMapping("/admin-home")
	public ModelAndView getAdminHomePage(HttpSession session, Model model) {
		ModelAndView mv = new ModelAndView();
		if (session.getAttribute("user") != null) {
			mv.setViewName("pages/admin/admin-home");
			model.addAttribute("content", new Content());
			model.addAttribute("pages", Pages.values());
			model.addAttribute("isReset",false);
			model.addAttribute("contact",new Contact());
			model.addAttribute("contacts", contactService.getAllContacts());
			
		} else {
			mv.setViewName("pages/admin/admin-login");
		}
		return mv;
	}

	// update co content
	@PostMapping("/update-content")
	public String updateCompanyOverview(@ModelAttribute("content") Content content,
			@RequestParam("pageTxt") Pages page, @RequestParam("image") MultipartFile image, Model model,
			HttpSession session) throws IOException {
		ModelAndView mv = new ModelAndView();
		if (session.getAttribute("user") == null) {
			mv.setViewName("pages/admin/admin-login");
			return "redirect:/admin-login";
		}
		content.setImg(image.getOriginalFilename());
		System.out.println(page);
		Content createNewContent = service.createNewConten(content, image.getOriginalFilename(), page);
		if (createNewContent != null) {
			service.saveImage(image);
			model.addAttribute("isUpdated", true);
			System.out.println(createNewContent.getPage());
		}

//		System.out.println(content.getPage());
		// file saving process or code
//		File file = new ClassPathResource("static/images").getFile();
//		Path path = Paths.get(file.getAbsolutePath() + File.separator + image.getOriginalFilename());
//		Files.copy(image.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
//		System.out.println(path + " " + file);
////		System.out.println(save.getTitle() + " " + save.getDescriptionTxt() + " " + save.getImg());
//		if (save != null) {
//			model.addAttribute("msg", "content updated!!!");
//		}
//		System.out.println(page + " page");
		mv.setViewName("pages/admin/admin-home");
		return "redirect:/admin-home";

	}

	@GetMapping("/logout")
	public ModelAndView logOutAdmin(HttpSession session) {
		session.removeAttribute("user");
		return new ModelAndView("pages/admin/admin-login");
	}

	@PostMapping("/reset")
	public String resetPassword(@RequestParam("password") String password,
			@RequestParam("confirmPassword") String confirmPassword, HttpSession session, Model model) {
		User user = repo.findById(1).get();
		System.out.println(password + " - - " + confirmPassword);
		if (password.equals(confirmPassword)) {
			user.setPassword(password);
			User u = repo.save(user);
			if (u != null) {
				model.addAttribute("isReset", true);
				model.addAttribute("msg", "Password reset!!!");
			}
		}
		return "redirect:/admin-home";
	}
	
	@PostMapping("/handle-contact")
	public String handleCantactForm(@ModelAttribute("contact") Contact contact, HttpSession session) {
		contact.setActive(true);
		Contact c = contactService.createNewContact(contact);
		return "redirect:/admin-home";
	}
	
	@GetMapping("/isActive/{id}")
	public String isActiveDeactive(@PathVariable("id") int id, HttpSession session) {
		if(session.getAttribute("user") != null) {
			contactService.activateDeactivateLoc(id);
			return "redirect:/admin-home";
		}
		return "redirect:/admin-login";	
	}
	
	@GetMapping("/remove/{id}")
	public String removeContact(@PathVariable("id") int id, HttpSession session) {
		if(session.getAttribute("user") != null) {
			String msg = contactService.deleteContact(id);
			if(msg.equals("success")) {
				return "redirect:/admin-home";
			}
		}
		return "redirect:/admin-login";
	}
}
