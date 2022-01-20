package com.adatp.form;

import lombok.Data;

@Data
public class ParticipanteForm {
	private int id;
	private String nombre;
	private String apellido;
	private int fechaNacimiento;
	private String genero;
	private String residencia;
	private boolean tieneBeca;
	private int idUsuario;

	public ParticipanteForm(int id, String nombre, String apellido, int fechaNacimiento, String genero,
			String residencia, boolean tieneBeca, int idUsuario) {

		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.genero = genero;
		this.residencia = residencia;
		this.tieneBeca = tieneBeca;
		this.idUsuario = idUsuario;
	}

	public ParticipanteForm() {
	}

}
