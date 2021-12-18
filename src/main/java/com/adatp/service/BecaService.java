package com.adatp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adatp.model.Beca;
import com.adatp.model.Participante;
import com.adatp.repository.BecaRepository;
import com.adatp.repository.ParticipanteRepository;

@Service
public class BecaService {
	@Autowired
	BecaRepository becaRepository;
	@Autowired
	ParticipanteRepository participanteRepository;
	@Autowired
	ParticipanteService participanteService;

	public Iterable<Beca> findAll() {
		return becaRepository.findAll();
	}

	public Optional<Beca> findById(int id) {
		return becaRepository.findById(id);
	}

	public Beca save(int idParticipante) throws Exception {
		Beca beca = new Beca();
		Optional<Participante> par = participanteService.findById(idParticipante);
		Participante participante = par.get();
		if (!par.isPresent()) {
			throw new Exception("No existe participante con ese id");
		} else {
			if (participante.isTieneBeca() == true) {
				beca.setParticipante(participante);
				beca.setEstudia(beca.isEstudia());
				beca.setFamiliaCargo(beca.getFamiliaCargo());
				beca.setIngresos(beca.getIngresos());
				beca.setTrabaja(beca.isTrabaja());
			}
		}
		return becaRepository.save(beca);
	}

	public void deleteById(int id) {
		becaRepository.deleteById(id);

	}

	public Beca findByParticipante(int idParticipante) {
		Participante participante = new Participante();
		participante.setId(idParticipante);
		Optional<Beca> be = becaRepository.findByParticipante(participante);
		Beca beca = be.get();
		return beca;
	}

}
