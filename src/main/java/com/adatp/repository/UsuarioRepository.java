package com.adatp.repository;

import org.springframework.data.repository.CrudRepository;

import com.adatp.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

}
