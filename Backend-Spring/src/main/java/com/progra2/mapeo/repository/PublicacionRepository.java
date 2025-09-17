package com.progra2.mapeo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.progra2.mapeo.entity.Publicacion;

@Repository("publicacionRepository")
public interface PublicacionRepository extends JpaRepository<Publicacion, Integer>{
	public List<Publicacion> findByIdusuario(Integer idpublicacion);
	public List<Publicacion> findByFechaBeforeAndIdusuarioGreaterThan(Date fecha, Integer idusuario);
}