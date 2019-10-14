package com.salud.gestion.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salud.gestion.exception.ModeloNotFoundException;
import com.salud.gestion.model.Doctor;
import com.salud.gestion.service.IDoctorService;

@RestController
@RequestMapping("/doctors")
public class DotorController {

	@Autowired
	IDoctorService serviceDoctor;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Doctor>> getAllDoctors() {
		List<Doctor> lstDoctors = new ArrayList<Doctor>();
		lstDoctors = serviceDoctor.findAll();
		return new ResponseEntity<List<Doctor>>(lstDoctors, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Doctor> getDoctor(@PathVariable(name = "id") Long id) {
		Doctor doctor = new Doctor();
		doctor = serviceDoctor.findById(id);
		if (doctor == null) {
			throw new ModeloNotFoundException("ID : " + id);
		}
		return new ResponseEntity<Doctor>(doctor, HttpStatus.OK);
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Doctor> createDoctor(@RequestBody Doctor doctor) {
		Doctor obj = new Doctor();
		obj = serviceDoctor.createAndUpdate(doctor);
		return new ResponseEntity<Doctor>(obj, HttpStatus.CREATED);
	}

	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Doctor> updateDoctor(@RequestBody Doctor doctor) {
		serviceDoctor.createAndUpdate(doctor);
		return new ResponseEntity<Doctor>(HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void deleteDoctor(@PathVariable(name = "id") Long id) {
		Doctor doctor = serviceDoctor.findById(id);
		if (doctor == null) {
			throw new ModeloNotFoundException("ID : " + id);
		} else {
			serviceDoctor.delete(doctor);
		}
	}

}
