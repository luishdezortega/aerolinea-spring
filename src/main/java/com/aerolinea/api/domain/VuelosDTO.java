package com.aerolinea.api.domain;

import com.aerolinea.api.model.Trayecto;

public class VuelosDTO {

	private Long id;

	private Double price;

	private Trayecto trayecto;

	private Long idAvion;

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

	public Long getIdAvion() {
		return idAvion;
	}

	public void setIdAvion(Long idAvion) {
		this.idAvion = idAvion;
	}

	@Override
	public String toString() {
		return "VuelosDTO [id=" + id + ", price=" + price + ", trayecto=" + trayecto + ", idAvion=" + idAvion + "]";
	}

}
