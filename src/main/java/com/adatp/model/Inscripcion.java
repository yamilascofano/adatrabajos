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
	private boolean tieneBeca;

	@ManyToOne
	@JoinColumn(name = "participante", nullable = false)
	private Participante participante;
	@ManyToOne
	@JoinColumn(name = "curso", nullable = false)
	private Curso curso;
	@ManyToOne
	@JoinColumn(name = "beca", nullable = false)
	private Beca beca;

}