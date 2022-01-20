package com.adatp.form.enums;

public enum Estado {
	APROBADO(1), EN_ESPERA(2), DESAPROBADO(3);

	private int num;

	private Estado(int num) {
		this.num = num;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

}
