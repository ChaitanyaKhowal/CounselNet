package com.khowal.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khowal.dto.CounsellorDTO;
import com.khowal.entities.CounsellorEntity;
import com.khowal.repository.CounsellorRepository;

@Service
public class CounsellorServiceImpl implements CounsellorService {

	@Autowired
	private CounsellorRepository counsellorRepo;

	@Override
	public CounsellorDTO login(CounsellorDTO counsellorDTO) {

		CounsellorEntity entity = counsellorRepo.findByCounsellorEmailAndCounsellorPassword(
				counsellorDTO.getCounsellorEmail(), counsellorDTO.getCounsellorPassword());

		if (entity != null) {
			CounsellorDTO dto = new CounsellorDTO();
			BeanUtils.copyProperties(entity, dto);
			return dto;
		}
		return null;
	}

	@Override
	public boolean checkUniqueEmail(String email) {
		CounsellorEntity entity = counsellorRepo.findByCounsellorEmail(email);
		return entity == null;
	}

	@Override
	public boolean registerCounsellor(CounsellorDTO counsellorDTO) {
		CounsellorEntity entity = new CounsellorEntity();
		BeanUtils.copyProperties(counsellorDTO, entity);
		CounsellorEntity save = counsellorRepo.save(entity);
		return save.getCounsellorId() != null;
	}

}
