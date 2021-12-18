package com.adatp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.adatp.model.Usuario;
import com.adatp.service.UsuarioService;

@RestController
public class UsuarioController {
	@Autowired
	UsuarioService usuarioService;

	@PostMapping("/usuarios")
	public Usuario insertarUsuario(@RequestBody Usuario usuario) {
		return usuarioService.save(usuario);
	}

}
