package com.adatp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adatp.model.Beca;
import com.adatp.model.Inscripcion;
import com.adatp.repository.InscripcionRepository;

@Service
public class InscripcionService {
	@Autowired
	ParticipanteService participanteService;
	@Autowired
	InscripcionRepository inscripcionRepository;
	@Autowired
	CursoService cursoService;
	@Autowired
	BecaService becaService;

	public Inscripcion save(Inscripcion inscripcion) {
		if (inscripcion.isTieneBeca()) {
			Beca beca = new Beca();
			becaService.save(beca);
			inscripcion.setBeca(beca);
		} else {
		}

		return inscripcionRepository.save(inscripcion);
	}
}