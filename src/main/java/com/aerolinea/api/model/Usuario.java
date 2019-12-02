package com.aerolinea.api.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 3016271463594762020L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "usuario_id")
	private Long id;

	@Column(name = "identify_id")
	private Long identification;

	@Column(name = "nombre", nullable = false, length = 80)
	private String name;

	@Column(name = "nacionalidad", nullable = false, length = 80)
	private String nationality;

	@Column(name = "cellphone", nullable = false, length = 15)
	private String cellphone;

	@Column(name = "dateBorn", nullable = false)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
	private LocalDateTime dateBorn;

	@ManyToMany
	@JoinTable(name = "Usuario_Reservas", joinColumns = { @JoinColumn(name = "usuario_id") }, inverseJoinColumns = {
			@JoinColumn(name = "reserva_id") })
	private List<Reserva> reservas;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdentification() {
		return identification;
	}

	public void setIdentification(Long identification) {
		this.identification = identification;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public LocalDateTime getDateBorn() {
		return dateBorn;
	}

	public void setDateBorn(LocalDateTime dateBorn) {
		this.dateBorn = dateBorn;
	}

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", identification=" + identification + ", name=" + name + ", nationality="
				+ nationality + ", cellphone=" + cellphone + ", dateBorn=" + dateBorn + ", reservas=" + reservas + "]";
	}

}