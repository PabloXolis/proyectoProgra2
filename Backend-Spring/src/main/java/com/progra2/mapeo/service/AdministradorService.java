package com.progra2.mapeo.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.progra2.mapeo.entity.Administrador;
import com.progra2.mapeo.entity.Telefono;
import com.progra2.mapeo.repository.AdministradorRepository;
import com.progra2.mapeo.repository.TelefonoRepository;

@RestController
@RequestMapping("/administrador")
@CrossOrigin
public class AdministradorService {
	@Autowired
	AdministradorRepository ar;
	
	@Autowired
	TelefonoRepository tr;
	
	// Servicio de LogIn
	 @PostMapping(path = "/login")
	 public List<Administrador> login(@RequestBody Administrador administrador){
		 return ar.findByUsuarioAndPassword(administrador.getUsuario(), administrador.getPassword());
	 }
	
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
	
	 @PatchMapping(path = "/modificar/{id}")
	 public ResponseEntity<Administrador> modificarAdmin(
		 @PathVariable("id") Integer idadmin,
	     @RequestBody Map<String, Object> cambios) {

	     Optional<Administrador> adminBD = ar.findById(idadmin);

	     if(adminBD.isPresent()) {
	    	 Administrador admin = adminBD.get();
	        
	         if(cambios.containsKey("usuario")) {
	             admin.setUsuario((String) cambios.get("usuario"));
	         }
	         if(cambios.containsKey("password")) {
	        	 admin.setPassword((String) cambios.get("password"));
	         }

	         ar.save(admin);

	         return ResponseEntity.ok(admin);
	     } else {
	         return ResponseEntity.notFound().build();
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
	 
	 // CRUD Teléfono
		@GetMapping(path = "/buscar/telefono")
		public List<Telefono> buscarTelefono(){
			return tr.findAll();
		}
		
		@PostMapping(path = "/guardar/telefono")
		public Telefono guardarTelefono(@RequestBody Telefono telefono) {
			tr.save(telefono);
			return telefono;
		}
		
		@DeleteMapping(path = "/eliminar/telefono/{idtelefono}")
		public void eliminarTelefono(@PathVariable Integer idtelefono) {
			Optional<Telefono> telefono = tr.findById(idtelefono); 
			if (telefono.isPresent()){
				tr.delete(telefono.get());
			}
		}
		
	 @PatchMapping(path = "/modificar/telefono/{id}")
	 public ResponseEntity<Telefono> modificarTelefono(
		 @PathVariable("id") Integer idTelefono,
	     @RequestBody Map<String, Object> cambios) {

	     Optional<Telefono> telefonoBD = tr.findById(idTelefono);

	     if(telefonoBD.isPresent()) {
	         Telefono telefono = telefonoBD.get();
	        
	         if(cambios.containsKey("telefono")) {
	             telefono.setTelefono((String) cambios.get("telefono"));
	         }
	         if(cambios.containsKey("idadministrador")) {
        	    telefono.setIdadministrador((Integer) cambios.get("idadministrador"));
        	}

	         tr.save(telefono);

	         return ResponseEntity.ok(telefono);
	     } else {
	         return ResponseEntity.notFound().build();
	     }
	 }
}
