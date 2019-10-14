package com.salud.gestion.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salud.gestion.model.Doctor;
import com.salud.gestion.repository.DoctorRepository;
import com.salud.gestion.service.IDoctorService;

@Service
public class DoctorServiceImpl implements IDoctorService{

	@Autowired
	private DoctorRepository dao;
	
	@Override
	public Doctor createAndUpdate(Doctor entity) {
		return dao.save(entity);
	}

	@Override
	public void delete(Doctor entity) {
		dao.delete(entity);
	}

	@Override
	public Doctor findById(Long id) {
		return dao.findById(id).orElse(null);
	}

	@Override
	public List<Doctor> findAll() {
		return dao.findAll();
	}

}
