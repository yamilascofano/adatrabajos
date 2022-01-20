package com.adatp.form.enums;

public enum ModoPago {
	DIRECTA(1), ESPERA(2), PAGO_50(3), PAGO_75(4), PAGO_100(5), RECHAZADA(6);

	private int num;

	private ModoPago(int num) {
		this.setNum(num);
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

}
