package com.progra2.mapeo.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.progra2.mapeo.entity.Administrador;
import com.progra2.mapeo.entity.Usuario;
import com.progra2.mapeo.repository.AdministradorRepository;

@RestController
@RequestMapping("/administrador")
@CrossOrigin
public class AdministradorService {
	@Autowired
	AdministradorRepository ar;
	
	@GetMapping(path = "/buscar")
	public List<Administrador> buscar(){
		return ar.findAll();
	}
	
	@PostMapping(path = "/guardar")
	public Administrador guardar(@RequestBody Administrador administrador) {
		ar.save(administrador);
		return administrador;
	}
	
	@DeleteMapping(path = "/eliminar/{idadministrador}")
	public void eliminar (@PathVariable Integer idadministrador) {
		Optional<Administrador> administrador = ar.findById(idadministrador); 
		if (administrador.isPresent()){
			ar.delete(administrador.get());
		}
	}
	
	// Servicio ID 3.
	@GetMapping(path = "/buscar/id/{idadministrador}")
	public Optional<Administrador> buscarAdminPorId (@PathVariable Integer idadministrador){
		return ar.findById(idadministrador);
	}
	
	//Servicio And/Or 3.
	 @GetMapping(path = "/buscar/empiezaTerminaCon")
	 public List<Administrador> buscarEmpiezaTerminaCon(@RequestParam (name="inicia", required = false) 
	 											  String inicia,
	 											  @RequestParam	 (name="termina", required = false)
			 								 	  String termina){
		 
		 return ar.findByUsuarioStartingWithOrUsuarioEndingWith(inicia, termina);
	 }
	 
	 //Otro Servicio 2.
	 @GetMapping(path = "/buscar/usuario/{usuario}/password/{password}")
	 public List<Administrador> buscarDeAgostoOrdenado(@PathVariable String usuario, 
			 										   @PathVariable String password){
		 
		 return ar.findByUsuarioAndPassword(usuario, password);
	 }
}
