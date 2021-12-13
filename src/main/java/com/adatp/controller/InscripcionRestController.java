package com.adatp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adatp.model.Inscripcion;
import com.adatp.service.InscripcionService;

@RestController
@RequestMapping("/v2")
public class InscripcionRestController {

	@Autowired
	InscripcionService inscripcionService;

	@PostMapping("/inscripcion")
	public Inscripcion insertarCurso(@RequestBody Inscripcion form) {
		return inscripcionService.save(form);
	}
}
