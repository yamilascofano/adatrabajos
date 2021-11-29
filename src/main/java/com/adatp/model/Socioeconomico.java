package com.adatp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Socioeconomico {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private boolean estudia;
	private boolean trabaja;
	private double ingresos;
	private int familiaCargo;

}
