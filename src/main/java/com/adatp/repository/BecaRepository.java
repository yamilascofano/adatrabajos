package com.adatp.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import com.adatp.model.Beca;
import com.adatp.model.Participante;

public interface BecaRepository extends CrudRepository<Beca, Integer>, QueryByExampleExecutor<Beca> {

	Optional<Beca> findByParticipante(Participante participante);
}
