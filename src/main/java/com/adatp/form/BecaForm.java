package com.adatp.form;

import lombok.Data;

@Data
public class BecaForm {
	private int id;
	private boolean estudia;
	private boolean trabaja;
	private int ingresos;
	private int familiaCargo;
	private int idParticipante;

	public BecaForm(int id, boolean estudia, boolean trabaja, int ingresos, int familiaCargo, int idParticipante) {
		this.id = id;
		this.estudia = estudia;
		this.trabaja = trabaja;
		this.ingresos = ingresos;
		this.familiaCargo = familiaCargo;
		this.idParticipante = idParticipante;
	}

	public BecaForm() {
	}

}
