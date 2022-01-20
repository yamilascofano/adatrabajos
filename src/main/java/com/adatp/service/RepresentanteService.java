package com.adatp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adatp.Excepciones.NoAutorizadoException;
import com.adatp.Excepciones.NoUsuarioException;
import com.adatp.form.RepresentanteForm;
import com.adatp.form.enums.Rol;
import com.adatp.model.Representante;
import com.adatp.model.Usuario;
import com.adatp.repository.RepresentanteRepository;

@Service
public class RepresentanteService {
	@Autowired
	RepresentanteRepository representanteRepository;
	@Autowired
	UsuarioService usuarioService;

	public Iterable<Representante> findAll() {
		return representanteRepository.findAll();
	}

	public Optional<Representante> findById(int id) {
		return representanteRepository.findById(id);
	}

	public Representante save(RepresentanteForm form) throws NoUsuarioException, NoAutorizadoException {
		Optional<Usuario> us = usuarioService.findById(form.getIdUsuario());
		if (us.isEmpty())
			throw new NoUsuarioException("No existe usuario");
		Usuario usuario = us.get();
		if (!usuario.getRol().equals(Rol.REPRESENTANTE))
			throw new NoAutorizadoException("Usuario no autorizado");
		Representante rep = new Representante();
		rep.setApellido(form.getApellido());
		rep.setCargo(form.getCargo());
		rep.setDni(form.getDni());
		rep.setMail(form.getMail());
		rep.setNombre(form.getNombre());
		rep.setUsuario(usuario);
		return representanteRepository.save(rep);

	}

	public void deleteById(int id) {
		representanteRepository.deleteById(id);

	}

}
