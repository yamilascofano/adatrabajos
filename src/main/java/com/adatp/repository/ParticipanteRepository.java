package com.adatp.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.adatp.model.Participante;

public interface ParticipanteRepository extends CrudRepository<Participante, Integer> {

	Optional<Participante> findByBeca(Participante participante);

}
