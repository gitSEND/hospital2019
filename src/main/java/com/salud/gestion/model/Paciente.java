package com.salud.gestion.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name = "patients")
public class Paciente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "first_name", nullable = false, length = 70)
	private String firtName;
	
	@Column(name = "last_name", nullable = false, length = 70)
	private String lastName;
	
	@Column(name = "dni", nullable = false, length = 8)
	private String dni;
	
	@Column(name = "medical_history", nullable = false)
	private String medicalHistory;
	
	
	
}
