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
@Table(name = "correo")
public class Correo implements Serializable{

	private static final long serialVersionUID = -6500657893479732825L;
	
	@Id
	@Column(name = "idcorreo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional=false)
	private Integer idcorreo;
	
	@Column(name = "correo")
	private String correo;
	
	@Column(name = "idusuario")
	private Integer idusuario;

	public Integer getIdcorreo() {
		return idcorreo;
	}

	public void setIdcorreo(Integer idcorreo) {
		this.idcorreo = idcorreo;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Integer getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(Integer idusuario) {
		this.idusuario = idusuario;
	}
}