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

import com.adatp.Excepciones.NoAutorizadoException;
import com.adatp.form.CursoForm;
import com.adatp.model.Curso;
import com.adatp.service.CursoService;

@RestController
@RequestMapping("/v1/cursos")
public class CursoRestController {
	@Autowired
	CursoService cursoService;

	@GetMapping("/empresa/")
	public Optional<Curso> listadoPorEmpresa(@RequestParam int idEmpresa) {
		return cursoService.findByEmpresa(idEmpresa);
	}

	@GetMapping("/{id}")
	public Optional<Curso> FindById(@PathVariable int id) {
		return cursoService.findById(id);
	}

	@GetMapping("/listar")
	public Iterable<Curso> ListadoCursos() {
		return cursoService.findAll();
	}

	@PostMapping("/")
	public Curso insertarCurso(@RequestBody CursoForm form) throws NoAutorizadoException {
		return cursoService.save(form);
	}

	@PutMapping("/")
	public Curso modificarCurso(@RequestBody CursoForm form) throws NoAutorizadoException {
		return cursoService.save(form);
	}

	@DeleteMapping("/{id}")
	public void borrarCursoPorId(@PathVariable int id) {
		cursoService.deleteById(id);
	}

}
