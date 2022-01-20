package com.adatp.form;

import com.adatp.form.enums.Estado;

import lombok.Data;

@Data
public class EmpresaForm {
	private int idUsuario;
	private int idEmpresa;
	private Estado estado;
}
