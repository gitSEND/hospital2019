package com.salud.gestion.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.salud.gestion.exception.ModeloNotFoundException;
import com.salud.gestion.model.Especialty;
import com.salud.gestion.repository.EspecialtyRepository;
import com.salud.gestion.service.IEspecialtyService;

public class EspecialtyServiceImpl implements IEspecialtyService {

	@Autowired
	private EspecialtyRepository dao;
	
	@Override
	public Especialty createAndUpdate(Especialty entity) {
		return dao.save(entity);
	}

	@Override
	public void delete(Especialty entity) {
		dao.delete(entity);
	}

	@Override
	public Especialty findById(Long id) {
		
		Optional<Especialty> obj = dao.findById(id);
		if (!obj.isPresent()) {
			throw new ModeloNotFoundException("No existe el ID : "+ id);
		}
		return obj.get();
	}

	@Override
	public List<Especialty> findAll() {
		return dao.findAll();
	}

}
