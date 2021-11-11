package adatp.repository;

import org.springframework.data.repository.CrudRepository;

import adatp.model.Empresa;

public interface EmpresaRepository extends CrudRepository<Empresa, Integer> {

}
