package com.adatp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity

public class Representante {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String nombre;
	private String apellido;
	private String dni;
	private String mail;
	private String cargo;

	@ManyToOne
	@JoinColumn(name = "empresa", nullable = false)
	private Empresa empresas;

	public Representante() {
	}

	public Representante(int id, String nombre, String apellido, String dni, String mail, String cargo,
			Empresa empresas) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.mail = mail;
		this.cargo = cargo;
		this.empresas = empresas;
	}

}
