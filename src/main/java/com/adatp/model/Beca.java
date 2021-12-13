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
public class Beca {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private boolean estudia;
	private boolean trabaja;
	private int ingresos;
	private int familiaCargo;

	@ManyToOne
	@JoinColumn(name = "curso", nullable = false)
	private Curso curso;

	@ManyToOne
	@JoinColumn(name = "participante", nullable = false)
	private Participante participante;

}
