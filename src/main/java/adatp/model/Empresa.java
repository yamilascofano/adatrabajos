package adatp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity

public class Empresa {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nombre;
	private int cuil;
	private String tipoEmpresa;
	private String direccion;
	private String categoria;
	private int añoFundacion;
	private int numContacto;

	@ManyToOne
	@JoinColumn(name = "representante", nullable = false)
	private Representante representante;

}
