package com.aerolinea.api.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Clase que define una entidad para el mapeo O/R de la tabla Reserva.
 */
@Entity
@Table(name = "reserva")
public class Reserva implements Serializable {

	private static final long serialVersionUID = -673781346087828472L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "reserva_id")
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "vuelo_id_fk")
	private Vuelo vuelo;

	@Column(name = "fecha_reserva", nullable = false)
	private LocalDateTime fechaReserva;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Vuelo getVuelo() {
		return vuelo;
	}

	public void setVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
	}

	public LocalDateTime getFechaReserva() {
		return fechaReserva;
	}

	public void setFechaReserva(LocalDateTime fechaReserva) {
		this.fechaReserva = fechaReserva;
	}

	@Override
	public String toString() {
		return "Reserva [id=" + id + ", vuelo=" + vuelo + ", fechaReserva=" + fechaReserva + "]";
	}

}