package com.progra2.mapeo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.progra2.mapeo.entity.Calificacion;

@Repository("calificacionRepository")
public interface CalificacionRepository extends JpaRepository<Calificacion, Integer>{
	public List<Calificacion> findByNombre(String nombre);
}
