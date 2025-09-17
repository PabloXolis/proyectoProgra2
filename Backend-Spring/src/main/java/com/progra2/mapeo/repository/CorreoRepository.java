package com.progra2.mapeo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.progra2.mapeo.entity.Correo;

@Repository("correoRepository")
public interface CorreoRepository extends JpaRepository <Correo, Integer>{
	
}
