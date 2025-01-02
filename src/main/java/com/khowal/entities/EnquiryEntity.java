package com.khowal.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class EnquiryEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer enqId;
	private String enqName;
	private String enqPhone;
	private String course;
	private String classMode;
	private String status;

	@ManyToOne
	@JoinColumn(name = "counsellor_id")
	private CounsellorEntity counsellor;

}
