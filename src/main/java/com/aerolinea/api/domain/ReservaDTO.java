package com.aerolinea.api.domain;

import java.time.LocalDateTime;

import com.aerolinea.api.model.Vuelo;

public class ReservaDTO {

	private LocalDateTime fechaReserva;

	private Vuelo vuelo;

	public LocalDateTime getFechaReserva() {
		return fechaReserva;
	}

	public void setFechaReserva(LocalDateTime fechaReserva) {
		this.fechaReserva = fechaReserva;
	}

	public Vuelo getVuelo() {
		return vuelo;
	}

	public void setVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
	}

	@Override
	public String toString() {
		return "ReservaDTO [fechaReserva=" + fechaReserva + ", vuelo=" + vuelo + "]";
	}

}