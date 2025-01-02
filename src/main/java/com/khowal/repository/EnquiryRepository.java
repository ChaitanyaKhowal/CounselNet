package com.khowal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.khowal.entities.EnquiryEntity;

public interface EnquiryRepository extends JpaRepository<EnquiryEntity, Integer> {

	public List<EnquiryEntity> findByCounsellorCounsellorId(Integer counsellorId);

}
