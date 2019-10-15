package com.salud.gestion.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "details_consultations")
public class DetailConsultation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "diagnostic")
	private String diagnostic;

	@Column(name = "treatment")
	private String treatment;
	
	
	@ManyToOne
	@JoinColumn(name = "medical_id", nullable = false)
	private MedicalConsultation consultation;

	public DetailConsultation() {

	}

	public DetailConsultation(String diagnostic, String treatment) {
		super();
		this.diagnostic = diagnostic;
		this.treatment = treatment;
	}

	
	public MedicalConsultation getConsultation() {
		return consultation;
	}

	public void setConsultation(MedicalConsultation consultation) {
		this.consultation = consultation;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDiagnostic() {
		return diagnostic;
	}

	public void setDiagnostic(String diagnostic) {
		this.diagnostic = diagnostic;
	}

	public String getTreatment() {
		return treatment;
	}

	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}

}
