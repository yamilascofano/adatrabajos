package com.adatp.repository;

import org.springframework.data.repository.CrudRepository;

import com.adatp.model.Inscripcion;
import com.adatp.model.Participante;

public interface ParticipanteRepository extends CrudRepository<Participante, Integer> {

	void save(Inscripcion inscripcion);

}
