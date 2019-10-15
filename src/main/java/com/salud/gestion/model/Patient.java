package com.salud.gestion.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "patients")
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "first_name", nullable = false, length = 70)
	private String firstName;

	@Column(name = "last_name", nullable = false, length = 70)
	private String lastName;

	@Column(name = "dni", nullable = false, length = 8)
	private String dni;

	@Column(name = "medical_history", nullable = false)
	private String medicalHistory;

	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REMOVE }, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<MedicalConsultation> lstMedicalConsultation;

	public Patient() {

	}

	public Patient(String firstName, String lastName, String dni, String medicalHistory) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dni = dni;
		this.medicalHistory = medicalHistory;
	}

	public List<MedicalConsultation> getLstMedicalConsultation() {
		return lstMedicalConsultation;
	}

	public void setLstMedicalConsultation(List<MedicalConsultation> lstMedicalConsultation) {
		this.lstMedicalConsultation = lstMedicalConsultation;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getMedicalHistory() {
		return medicalHistory;
	}

	public void setMedicalHistory(String medicalHistory) {
		this.medicalHistory = medicalHistory;
	}

}
