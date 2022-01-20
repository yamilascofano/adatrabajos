package com.adatp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.adatp.form.enums.ModoPago;

import lombok.Data;

@Data
@Entity
public class Inscripcion {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@ManyToOne
	@JoinColumn(name = "participante", nullable = false)
	private Participante participante;
	@ManyToOne
	@JoinColumn(name = "curso", nullable = false)
	private Curso curso;
	private ModoPago modoPago;
	private int cupo;

	public Inscripcion(int id, Participante participante, Curso curso, ModoPago modoPago, int cupo) {
		this.id = id;
		this.participante = participante;
		this.curso = curso;
		this.modoPago = modoPago;
		this.cupo = cupo;
	}

	public Inscripcion() {

	}

}