package pojo;
// Generated 25 nov 2022 12:11:54 by Hibernate Tools 5.5.9.Final

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Animales generated by hbm2java
 */
@Entity
@Table(name = "animales")
public class Animal implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "nombre", unique = true, nullable = false, length = 40)
	private String nombre;
	@Column(name = "peso_aproximado", nullable = false, length = 10, precision = 2)
	private BigDecimal pesoAproximado;
	@Column(name = "habitat", nullable = false, length = 40)
	private String habitat;

	public Animal() {
	}

	public Animal(String nombre, BigDecimal pesoAproximado, String habitat) {
		this.nombre = nombre;
		this.pesoAproximado = pesoAproximado;
		this.habitat = habitat;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getPesoAproximado() {
		return this.pesoAproximado;
	}

	public void setPesoAproximado(BigDecimal pesoAproximado) {
		this.pesoAproximado = pesoAproximado;
	}

	public String getHabitat() {
		return this.habitat;
	}

	public void setHabitat(String habitat) {
		this.habitat = habitat;
	}

}
