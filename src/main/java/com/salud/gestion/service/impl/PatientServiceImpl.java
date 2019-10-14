package com.salud.gestion.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salud.gestion.model.Patient;
import com.salud.gestion.repository.PatientRepository;
import com.salud.gestion.service.IPatientService;

@Service
public class PatientServiceImpl implements IPatientService {

	@Autowired
	private PatientRepository dao;
	
	@Override
	public Patient createAndUpdate(Patient entity) {
		return dao.save(entity) ;
	}

	@Override
	public void delete(Patient entity) {
		dao.delete(entity);		
	}

	@Override
	public Patient findById(Long id) {
		return dao.findById(id).orElse(null);
	}

	@Override
	public List<Patient> findAll() {
		return dao.findAll();
	}

}
