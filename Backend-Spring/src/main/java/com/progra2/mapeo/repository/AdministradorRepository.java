package com.progra2.mapeo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.progra2.mapeo.entity.Administrador;

@Repository("administradorRepository")
public interface AdministradorRepository extends JpaRepository<Administrador, Integer>{
	public List<Administrador> findByUsuarioStartingWithOrUsuarioEndingWith(String inicial, String ultima);
	public List<Administrador> findByUsuarioAndPassword(String usuario, String password);
}
