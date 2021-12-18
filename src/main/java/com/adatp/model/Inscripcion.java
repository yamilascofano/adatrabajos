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
public class Inscripcion {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int porcentajeBecas;
	@ManyToOne
	@JoinColumn(name = "participante", nullable = false)
	private Participante participante;
	@ManyToOne
	@JoinColumn(name = "curso", nullable = false)
	private Curso curso;
	@ManyToOne
	@JoinColumn(name = "beca", nullable = false)
	private Beca beca;

	public Inscripcion(int id, Participante participante, Curso curso, Beca beca) {
		this.id = id;
		this.participante = participante;
		this.curso = curso;
		this.beca = beca;
	}

	public Inscripcion() {

	}
}