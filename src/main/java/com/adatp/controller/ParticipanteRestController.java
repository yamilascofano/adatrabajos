package com.adatp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adatp.Excepciones.NoAutorizadoException;
import com.adatp.Excepciones.NoUsuarioException;
import com.adatp.form.ParticipanteForm;
import com.adatp.model.Participante;
import com.adatp.service.ParticipanteService;

@RestController
@RequestMapping("/v1/participantes")
public class ParticipanteRestController {
	@Autowired
	ParticipanteService participanteService;

	@GetMapping("/")
	public Iterable<Participante> listadoParticipantes() {
		return participanteService.findAll();
	}

	@DeleteMapping("/{id}")
	public void borrarParticipantePorId(@PathVariable int id) {
		participanteService.deleteById(id);
	}

	@PostMapping("/")
	public Participante insertarParticipante(@RequestBody ParticipanteForm form)
			throws NoUsuarioException, NoAutorizadoException {
		return participanteService.save(form);
	}

	@PutMapping("/")
	public Participante modificarParticipante(@RequestBody ParticipanteForm form)
			throws NoUsuarioException, NoAutorizadoException {
		return participanteService.save(form);
	}

}
