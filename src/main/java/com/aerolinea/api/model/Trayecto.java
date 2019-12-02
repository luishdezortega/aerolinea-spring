package com.aerolinea.api.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Clase que define una entidad para el mapeo O/R de la tabla Trayecto.
 */
@Entity
@Table(name = "trayecto")
public class Trayecto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7668183225531252278L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "trayecto_id")
	private Long id;

	@Column(name = "origen", nullable = false, length = 80)
	private String originCity;

	@Column(name = "destino", nullable = false, length = 80)
	private String destinationCity;

	@Column(name = "hora_salida", nullable = false)
	private Date dateExit;

	@Column(name = "hora_llegada", nullable = false)
	private Date dateArrival;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOriginCity() {
		return originCity;
	}

	public void setOriginCity(String originCity) {
		this.originCity = originCity;
	}

	public String getDestinationCity() {
		return destinationCity;
	}

	public void setDestinationCity(String destinationCity) {
		this.destinationCity = destinationCity;
	}

	public Date getDateExit() {
		return dateExit;
	}

	public void setDateExit(Date dateExit) {
		this.dateExit = dateExit;
	}

	public Date getDateArrival() {
		return dateArrival;
	}

	public void setDateArrival(Date dateArrival) {
		this.dateArrival = dateArrival;
	}

	@Override
	public String toString() {
		return "Trayecto [id=" + id + ", originCity=" + originCity + ", destinationCity=" + destinationCity
				+ ", dateExit=" + dateExit + ", dateArrival=" + dateArrival + "]";
	}

}