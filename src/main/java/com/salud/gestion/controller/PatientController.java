package com.salud.gestion.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salud.gestion.model.Patient;
import com.salud.gestion.service.IPatientService;

@RestController
@RequestMapping("/patients")
public class PatientController {

	@Autowired
	private IPatientService servicePatient;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Patient>> getAllPatients() {
		List<Patient> patients = new ArrayList<Patient>();
		patients = servicePatient.findAll();
		return new ResponseEntity<List<Patient>>(patients, HttpStatus.OK);
	}	
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Patient> createPatient(@RequestBody Patient patiente){
		Patient obj = new Patient();
		obj = servicePatient.createAndUpdate(patiente);
		return new ResponseEntity<Patient>(obj,HttpStatus.CREATED);
	}
	
}
