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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adatp.model.Beca;
import com.adatp.service.BecaService;

@RestController
@RequestMapping("/v2")
public class BecaRestController {
	@Autowired
	BecaService becaService;

	@GetMapping("/beca")
	public Iterable<Beca> listadoBecas() {
		return becaService.findAll();
	}

	@GetMapping("/becas")
	public Beca listadoPorParticipante(@RequestParam int idParticipante) {
		return becaService.findByParticipante(idParticipante);
	}

	@GetMapping("/becas/{id}")
	public Optional<Beca> listadoPorId(@PathVariable int id) {
		return becaService.findById(id);
	}

	@PostMapping("/becas")
	public Beca insertarBeca(@RequestBody Beca form, @RequestParam("idParticipante") int idParticipante)
			throws Exception {
		becaService.save(idParticipante);
		return form;
	}

	@PutMapping("/becas")
	public Beca modificarBeca(int idParticipante, @RequestBody Beca form) throws Exception {
		becaService.save(idParticipante);
		return form;
	}

	@DeleteMapping("/becas/{id}")
	public void borrarBecasPorId(@PathVariable int id) {
		becaService.deleteById(id);
	}

}
