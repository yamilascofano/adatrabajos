package com.adatp.repository;

import org.springframework.data.repository.CrudRepository;

import com.adatp.model.Curso;
import com.adatp.model.Empresa;

public interface CursoRepository extends CrudRepository<Curso, Integer> {

	Iterable<Curso> findByEmpresa(Empresa empresa);

	// Iterable<Curso> findByParticipante(Participante participante);

}
