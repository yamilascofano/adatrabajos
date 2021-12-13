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

import com.adatp.model.Representante;
import com.adatp.service.RepresentanteService;

@RestController
@RequestMapping("/v2")
public class RepresentanteRestController {

	@Autowired
	RepresentanteService representanteService;

	@GetMapping("/representante")
	public Iterable<Representante> listadoRepresentantes() {
		return representanteService.findAll();
	}

	@GetMapping("/representante/{id}")
	public Optional<Representante> listadoPorId(@PathVariable int id) {
		return representanteService.findById(id);
	}

	@PostMapping("/representante")
	public Representante insertarRepresentante(@RequestBody Representante form) {
		return representanteService.save(form);
	}

	@PutMapping("/representante")
	public Representante modificarRepresentante(@RequestBody Representante form) {
		return representanteService.save(form);
	}

	@DeleteMapping("/representante/{id}")
	public void borrarRepresentantePorId(@PathVariable int id) {
		representanteService.deleteById(id);
	}

}
