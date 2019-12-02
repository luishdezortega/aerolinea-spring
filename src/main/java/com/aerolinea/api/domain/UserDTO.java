package com.aerolinea.api.domain;

import java.util.Date;

public class UserDTO {

	private Long id;

	private String name;

	private Long identification;

	private String nationality;

	private String cellphone;

	private Date dateBorn;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getIdentification() {
		return identification;
	}

	public void setIdentification(Long identification) {
		this.identification = identification;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public Date getDateBorn() {
		return dateBorn;
	}

	public void setDateBorn(Date dateBorn) {
		this.dateBorn = dateBorn;
	}

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", name=" + name + ", identification=" + identification + ", nationality="
				+ nationality + ", cellphone=" + cellphone + ", dateBorn=" + dateBorn + "]";
	}

}