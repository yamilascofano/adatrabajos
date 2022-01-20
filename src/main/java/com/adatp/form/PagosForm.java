package com.adatp.form;

import com.adatp.form.enums.ModoPago;

import lombok.Data;

@Data
public class PagosForm {
	private int idInscripcion;
	private ModoPago modoPago;
	private int idUsuario;

	public PagosForm(int idInscripcion, ModoPago modoPago, int idUsuario) {
		this.idInscripcion = idInscripcion;
		this.modoPago = modoPago;
		this.idUsuario = idUsuario;
	}

	public PagosForm() {
	}

}
