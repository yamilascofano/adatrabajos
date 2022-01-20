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
import com.adatp.form.RepresentanteForm;
import com.adatp.model.Representante;
import com.adatp.service.RepresentanteService;

@RestController
@RequestMapping("/v1/representantes")
public class RepresentanteRestController {

	@Autowired
	RepresentanteService representanteService;

	@GetMapping("/")
	public Iterable<Representante> listadoRepresentantes() {
		return representanteService.findAll();
	}

	@PostMapping("/")
	public Representante insertarRepresentante(@RequestBody RepresentanteForm form)
			throws NoUsuarioException, NoAutorizadoException {
		return representanteService.save(form);
	}

	@PutMapping("/")
	public Representante modificarRepresentante(@RequestBody RepresentanteForm form)
			throws NoUsuarioException, NoAutorizadoException {
		return representanteService.save(form);
	}

	@DeleteMapping("/{id}")
	public void borrarRepresentantePorId(@PathVariable int id) {
		representanteService.deleteById(id);
	}
}
