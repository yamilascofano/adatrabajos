package com.adatp.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.adatp.model.Curso;
import com.adatp.service.ParticipanteService;

public class InscripcionController {
	@Autowired
	ParticipanteService participanteService;

	public void guardado() {
		System.out.println("Ingrese 1 para inscribirse");
		int solicitud = 0;
		while (solicitud == 0) {
			System.out.println("Ingrese nombre");
			String nombre = null;
			System.out.println("Ingrese apellido");
			String apellido = null;
			System.out.println("");
			int fechaNacimiento = 0;
			System.out.println("");
			String genero = null;
			System.out.println("");
			String residencia = null;
			System.out.println();
			Curso curso = null;
			System.out.println("Para solicitud directa ingrese true, para beca false");
			boolean beca = true;
			/*
			 * if (beca = true) { participanteService.save(new Participante(fechaNacimiento,
			 * nombre, apellido, fechaNacimiento, genero, residencia, curso)); } else {
			 * System.out.println("datos socio"); Socioeconomico socioeconomico = null;
			 * participanteBecaService.save(new ParticipanteBeca(fechaNacimiento, nombre,
			 * apellido, fechaNacimiento, genero, residencia, curso, socioeconomico)); }
			 */
		}
	}
}
