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
	private double costo;
	private int horas;
	private String categorias;
	private int numParticipantes;

	@ManyToOne
	@JoinColumn(name = "representante", nullable = false)
	private Representante representante;

	@ManyToOne
	@JoinColumn(name = "empresa", nullable = false)
	private Empresa empresa;

	@ManyToOne
	@JoinColumn(name = "participante", nullable = false)
	private Participante participante;
}
