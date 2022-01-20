package com.adatp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adatp.Excepciones.NoAutorizadoException;
import com.adatp.Excepciones.NoUsuarioException;
import com.adatp.form.ParticipanteForm;
import com.adatp.form.enums.Rol;
import com.adatp.model.Participante;
import com.adatp.model.Usuario;
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
	@Autowired
	UsuarioService usuarioService;

	public Participante save(ParticipanteForm form) throws NoUsuarioException, NoAutorizadoException {
		Optional<Usuario> us = usuarioService.findById(form.getIdUsuario());
		if (us.isEmpty())
			throw new NoUsuarioException("No existe usuario");
		Usuario usuario = us.get();
		if (!usuario.getRol().equals(Rol.PARTICIPANTE))
			throw new NoAutorizadoException("Usuario no autorizado");
		Participante par = new Participante();
		par.setApellido(form.getApellido());
		par.setNombre(form.getNombre());
		par.setResidencia(form.getResidencia());
		par.setGenero(form.getGenero());
		par.setFechaNacimiento(form.getFechaNacimiento());
		par.setTieneBeca(form.isTieneBeca());
		par.setUsuario(usuario);
		return participanteRepository.save(par);
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
