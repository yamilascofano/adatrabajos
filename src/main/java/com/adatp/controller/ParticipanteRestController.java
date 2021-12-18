package com.adatp.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adatp.model.Participante;
import com.adatp.service.ParticipanteService;

@RestController
@RequestMapping("/v2")
public class ParticipanteRestController {
	@Autowired
	ParticipanteService participanteService;

	@GetMapping("/participantes")
	public Iterable<Participante> listadoParticipantes() {
		return participanteService.findAll();
	}

	@GetMapping("/participantes{id}")

	public Optional<Participante> listadoParticipantesPorId(@PathVariable int id) {
		return participanteService.findById(id);
	}

	@DeleteMapping("/participantes/{id}")
	public void borrarParticipantePorId(@PathVariable int id) {
		participanteService.deleteById(id);
	}

	@PostMapping("/participantes")
	public Participante insertarParticipante(@RequestBody Participante participante) {
		return participanteService.save(participante);
	}

	@PutMapping("/participantes")
	public Participante modificarParticipante(@RequestBody Participante participante) {
		return participanteService.save(participante);
	}

}
