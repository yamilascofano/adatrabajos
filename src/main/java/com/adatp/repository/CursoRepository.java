package com.adatp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import com.adatp.model.Curso;

public interface CursoRepository extends CrudRepository<Curso, Integer>, QueryByExampleExecutor<Curso> {

}
