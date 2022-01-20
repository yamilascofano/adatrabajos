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
public class Participante {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nombre;
	private String apellido;
	private int fechaNacimiento;
	private String genero;
	private String residencia;
	private boolean tieneBeca;
	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "beca", nullable = true) private Beca beca;
	 */
	@ManyToOne
	@JoinColumn(name = "usuario", nullable = false)
	private Usuario usuario;

	public Participante(int id, String nombre, String apellido, int fechaNacimiento, String genero, String residencia,
			boolean tieneBeca) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.genero = genero;
		this.residencia = residencia;
		this.tieneBeca = tieneBeca;

	}

	public Participante() {
	}

}
