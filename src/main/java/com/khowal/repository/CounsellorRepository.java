package com.khowal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.khowal.entities.CounsellorEntity;

public interface CounsellorRepository extends JpaRepository<CounsellorEntity, Integer> {

	public CounsellorEntity findByCounsellorEmailAndCounsellorPassword(String email, String password);

	public CounsellorEntity findByCounsellorEmail(String email);

}
