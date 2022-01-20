package com.adatp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.adatp.Excepciones.NoAutorizadoException;
import com.adatp.form.CursoForm;
import com.adatp.form.enums.Estado;
import com.adatp.model.Curso;
import com.adatp.model.Empresa;
import com.adatp.model.Representante;
import com.adatp.repository.CursoRepository;

@Service
public class CursoService {
	@Autowired
	CursoRepository cursoRepository;
	@Autowired
	EmpresaService empresaService;
	@Autowired
	RepresentanteService representanteService;
	@Autowired
	UsuarioService usuarioService;

	public Optional<Curso> findByEmpresa(int idEmpresa) {
		Empresa empresa = new Empresa();
		empresa.setId(idEmpresa);
		Curso c = new Curso();
		c.setEmpresa(empresa);
		Example<Curso> e = Example.of(c);
		return cursoRepository.findOne(e);
	}

	public Optional<Curso> findById(int idCurso) {
		return cursoRepository.findById(idCurso);

	}

	public void deleteById(int id) {
		cursoRepository.deleteById(id);
	}

	public Curso save(CursoForm form) throws NoAutorizadoException {
		Optional<Representante> r = representanteService.findById(form.getIdRepresentante());
		Representante rep = r.get();
		if (r.isEmpty())
			throw new NoAutorizadoException("No se puede cargar curso");
		Optional<Empresa> em = empresaService.findById(form.getIdEmpresa());
		Empresa empresa = em.get();
		if (!empresa.getEstado().equals(Estado.APROBADO))
			throw new NoAutorizadoException("La empresa no está aprobada");
		Curso curso = new Curso();
		curso.setEmpresa(empresa);
		curso.setRepresentante(rep);
		curso.setCategorias(form.getCategorias());
		curso.setCosto(form.getCosto());
		curso.setDescripcion(form.getDescripcion());
		curso.setHoras(form.getHoras());
		curso.setModalidad(form.getModalidad());
		curso.setNombre(form.getNombre());
		curso.setNumParticipantes(form.getNumParticipantes());
		return cursoRepository.save(curso);
	}

	public Iterable<Curso> findAll() {
		return cursoRepository.findAll();
	}

}
