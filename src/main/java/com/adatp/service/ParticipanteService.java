package com.adatp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adatp.model.Participante;
import com.adatp.repository.BecaRepository;
import com.adatp.repository.ParticipanteRepository;

@Service
public class ParticipanteService {

	@Autowired
	ParticipanteRepository participanteRepository;
	@Autowired
	BecaRepository becaRepository;
	@Autowired
	BecaService becaService;

	public Participante save(Participante participante) {
		return participanteRepository.save(participante);
	}

	public Iterable<Participante> findAll() {
		return participanteRepository.findAll();
	}

	public Optional<Participante> findById(int id) {
		return participanteRepository.findById(id);
	}

	public void deleteById(int id) {
		participanteRepository.findById(id);

	}

}
