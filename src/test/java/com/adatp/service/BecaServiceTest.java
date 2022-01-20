package com.adatp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.adatp.form.BecaForm;
import com.adatp.model.Beca;

class BecaServiceTest {
	@Autowired
	BecaService becaService;

	@Test
	public void testSaveBeca() throws Exception {
		BecaForm form = new BecaForm();
		form.setEstudia(true);
		form.setFamiliaCargo(1);
		form.setIdParticipante(9);
		form.setIngresos(50000);
		form.setTrabaja(false);

		Beca test = becaService.save(form);

		assertTrue(test.isEstudia());
		assertEquals(1, test.getFamiliaCargo());
		assertEquals(9, test.getParticipante());
		assertEquals(50000, test.getIngresos());
		assertFalse(test.isTrabaja());
	}

}
