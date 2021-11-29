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

import com.adatp.model.Curso;
import com.adatp.service.CursoService;

@RestController
@RequestMapping("/v2")
public class CursoRestController {
	@Autowired
	CursoService cursoService;

	@GetMapping("/cursos")
	public Iterable<Curso> listadoPorEmpresa(@RequestParam int idEmpresa) {
		return cursoService.findByEmpresa(idEmpresa);
	}

	@GetMapping("/cursos/{id}")
	public Optional<Curso> listadoPorId(@PathVariable int id) {
		return cursoService.findById(id);
	}

	@PostMapping("cursos")
	public Curso insertarEmpresa(@RequestBody Curso form) {
		return cursoService.save(form);
	}

	@PutMapping("/cursos")
	public Curso modificarCurso(@RequestBody Curso form) {
		return cursoService.save(form);
	}

	@DeleteMapping("/cursos/{id}")
	public void borrarCursoPorId(@PathVariable int id) {
		cursoService.deleteById(id);
	}

}
