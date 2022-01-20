package com.adatp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adatp.Excepciones.NoAutorizadoException;
import com.adatp.Excepciones.NoUsuarioException;
import com.adatp.form.EmpresaForm;
import com.adatp.form.enums.Estado;
import com.adatp.form.enums.Rol;
import com.adatp.model.Empresa;
import com.adatp.model.Usuario;
import com.adatp.repository.EmpresaRepository;

@Service
public class EmpresaService {
	@Autowired
	EmpresaRepository empresaRepository;
	@Autowired
	RepresentanteService representanteService;
	@Autowired
	UsuarioService usuarioService;

	public Iterable<Empresa> findAll() {
		return empresaRepository.findAll();
	}

	public Optional<Empresa> findById(int id) {
		return empresaRepository.findById(id);
	}

	public void deleteById(int id) {
		empresaRepository.deleteById(id);
	}

	public Empresa save(Empresa empresa) {
		empresa.setEstado(Estado.EN_ESPERA);
		return empresaRepository.save(empresa);
	}

	public Empresa aprobar(EmpresaForm form) throws NoUsuarioException, NoAutorizadoException {
		Optional<Usuario> us = usuarioService.findById(form.getIdUsuario());
		if (us.isEmpty())
			throw new NoUsuarioException("No existe usuario");
		Usuario usuario = us.get();
		if (!usuario.getRol().equals(Rol.ADMINISTRADOR))
			throw new NoAutorizadoException("Usuario no autorizado");
		Optional<Empresa> emp = empresaRepository.findById(form.getIdEmpresa());
		Empresa e = emp.get();
		Empresa empresa = new Empresa();
		if (form.getEstado().equals(Estado.APROBADO))
			empresa.setId(e.getId());
		empresa.setCategoria(e.getCategoria());
		empresa.setAñoFundacion(e.getAñoFundacion());
		empresa.setCuil(e.getCuil());
		empresa.setDireccion(e.getDireccion());
		empresa.setNombre(e.getNombre());
		empresa.setNumContacto(e.getNumContacto());
		empresa.setTipoEmpresa(e.getTipoEmpresa());
		empresa.setEstado(form.getEstado());
		return empresaRepository.save(empresa);

	}

}
