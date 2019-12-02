package com.aerolinea.api.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Clase que define una entidad para el mapeo O/R de la tabla Vuelo.
 */
@Entity
@Table(name = "vuelo")
public class Vuelo implements Serializable {

	private static final long serialVersionUID = 4310117886956278401L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "vuelo_id")
	private Long id;

	@Column(name = "price", nullable = false)
	private Double price;

	@OneToOne
	@JoinColumn(name = "trayecto_id_fk", referencedColumnName = "trayecto_id")
	private Trayecto trayecto;

	@OneToOne
	@JoinColumn(name = "avion_id_fk", referencedColumnName = "avion_id")
	private Avion avion;

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "vuelo")
	private List<Reserva> reservas;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Trayecto getTrayecto() {
		return trayecto;
	}

	public void setTrayecto(Trayecto trayecto) {
		this.trayecto = trayecto;
	}

	public Avion getAvion() {
		return avion;
	}

	public void setAvion(Avion avion) {
		this.avion = avion;
	}

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	@Override
	public String toString() {
		return "Vuelo [id=" + id + ", price=" + price + ", trayecto=" + trayecto + ", avion=" + avion + ", reservas="
				+ reservas + "]";
	}

}