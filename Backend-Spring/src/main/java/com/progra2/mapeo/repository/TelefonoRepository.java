package com.progra2.mapeo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.progra2.mapeo.entity.Telefono;

@Repository("telefonoRepository")
public interface TelefonoRepository extends JpaRepository<Telefono, Integer>{

}
