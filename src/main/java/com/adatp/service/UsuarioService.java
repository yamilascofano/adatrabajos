package com.adatp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adatp.model.Usuario;
import com.adatp.repository.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	UsuarioRepository usuarioRepository;

	public Usuario save(Usuario us) {
		return usuarioRepository.save(us);
	}

	public Iterable<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

	public Optional<Usuario> findById(int id) {
		return usuarioRepository.findById(id);
	}

	public void deleteById(int id) {
		usuarioRepository.findById(id);

	}

}
