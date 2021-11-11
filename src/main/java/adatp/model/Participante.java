package adatp.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Participante {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nombre;
	private String apellido;
	private Date fechaNacimiento;
	private String genero;
	private String residencia;

	@ManyToOne
	@JoinColumn(name = "socioeconomico", nullable = false)
	private Socioeconomico socioeconomico;
}
