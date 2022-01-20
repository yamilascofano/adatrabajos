package com.adatp.form.enums;

public enum Rol {

	ADMINISTRADOR(1), REPRESENTANTE(2), PARTICIPANTE(3);

	private int num;

	private Rol(int num) {
		this.setNum(num);
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

}
