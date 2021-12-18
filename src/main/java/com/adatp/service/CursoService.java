package com.adatp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adatp.model.Curso;
import com.adatp.model.Empresa;
import com.adatp.repository.CursoRepository;

@Service
public class CursoService {
	@Autowired
	CursoRepository cursoRepository;
	@Autowired
	EmpresaService empresaService;

	public Iterable<Curso> findByEmpresa(int idEmpresa) {
		Empresa empresa = new Empresa();
		empresa.setId(idEmpresa);
		return cursoRepository.findByEmpresa(empresa);

	}

	public Optional<Curso> findById(int idCurso) {
		return cursoRepository.findById(idCurso);

	}

	public void deleteById(int id) {
		cursoRepository.deleteById(id);
	}

	public Curso save(Curso form) {
		return cursoRepository.save(form);
	}

	public Iterable<Curso> findAll() {
		return cursoRepository.findAll();
	}

}
