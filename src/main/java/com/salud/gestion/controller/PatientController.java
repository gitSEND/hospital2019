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

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Patient> getPatient(@PathVariable(name = "id") Long id) {
		Patient patient = new Patient();
		patient = servicePatient.findById(id);

		if (patient == null) {
			throw new ModeloNotFoundException("ID : " + id);
		}
		return new ResponseEntity<Patient>(patient, HttpStatus.OK);
	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Patient> createPatient(@RequestBody Patient patiente) {
		Patient obj = new Patient();
		obj = servicePatient.createAndUpdate(patiente);
		return new ResponseEntity<Patient>(obj, HttpStatus.CREATED);
	}

	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Patient> updatePatient(@RequestBody Patient patiente) {
		servicePatient.createAndUpdate(patiente);
		return new ResponseEntity<Patient>(HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void deletePatient(@PathVariable(name = "id") Long id) {
		Patient patient = servicePatient.findById(id);
		if (patient == null) {
			throw new ModeloNotFoundException("ID : " + id);
		} else {
			servicePatient.delete(patient);
		}
	}

}
