package com.khowal.dto;

import lombok.Data;

@Data
public class DashboardDTO {

	private Long totalEnquiries;
	private Long openEnquiries;
	private Long enrolledEnquiries;
	private Long lostEnquiries;

}
