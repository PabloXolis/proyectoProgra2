package com.progra2.mapeo.entity;

import java.io.Serializable;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "telefono")
public class Telefono implements Serializable{

	private static final long serialVersionUID = 3888306096509561249L;
	
	@Id
	@Column(name = "idtelefono")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	private Integer idtelefono;
	
	@Column(name = "telefono")
	private String telefono;
	
	@Column(name = "idadministrador")
	private Integer idadministrador;

	public Integer getIdtelefono() {
		return idtelefono;
	}

	public void setIdtelefono(Integer idtelefono) {
		this.idtelefono = idtelefono;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Integer getIdadministrador() {
		return idadministrador;
	}

	public void setIdadministrador(Integer idadministrador) {
		this.idadministrador = idadministrador;
	}
}
