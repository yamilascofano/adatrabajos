package com.adatp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adatp.model.Beca;
import com.adatp.model.Curso;
import com.adatp.model.Inscripcion;
import com.adatp.model.Participante;
import com.adatp.repository.BecaRepository;
import com.adatp.repository.InscripcionRepository;
import com.adatp.repository.ParticipanteRepository;

@Service
public class InscripcionService {
	@Autowired
	ParticipanteService participanteService;
	@Autowired
	InscripcionRepository inscripcionRepository;
	@Autowired
	BecaRepository becaRepository;
	@Autowired
	CursoService cursoService;
	@Autowired
	BecaService becaService;
	@Autowired
	ParticipanteRepository participanteRepository;

	public Inscripcion save(int idParticipante, int idCurso) throws Exception {
		Inscripcion inscripcion = new Inscripcion();
		Optional<Curso> curso = cursoService.findById(idCurso);
		Curso cur = curso.get();
		if (!curso.isPresent()) {
			throw new Exception("El curso no existe");
		} else {
			inscripcion.setCurso(cur);
			Optional<Participante> par = participanteService.findById(idParticipante);
			Participante participante = par.get();
			if (!par.isPresent()) {
				throw new Exception("No existe participante con ese id");
			} else {
				inscripcion.setParticipante(participante);
			}
			Beca be = becaService.findByParticipante(idParticipante);
			if (be == null) {
				throw new Exception("Participante no tiene beca");
			}
			inscripcion.setBeca(be);
		}
		return inscripcionRepository.save(inscripcion);
	}

	public Inscripcion crearDirecta(int idParticipante, int idCurso) throws Exception {
		Inscripcion inscripcion = new Inscripcion();
		Optional<Curso> curso = cursoService.findById(idCurso);
		Curso cur = curso.get();
		if (!curso.isPresent()) {
			throw new Exception("El curso no existe");
		} else {
			if (cur.getNumParticipantes() == 0) {
				throw new Exception("No hay cupo");
			} else {
				inscripcion.setCurso(cur);
				Optional<Participante> par = participanteService.findById(idParticipante);
				Participante participante = par.get();
				if (!par.isPresent()) {
					throw new Exception("No existe participante con ese id");
				} else {
					if (participante.isTieneBeca() == false) {
						inscripcion.setParticipante(participante);
					}
				}
			}
		}
		return inscripcionRepository.save(inscripcion);

	}

	public void deleteById(int id) {
		inscripcionRepository.deleteById(id);

	}

	public Optional<Inscripcion> findById(int id) {
		return inscripcionRepository.findById(id);
	}

	public Iterable<Inscripcion> findAll() {
		return inscripcionRepository.findAll();
	}

}
