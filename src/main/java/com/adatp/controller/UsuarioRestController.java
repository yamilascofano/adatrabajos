package com.adatp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adatp.model.Usuario;
import com.adatp.service.UsuarioService;

@RestController
@RequestMapping("/v1/usuarios")
public class UsuarioRestController {
	@Autowired
	UsuarioService usuarioService;

	@PostMapping("/")
	public Usuario insertarUsuario(@RequestBody Usuario usuario) {
		return usuarioService.save(usuario);
	}

	@DeleteMapping("/{id}")
	public void borrarUsuarioPorId(@PathVariable int id) {
		usuarioService.deleteById(id);
	}

	@PutMapping("/")
	public Usuario modificarUsuario(@RequestBody Usuario usuario) {
		return usuarioService.save(usuario);
	}

	@GetMapping("/")
	public Iterable<Usuario> listadoUsuarios() {
		return usuarioService.findAll();
	}

}
