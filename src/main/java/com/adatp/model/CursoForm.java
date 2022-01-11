package com.adatp.model;

import lombok.Data;

@Data
public class CursoForm {

	private int id;

	private String nombre;
	private String descripcion;
	private String modalidad;
	private int costo;
	private int horas;
	private String categorias;
	private int numParticipantes;
	private int cupoBeca;
	private int idRepresentante;
	private Empresa empresa;

	public CursoForm(int id, String nombre, String descripcion, String modalidad, int costo, int horas,
			String categorias, int numParticipantes, int cupoBeca, int idRepresentante, Empresa empresa) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.modalidad = modalidad;
		this.costo = costo;
		this.horas = horas;
		this.categorias = categorias;
		this.numParticipantes = numParticipantes;
		this.cupoBeca = cupoBeca;
		this.idRepresentante = idRepresentante;
		this.empresa = empresa;
	}

	public CursoForm() {
	}

}
