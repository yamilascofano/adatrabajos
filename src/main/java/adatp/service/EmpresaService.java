package adatp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import adatp.model.Empresa;
import adatp.repository.EmpresaRepository;

@Service
public class EmpresaService {
	@Autowired
	EmpresaRepository empresaRepository;

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
		return empresaRepository.save(empresa);
	}

}
