package com.progra2.mapeo.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.progra2.mapeo.entity.Usuario;

@Repository("usuarioRepository")
public interface UsuarioRepository extends JpaRepository <Usuario, Integer>{
	// Método abstracto para Constulta DSL.
	public List<Usuario> findByEmailAndPassword(String email, String password);
	
	public List<Usuario> findByNombreStartingWithAndNombreEndingWith(String inicial, String ultima);
	public List<Usuario> findByNombreStartingWithOrNombreEndingWith(String inicial, String ultima);
	public List<Usuario> findByFechaCreacionBetweenOrderByNombreAsc(LocalDateTime incio, LocalDateTime fin);
	public List<Usuario> findByEmailContainsOrderByNombre(String cadena);
}
