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
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String nombre;
	private String descripcion;
	private String modalidad;
	private int costo;
	private int horas;
	private String categorias;
	private int numParticipantes;
	private int cupoBeca;

	public Curso(int id, String nombre, String descripcion, String modalidad, int costo, int horas, String categorias,
			int numParticipantes, int cupoBeca, Empresa empresa, Representante representante) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.modalidad = modalidad;
		this.costo = costo;
		this.horas = horas;
		this.categorias = categorias;
		this.numParticipantes = numParticipantes;
		this.cupoBeca = cupoBeca;
		this.empresa = empresa;
		this.representante = representante;
	}

	public Curso() {
	}

	@ManyToOne
	@JoinColumn(name = "empresa", nullable = false)
	private Empresa empresa;

	@ManyToOne
	@JoinColumn(name = "representante", nullable = false)
	private Representante representante;

}
