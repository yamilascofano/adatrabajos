package adatp.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import adatp.model.Empresa;
import adatp.service.EmpresaService;

@RestController
public class EmpresaRestController {
	@Autowired
	EmpresaService empresaService;

	@GetMapping("/v2/empresas")
	public Iterable<Empresa> listadoEmpresas() {
		return empresaService.findAll();
	}

	@GetMapping("/v2/empresas{id}")

	public Optional<Empresa> listadoEmpresassPorId(@PathVariable int id) {
		return empresaService.findById(id);
	}

	@DeleteMapping("/empresas/{id}")
	public void borrarEmpresaPorId(@PathVariable int id) {
		empresaService.deleteById(id);
	}

	@PostMapping("/empresas")
	public Empresa insertarEmpresa(@RequestBody Empresa form) {

		return empresaService.save(form);
	}

	@PutMapping("/empresas")
	public Empresa modificarEmpresa(@RequestBody Empresa form) {

		return empresaService.save(form);
	}

}
