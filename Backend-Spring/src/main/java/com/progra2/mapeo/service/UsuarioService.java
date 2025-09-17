package com.progra2.mapeo.service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.progra2.mapeo.entity.Correo;
import com.progra2.mapeo.entity.Publicacion;
import com.progra2.mapeo.entity.Usuario;
import com.progra2.mapeo.repository.CorreoRepository;
import com.progra2.mapeo.repository.PublicacionRepository;
import com.progra2.mapeo.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
@CrossOrigin
public class UsuarioService {
	@Autowired
	UsuarioRepository ur;
	
	@Autowired
	PublicacionRepository pr;
	
	@Autowired
	CorreoRepository cr;
	
	// Servicio de LogIn
	 @PostMapping(path = "/login")
	 public List<Usuario> login(@RequestBody Usuario usuario){
		 return ur.findByEmailAndPassword(usuario.getEmail(), usuario.getPassword());
	 }
	
	 @GetMapping(path="/buscar")
	 public List<Usuario> buscar(){
		 return ur.findAll();
	 }
	 
	 @PostMapping(path = "/guardar")
 	 public Usuario guardar (@RequestBody Usuario usuario){
		 List<Publicacion> publicaciones = usuario.getListaPublicaciones();
		 usuario.setListaPublicaciones(null);
		 ur.save(usuario);
		 		 
		 for(Publicacion pub : publicaciones){
			 pub.setIdusuario(usuario.getIdusuario());
		 }
		 
		 pr.saveAll(publicaciones);
		 usuario.setListaPublicaciones(publicaciones);
		 return usuario;
	}
	 
	 @DeleteMapping(path = "/eliminar/{idusuario}")
	 public void eliminar (@PathVariable ("idusuario") Integer idusuario) {
		 Optional<Usuario> usuario = ur.findById(idusuario);
		 if (usuario.isPresent()) {
			pr.deleteAll(usuario.get().getListaPublicaciones());
			ur.delete(usuario.get());
		}
	 }
	
	 
	 // Servicio de la consulta DSL declarada en UsuarioRepository usando el parámetro tipo PathVariable.
	 @GetMapping(path = "/buscar/email/{email}/password/{password}")
	 public List<Usuario> buscarUsuarioPor(@PathVariable String email,
			 							@PathVariable String password){
		 return ur.findByEmailAndPassword(email, password);
	 }
	 
	 // Servicio de la consulta DSL declarada en UsuarioRepository usando el tipo parámetro RequestParam.
	 @GetMapping(path = "/buscar/usuario")
	 public List<Usuario> buscarUsuario(@RequestParam (name="correo", required=false, defaultValue="jose@gmail.com") 
	 									String email,
			 							@RequestParam String password){ // Está si es obligatoria.
		 return ur.findByEmailAndPassword(email, password);
	 }
	 
	 
	 // Servicio ID 1.
	 @GetMapping(path = "/buscar/id/{idusuario}")
	 public Optional<Usuario> buscarUsuarioPorId(@PathVariable Integer idusuario){
		 return ur.findById(idusuario);
	 }
	 
	 // Servicio ID 2.
	 @GetMapping(path = "/buscar/publicacion")
	 public List<Publicacion> buscarIdPublicacion(@RequestParam Integer idusuario){
		 return pr.findByIdusuario(idusuario);
	 }
	 
	 //Servicio And/Or 1.
	 @GetMapping(path = "/buscar/empiezaTerminaCon/A")
	 public List<Usuario> buscarEmpiezaTerminaConA(){
		 return ur.findByNombreStartingWithAndNombreEndingWith("A", "a");
	 }
	 
	//Servicio And/Or 2.
	 @GetMapping(path = "/buscar/publicaciones")
	 public List<Publicacion> buscarAntesFechaUsuarioReciente(@RequestParam (name="fecha", required = false) 
	 											  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fecha, //Convirtiendo el String de Postman a formato de fecha para Date.
	 											  @RequestParam	 (name="idusuario", required = false)
			 								 	  Integer idusuario){
		 
		 return pr.findByFechaBeforeAndIdusuarioGreaterThan(fecha, idusuario);
	 }
	 
	 //Otro Servicio 1.
	 @GetMapping(path = "/buscar/usuarioAgosto/ordenado")
	 public List<Usuario> buscarDeAgostoOrdenado(){
		 LocalDateTime inicio = LocalDateTime.of(2025, 8, 1, 0, 0);
		 LocalDateTime fin = LocalDateTime.of(2025, 8, 31, 23, 59, 59);
		 return ur.findByFechaCreacionBetweenOrderByNombreAsc(inicio,fin);
	 }
	 
	 //Otro Servicio 3.
	 @GetMapping(path = "buscar/contiene/{cadena}")
	 public List<Usuario> buscarContieneCadena(@PathVariable String cadena){
		 
		 return ur.findByEmailContainsOrderByNombre(cadena);
	 }
	 
	 // SERVICIOS DE CORREO
	 @GetMapping(path="/buscar/correo")
	 public List<Correo> buscarCorreos(){
		 return cr.findAll();
	 }
	 
	 @PostMapping(path = "/guardar/correo")
 	 public Correo guardarCorreos (@RequestBody Correo correo){

		 return cr.save(correo);
	}
}
