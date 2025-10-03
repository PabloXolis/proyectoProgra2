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
@Table(name = "calificacion")
public class Calificacion implements Serializable{

	private static final long serialVersionUID = 5091309550463823427L;
	
	@Id
	@Column(name = "idcalificacion")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	private Integer idcalificacion;
	
	@Column(name = "fecha_calificacion")
	private String fechaCalificacion;
	
	@Column(name = "nota")
	private Integer nota;
	
	@Column(name = "nombre")
	private String nombre;

	public Integer getIdcalificacion() {
		return idcalificacion;
	}

	public void setIdcalificacion(Integer idcalificacion) {
		this.idcalificacion = idcalificacion;
	}

	public String getFechaCalificacion() {
		return fechaCalificacion;
	}

	public void setFechaCalificacion(String fechaCalificacion) {
		this.fechaCalificacion = fechaCalificacion;
	}

	public Integer getNota() {
		return nota;
	}

	public void setNota(Integer nota) {
		this.nota = nota;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
