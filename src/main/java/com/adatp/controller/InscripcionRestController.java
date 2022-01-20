package com.adatp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adatp.Excepciones.CursoInvalidoException;
import com.adatp.Excepciones.InscripcionInvalidaException;
import com.adatp.Excepciones.NoAutorizadoException;
import com.adatp.Excepciones.NoCupoException;
import com.adatp.Excepciones.NoUsuarioException;
import com.adatp.Excepciones.ParticipanteInvalidoException;
import com.adatp.Excepciones.PorcentajeInvalidoException;
import com.adatp.form.InscripcionForm;
import com.adatp.form.PagosForm;
import com.adatp.model.Inscripcion;
import com.adatp.service.InscripcionService;

@RestController
@RequestMapping("/v1/inscripciones")
public class InscripcionRestController {

	@Autowired
	InscripcionService inscripcionService;

	@PostMapping("/insc")
	public Inscripcion save(@RequestBody InscripcionForm form)
			throws CursoInvalidoException, ParticipanteInvalidoException, NoCupoException {
		return inscripcionService.save(form);

	}

	@PostMapping("/aprobar")
	public Inscripcion aprobar(@RequestBody PagosForm form) throws NoUsuarioException, NoAutorizadoException,
			InscripcionInvalidaException, PorcentajeInvalidoException {
		return inscripcionService.aprobar(form);
	}

	@DeleteMapping("/")
	public void borrarInscripcionPorId(@PathVariable int id) {
		inscripcionService.deleteById(id);
	}

	@GetMapping("/")
	public Iterable<Inscripcion> listadoInscripciones() {
		return inscripcionService.findAll();
	}

}
