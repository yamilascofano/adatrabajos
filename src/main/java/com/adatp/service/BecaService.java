package com.adatp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adatp.Excepciones.ParticipanteInvalidoException;
import com.adatp.form.BecaForm;
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

	public Optional<Beca> findById(int id) {
		return becaRepository.findById(id);
	}

	public Beca save(BecaForm form) throws ParticipanteInvalidoException {
		Beca beca = new Beca();
		Optional<Participante> par = participanteService.findById(form.getIdParticipante());
		if (par.isEmpty())
			throw new ParticipanteInvalidoException("No existe participante con ese id");
		Participante participante = par.get();
		if (participante.isTieneBeca() == true)
			beca.setParticipante(participante);
		beca.setEstudia(form.isEstudia());
		beca.setFamiliaCargo(form.getFamiliaCargo());
		beca.setIngresos(form.getIngresos());
		beca.setTrabaja(form.isTrabaja());
		return becaRepository.save(beca);
	}

	public void deleteById(int id) {
		becaRepository.deleteById(id);
	}

	public Optional<Beca> findByParticipante(int idParticipante) {
		Participante participante = new Participante();
		participante.setId(idParticipante);
		return becaRepository.findByParticipante(participante);
	}

}