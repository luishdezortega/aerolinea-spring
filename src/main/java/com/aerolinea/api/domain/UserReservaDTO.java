package com.aerolinea.api.domain;

public class UserReservaDTO {

	private UserDTO user;

	private Long idVuelo;

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public Long getIdVuelo() {
		return idVuelo;
	}

	public void setIdVuelo(Long idVuelo) {
		this.idVuelo = idVuelo;
	}

	@Override
	public String toString() {
		return "UserReservaDTO [user=" + user + ", idVuelo=" + idVuelo + "]";
	}

}