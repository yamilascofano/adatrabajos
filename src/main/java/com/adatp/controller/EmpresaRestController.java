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

import com.adatp.Excepciones.NoAutorizadoException;
import com.adatp.Excepciones.NoUsuarioException;
import com.adatp.form.EmpresaForm;
import com.adatp.model.Empresa;
import com.adatp.service.EmpresaService;

@RestController
@RequestMapping("/v1/empresas")
public class EmpresaRestController {
	@Autowired
	EmpresaService empresaService;

	@GetMapping("/")
	public Iterable<Empresa> listadoEmpresas() {
		return empresaService.findAll();
	}

	@DeleteMapping("/{id}")
	public void borrarEmpresaPorId(@PathVariable int id) {
		empresaService.deleteById(id);
	}

	@PostMapping("/insertar")
	public Empresa insertarEmpresa(@RequestBody Empresa form) {
		return empresaService.save(form);
	}

	@PostMapping("/aprobar")
	public Empresa aprobarEmpresa(@RequestBody EmpresaForm form) throws NoUsuarioException, NoAutorizadoException {
		return empresaService.aprobar(form);
	}

	@PutMapping("/")
	public Empresa modificarEmpresa(@RequestBody Empresa form) {
		return empresaService.save(form);
	}

}
