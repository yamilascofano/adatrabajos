package com.adatp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.adatp.form.enums.Estado;

import lombok.Data;

@Data
@Entity

public class Empresa {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String nombre;
	private int cuil;
	private String tipoEmpresa;
	private String direccion;
	private String categoria;
	private int añoFundacion;
	private int numContacto;
	private Estado estado;

	public Empresa(int id, String nombre, int cuil, String tipoEmpresa, String direccion, String categoria,
			int añoFundacion, int numContacto, Estado estado) {
		this.id = id;
		this.nombre = nombre;
		this.cuil = cuil;
		this.tipoEmpresa = tipoEmpresa;
		this.direccion = direccion;
		this.categoria = categoria;
		this.añoFundacion = añoFundacion;
		this.numContacto = numContacto;
		this.estado = estado;
	}

	public Empresa() {
	}

}
