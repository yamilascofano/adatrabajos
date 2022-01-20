package com.adatp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import com.adatp.model.Inscripcion;

public interface InscripcionRepository
		extends CrudRepository<Inscripcion, Integer>, QueryByExampleExecutor<Inscripcion> {

}
