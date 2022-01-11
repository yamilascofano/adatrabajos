package com.adatp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import com.adatp.model.Beca;

public interface BecaRepository extends CrudRepository<Beca, Integer>, QueryByExampleExecutor<Beca> {

}
