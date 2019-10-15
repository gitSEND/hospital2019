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
@Table(name = "doctors")
public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "first_name", nullable = false, length = 70)
	private String firstName;
	
	@Column(name = "last_name", nullable = false, length = 70)
	private String lastName;
	
	@Column(name = "dni", nullable = false, length = 8)
	private String dni;
	
	@Column(name = "cmp", nullable = false)
	private String cmp;
	
	@ManyToOne
	@JoinColumn(name = "especialty_id")
	private Especialty especialty;
	
	public Doctor() {
	
	}

	public Doctor(String firstName, String lastName, String dni, String cmp) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dni = dni;
		this.cmp = cmp;
	}
	
	

	public Especialty getEspecialty() {
		return especialty;
	}

	public void setEspecialty(Especialty especialty) {
		this.especialty = especialty;
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

	public String getCmp() {
		return cmp;
	}

	public void setCmp(String cmp) {
		this.cmp = cmp;
	}
	
	
}
