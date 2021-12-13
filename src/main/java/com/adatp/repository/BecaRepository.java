package com.adatp.repository;

import org.springframework.data.repository.CrudRepository;

import com.adatp.model.Beca;
import com.adatp.model.Participante;

public interface BecaRepository extends CrudRepository<Beca, Integer> {

	Beca save(Participante par);

}
