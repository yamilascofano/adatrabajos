package com.adatp.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.adatp.model.Beca;
import com.adatp.model.Participante;

public interface BecaRepository extends CrudRepository<Beca, Integer> {

	Optional<Beca> findByParticipante(Participante participante);

}
