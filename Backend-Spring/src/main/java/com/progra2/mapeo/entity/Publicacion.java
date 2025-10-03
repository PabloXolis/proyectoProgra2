package com.progra2.mapeo.entity;

import java.io.Serializable;
import java.util.Base64;
import java.util.Date;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "publicacion")
public class Publicacion implements Serializable{

	private static final long serialVersionUID = -7865577921907833346L;
	
	@Id
	@Column(name = "idpublicacion")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	private Integer idpublicacion;
	
	@Column(name = "texto")
	private String texto;
	
	
	
	@Column(name = "imagen")
	private String imagenbase64; //imagen en base 64.
	
	@Transient // No se mapea a la base de datos
    private byte[] imagen;
	
	public String getImagenbase64() {
		return imagenbase64;
	}

	public void setImagenbase64(String imagenbase64) {
		this.imagenbase64 = imagenbase64;
		this.imagen = imagenbase64 != null ? Base64.getDecoder().decode(imagenbase64) : null;
	}
	
	public byte[] getImagen() {
		return imagen;
	}

	
	@Column(name = "fecha")
	private Date fecha;
	
	@Column(name = "me_gusta")
	private Integer meGusta;
	
	@Column(name = "idusuario")
	private Integer idusuario;
	
	
	public Integer getIdpublicacion() {
		return idpublicacion;
	}

	public void setIdpublicacion(Integer idpublicacion) {
		this.idpublicacion = idpublicacion;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Integer getIdusuario() {
		return idusuario;
	}
	
	public Integer getMeGusta() {
		return meGusta;
	}

	public void setMeGusta(Integer meGusta) {
		this.meGusta = meGusta;
	}

	public void setIdusuario(Integer idusuario) {
		this.idusuario = idusuario;
	}
	
}
