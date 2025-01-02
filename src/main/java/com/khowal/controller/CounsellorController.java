package com.khowal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.khowal.dto.CounsellorDTO;
import com.khowal.dto.DashboardDTO;
import com.khowal.service.CounsellorService;
import com.khowal.service.EnquiryService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class CounsellorController {

	@Autowired
	private CounsellorService counsellorService;

	@Autowired
	private EnquiryService enqService;

	@GetMapping("/")
	public String login(Model model) {
		CounsellorDTO counsellorDTO = new CounsellorDTO();
		model.addAttribute("counsellor", counsellorDTO);
		return "index";
	}

	@PostMapping("/login")
	public String handleLogin(Model model, @ModelAttribute("counsellor") CounsellorDTO counsellor,
			HttpServletRequest req) {
		CounsellorDTO counsellorDTO = counsellorService.login(counsellor);
		if (counsellorDTO == null) {
			model.addAttribute("error", "Invalid Credentials");
			return "index";
		} else {
			Integer counsellorId = counsellorDTO.getCounsellorId();
			HttpSession session = req.getSession(true);
			session.setAttribute("counsellorId", counsellorId);
			DashboardDTO dashboardResponse = enqService.dashboardResponse(counsellorId);
			model.addAttribute("dashboardResponse", dashboardResponse);
			return "dashboard";
		}
	}

	@GetMapping("/register")
	public String register(Model model) {
		CounsellorDTO counsellorDTO = new CounsellorDTO();
		model.addAttribute("counsellor", counsellorDTO);
		return "register";
	}

	@PostMapping("/register")
	public String handleRegister(@ModelAttribute("counsellor") CounsellorDTO counsellor, Model model) {
		boolean unique = counsellorService.checkUniqueEmail(counsellor.getCounsellorEmail());
		if (unique) {
			boolean register = counsellorService.registerCounsellor(counsellor);
			if (register) {
				model.addAttribute("success", "Registered Successfully");
			} else {
				model.addAttribute("error", "Registration failed");
			}
		} else {
			model.addAttribute("error", "This email is already registered. Please use a different email.");
		}
		return "register";
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest req, Model model) {
		HttpSession session = req.getSession(false);
		session.invalidate();
		CounsellorDTO counsellorDTO = new CounsellorDTO();
		model.addAttribute("counsellor", counsellorDTO);
		return "index";
	}
	
	@GetMapping("/dashboard")
	public String displayDashboard(HttpServletRequest req, Model model) {
		HttpSession session = req.getSession(false);
		Integer counsellorId = (Integer) session.getAttribute("counsellorId");
		DashboardDTO dashboardResponse = enqService.dashboardResponse(counsellorId);
		model.addAttribute("dashboardResponse", dashboardResponse);
		return"dashboard";
	}
	
}
