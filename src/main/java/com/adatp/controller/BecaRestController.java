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
import com.adatp.model.BecaForm;
import com.adatp.service.BecaService;

@RestController
@RequestMapping("/v1/becas")
public class BecaRestController {
	@Autowired
	BecaService becaService;

	@GetMapping("/")
	public Iterable<Beca> listadoBecas() {
		return becaService.findAll();
	}

	@GetMapping("/")
	public Optional<Beca> busquedaPorParticipante(@RequestParam int idParticipante) {
		return becaService.findByParticipante(idParticipante);
	}

	@GetMapping("/{id}")
	public Optional<Beca> listadoPorId(@PathVariable int id) {
		return becaService.findById(id);
	}

	@PostMapping("/")
	public Beca insertarBeca(@RequestBody BecaForm form) throws Exception {
		return becaService.save(form);
	}

	@PutMapping("/")
	public Beca modificarBeca(@RequestBody BecaForm form) throws Exception {
		return becaService.save(form);
	}

	@DeleteMapping("/{id}")
	public void borrarBecasPorId(@PathVariable int id) {
		becaService.deleteById(id);
	}

}