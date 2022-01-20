package com.adatp.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.adatp.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

	Optional<Usuario> findByRol(Usuario us);

}
