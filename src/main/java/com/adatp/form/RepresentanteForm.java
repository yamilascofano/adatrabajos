package com.adatp.form;

import lombok.Data;

@Data
public class RepresentanteForm {
	private String nombre;
	private String apellido;
	private String dni;
	private String mail;
	private String cargo;
	private int idEmpresa;
	private int idUsuario;

}
