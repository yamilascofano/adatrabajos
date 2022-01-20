package com.adatp.form;

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
	private int idEmpresa;
	private int idRepresentante;

	public CursoForm(int id, String nombre, String descripcion, String modalidad, int costo, int horas,
			String categorias, int numParticipantes, int cupoBeca, int idEmpresa) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.modalidad = modalidad;
		this.costo = costo;
		this.horas = horas;
		this.categorias = categorias;
		this.numParticipantes = numParticipantes;
		this.cupoBeca = cupoBeca;
		this.idEmpresa = idEmpresa;
	}

	public CursoForm() {
	}

}
