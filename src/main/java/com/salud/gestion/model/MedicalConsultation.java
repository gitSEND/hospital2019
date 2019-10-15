package com.salud.gestion.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

@Entity
@Table(name = "medicalConsultations")
public class MedicalConsultation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonSerialize(using = ToStringSerializer.class)
	@Column(name = "fecha_consulta")
	private LocalDateTime date;

	@OneToMany(mappedBy = "consultation", cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REMOVE }, fetch = FetchType.LAZY, orphanRemoval = true)
	List<DetailConsultation>lstDetailConsultations;

	@ManyToOne
	@JoinColumn(name = "patient_id")
	private Patient patient;
	
	
	
	public MedicalConsultation() {

	}

	public MedicalConsultation(LocalDateTime date) {
		super();
		this.date = date;
	}

	
	
	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public List<DetailConsultation> getLstDetailConsultations() {
		return lstDetailConsultations;
	}

	public void setLstDetailConsultations(List<DetailConsultation> lstDetailConsultations) {
		this.lstDetailConsultations = lstDetailConsultations;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

}
