package com.adatp.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adatp.model.Inscripcion;
import com.adatp.service.InscripcionService;

@RestController
@RequestMapping("/v2")
public class InscripcionRestController {

	@Autowired
	InscripcionService inscripcionService;

	@PostMapping("/inscripcion")
	public Inscripcion save(@RequestBody Inscripcion i, @RequestParam("idParticipante") int idParticipante,
			@RequestParam("idCurso") int idCurso) throws Exception {
		inscripcionService.save(idParticipante, idCurso);
		return i;

	}

	@PostMapping("/inscripcionDirecta")
	public Inscripcion crearDirecta(@RequestBody Inscripcion i, @RequestParam("idParticipante") int idParticipante,
			@RequestParam("idCurso") int idCurso) throws Exception {
		inscripcionService.save(idParticipante, idCurso);
		return i;

	}

	@DeleteMapping("/inscripcion{id}")
	public void borrarInscripcionPorId(@PathVariable int id) {
		inscripcionService.deleteById(id);
	}

	@GetMapping("/inscripcion{id}")

	public Optional<Inscripcion> listadoInscripcionesPorId(@PathVariable int id) {
		return inscripcionService.findById(id);
	}

	@GetMapping("/inscripcion")

	public Iterable<Inscripcion> listadoInscripciones() {
		return inscripcionService.findAll();
	}

}
