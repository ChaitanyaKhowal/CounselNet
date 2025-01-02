package com.khowal.service;

import java.util.List;

import com.khowal.dto.DashboardDTO;
import com.khowal.dto.EnquiryDTO;
import com.khowal.dto.EnquiryFilterDTO;

public interface EnquiryService {

	public DashboardDTO dashboardResponse(Integer counsellorId);

	public boolean addEnquiries(EnquiryDTO dto, Integer counsellorId);

	public List<EnquiryDTO> getEnquiries(Integer counsellorId);

	public List<EnquiryDTO> getEnquiries(Integer counsellorId, EnquiryFilterDTO filterDTO);

	public EnquiryDTO getEnquiryById(Integer studentId);


}
