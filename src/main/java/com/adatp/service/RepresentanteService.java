package com.adatp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adatp.model.Representante;
import com.adatp.repository.RepresentanteRepository;

@Service
public class RepresentanteService {
	@Autowired
	RepresentanteRepository representanteRepository;

	public Iterable<Representante> findAll() {
		return representanteRepository.findAll();
	}

	public Optional<Representante> findById(int id) {
		return representanteRepository.findById(id);
	}

	public Representante save(Representante representante) {

		return representanteRepository.save(representante);

	}

	public void deleteById(int id) {
		representanteRepository.deleteById(id);

	}

}
