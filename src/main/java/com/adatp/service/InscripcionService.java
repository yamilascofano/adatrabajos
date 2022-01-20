package com.adatp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adatp.Excepciones.CursoInvalidoException;
import com.adatp.Excepciones.InscripcionInvalidaException;
import com.adatp.Excepciones.NoAutorizadoException;
import com.adatp.Excepciones.NoCupoException;
import com.adatp.Excepciones.NoUsuarioException;
import com.adatp.Excepciones.ParticipanteInvalidoException;
import com.adatp.Excepciones.PorcentajeInvalidoException;
import com.adatp.form.InscripcionForm;
import com.adatp.form.PagosForm;
import com.adatp.form.enums.ModoPago;
import com.adatp.form.enums.Rol;
import com.adatp.model.Beca;
import com.adatp.model.Curso;
import com.adatp.model.Inscripcion;
import com.adatp.model.Participante;
import com.adatp.model.Usuario;
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
	UsuarioService usuarioService;
	@Autowired
	CursoService cursoService;
	@Autowired
	BecaService becaService;
	@Autowired
	ParticipanteRepository participanteRepository;

	public Inscripcion save(InscripcionForm form)
			throws CursoInvalidoException, ParticipanteInvalidoException, NoCupoException {
		Inscripcion inscripcion = new Inscripcion();
		Optional<Curso> curso = cursoService.findById(form.getIdCurso());
		Curso cur = curso.get();
		if (curso.isEmpty())
			throw new CursoInvalidoException("El curso no existe");
		Optional<Participante> par = participanteService.findById(form.getIdParticipante());
		if (par.isEmpty())
			throw new ParticipanteInvalidoException("No existe participante con ese id");
		Participante participante = par.get();
		inscripcion.setParticipante(participante);
		Optional<Beca> be = becaService.findByParticipante(form.getIdParticipante());
		if (be.isEmpty()) {
			int cupo = cur.getNumParticipantes();
			cur.setNumParticipantes(cupo - 1);
			if (cupo <= 0)
				throw new NoCupoException("No hay cupo");
			inscripcion.setCurso(cur);
			inscripcion.setModoPago(ModoPago.DIRECTA);
			inscripcion.setCupo(cupo);
		} else {
			inscripcion.setCurso(cur);
			inscripcion.setModoPago(ModoPago.ESPERA);
		}
		return inscripcionRepository.save(inscripcion);
	}

	public Inscripcion aprobar(PagosForm form) throws NoUsuarioException, NoAutorizadoException,
			InscripcionInvalidaException, PorcentajeInvalidoException {
		Optional<Usuario> us = usuarioService.findById(form.getIdUsuario());
		if (us.isEmpty())
			throw new NoUsuarioException("No existe usuario");
		Usuario usuario = us.get();
		if (!usuario.getRol().equals(Rol.ADMINISTRADOR))
			throw new NoAutorizadoException("Usuario no tiene permiso");
		Optional<Inscripcion> inscripcion = inscripcionRepository.findById(form.getIdInscripcion());
		Inscripcion i = inscripcion.get();
		Inscripcion insc = new Inscripcion();
		if (inscripcion.isEmpty())
			throw new InscripcionInvalidaException("No existe inscripcion con ese id");
		if (form.getModoPago().equals(ModoPago.PAGO_100) || form.getModoPago().equals(ModoPago.PAGO_75)
				|| form.getModoPago().equals(ModoPago.PAGO_50) || form.getModoPago().equals(ModoPago.RECHAZADA)) {
			int cupo = i.getCurso().getNumParticipantes();
			i.getCurso().setNumParticipantes(cupo - 1);
			insc.setCupo(cupo);
			insc.setId(i.getId());
			insc.setCurso(i.getCurso());
			insc.setParticipante(i.getParticipante());
			insc.setModoPago(form.getModoPago());
		} else {
			throw new PorcentajeInvalidoException("Porcentaje incorrecto");
		}
		return inscripcionRepository.save(insc);
	}

	public void deleteById(int id) {
		inscripcionRepository.deleteById(id);

	}

	public Iterable<Inscripcion> findAll() {

		return inscripcionRepository.findAll();
	}

}
