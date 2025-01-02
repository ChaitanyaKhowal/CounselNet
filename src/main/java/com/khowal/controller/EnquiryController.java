package com.khowal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.khowal.dto.EnquiryDTO;
import com.khowal.dto.EnquiryFilterDTO;
import com.khowal.service.EnquiryService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class EnquiryController {

	@Autowired
	private EnquiryService enqService;

	@GetMapping("/enq")
	public String loadAddForm(Model model) {
		EnquiryDTO enquiryDTO = new EnquiryDTO();
		model.addAttribute("enquiry", enquiryDTO);
		return "enquiry-form";
	}

	@PostMapping("/add-enquiry")
	public String handleSave(Model model, @ModelAttribute("enquiry") EnquiryDTO enquiry, HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		Integer counsellorId = (Integer) session.getAttribute("counsellorId");
		if (counsellorId == null) {
			model.addAttribute("error", "Session expired or counselor not logged in.");
			return "/";
		}
		boolean enquiryCheck = enqService.addEnquiries(enquiry, counsellorId);
		if (enquiryCheck) {
			model.addAttribute("success", "Enquiry saved successfully");
		} else {
			model.addAttribute("error", "Enquiry failed to save");
		}
		return "enquiry-form";
	}

	@GetMapping("/view-enquiry")
	public String viewAllEnquiries(Model model, HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		Integer counsellorId = (Integer) session.getAttribute("counsellorId");
		List<EnquiryDTO> enqDtoList = enqService.getEnquiries(counsellorId);
		model.addAttribute("enquiries", enqDtoList);
		EnquiryFilterDTO enquiryFilterDTO = new EnquiryFilterDTO();
		model.addAttribute("enquiryFilterDTO", enquiryFilterDTO);
		return "view-enquiry";
	}

	@PostMapping("/filter-enquiry")
	public String filterEnquiry(Model model, HttpServletRequest req,
			@ModelAttribute("enquiryFilterDTO") EnquiryFilterDTO filterDto) {
		 System.out.println("Filter DTO: " + filterDto);
		
		HttpSession session = req.getSession(false);
		Integer counsellorId = (Integer) session.getAttribute("counsellorId");

		List<EnquiryDTO> filteredDTO = enqService.getEnquiries(counsellorId, filterDto);
		model.addAttribute("enquiries", filteredDTO);
		
		model.addAttribute("enquiryFilterDTO", filterDto);
		return "view-enquiry";
	}

	@GetMapping("/edit-enquiry")
	public String editEnquiry(Model model, @RequestParam("enqId") Integer enqId) {
		EnquiryDTO enquiryById = enqService.getEnquiryById(enqId);
		model.addAttribute("enquiry", enquiryById);
		return "enquiry-form";
	}

}
