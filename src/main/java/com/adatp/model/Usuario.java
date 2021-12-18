package com.adatp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String usuario;
	private String contraseña;

	/*
	 * @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL) private
	 * Participante participante;
	 * 
	 * @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL) private
	 * Representante representante;
	 */

}
