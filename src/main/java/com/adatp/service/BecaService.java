package com.adatp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adatp.model.Beca;
import com.adatp.repository.BecaRepository;

@Service
public class BecaService {
	@Autowired
	BecaRepository becaRepository;

	public Beca save(Beca beca) {
		return becaRepository.save(beca);
	}

}
