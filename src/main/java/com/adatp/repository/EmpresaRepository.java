package com.adatp.repository;

import org.springframework.data.repository.CrudRepository;

import com.adatp.model.Empresa;

public interface EmpresaRepository extends CrudRepository<Empresa, Integer> {

}
