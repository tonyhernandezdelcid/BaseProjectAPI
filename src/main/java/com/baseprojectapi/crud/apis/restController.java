package com.baseprojectapi.crud.apis;


import java.sql.Connection;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baseprojectapi.crud.beans.Usuario;
import com.baseprojectapi.crud.jpa.repository.MUsuarioRepository;
//import com.baseprojectapi.crud.jpa.repository.UsuarioRepository;
import com.baseprojectapi.dao.DBConnection;
import com.baseprojectapi.dao.UsuariosDAO;
import java.util.Optional;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/baseprojectapi")
public class restController {

	@Autowired
	//UsuarioRepository usuarioRepository;
	MUsuarioRepository musuarioRepository;

	
	@GetMapping("/consultausuarios")
	//public List<com.baseprojectapi.crud.jpa.model.Usuario> consultaUsuarioss() {
	public List<com.baseprojectapi.crud.jpa.model.MUsuario> consultaUsuarioss() {
		System.out.println("Entrando a micro servicios");

		//List<com.baseprojectapi.crud.jpa.model.Usuario> usuarios = new ArrayList<com.baseprojectapi.crud.jpa.model.Usuario>();
		List<com.baseprojectapi.crud.jpa.model.MUsuario> usuarios = new ArrayList<com.baseprojectapi.crud.jpa.model.MUsuario>();
		
		try {
			//usuarioRepository.findAll().forEach(usuarios::add);	
			usuarios = musuarioRepository.findAll();
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		
		
		
		//UsuariosDAO userdao = new UsuariosDAO();
		//List<Usuario> res =  userdao.consultarUsuarios();
		
		
		
		System.out.println("saliendo de api");
		
		
		return usuarios;
	}
	
	
	@PostMapping("/crearusuario")
	public boolean insertaUsuario(@RequestBody String datos) {
		System.out.println("creando usuario");
		//UsuariosDAO userdao = new UsuariosDAO();
		//Usuario usuario = new Usuario();
		//com.baseprojectapi.crud.jpa.model.Usuario usuario = new com.baseprojectapi.crud.jpa.model.Usuario();
		com.baseprojectapi.crud.jpa.model.MUsuario usuario = new com.baseprojectapi.crud.jpa.model.MUsuario();
		try {
			JSONObject object = new JSONObject(datos);
			usuario.setCodigo(object.getString("codigo"));
			usuario.setNombre(object.getString("nombre"));
			usuario.setTelefono(object.getString("telefono"));
			
			

			System.out.println("codigo: "+ usuario.getCodigo());
			System.out.println("nombre: "+ usuario.getNombre());
			System.out.println("telefono: "+ usuario.getTelefono());
			
			
			//usuarioRepository.save(usuario);
			musuarioRepository.save(usuario);
			
			return true;
		} catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
		
		
		
		
		
		
		
		
		
		
		//return userdao.insertarUsuario(usuario);
	}
	
	
	@PutMapping("/modificarusuario")
	public boolean modificaUsuario(@RequestBody String datos) {
		System.out.println("entrando a editar usuarios");
		
		
		com.baseprojectapi.crud.jpa.model.MUsuario usuario = new com.baseprojectapi.crud.jpa.model.MUsuario();
		//com.baseprojectapi.crud.jpa.model.Usuario usuario = new com.baseprojectapi.crud.jpa.model.Usuario();
		//UsuariosDAO userdao = new UsuariosDAO();
		//Usuario usuario = new Usuario();
		try {
			JSONObject object = new JSONObject(datos);
			usuario.setId(object.getString("id"));
			usuario.setCodigo(object.getString("codigo"));
			usuario.setNombre(object.getString("nombre"));
			usuario.setTelefono(object.getString("telefono"));
			
			System.out.println("id mod: "+ usuario.getId());
			System.out.println("codigo mod: "+ usuario.getCodigo());
			System.out.println("nombre mod: "+ usuario.getNombre());
			System.out.println("telefono mod: "+ usuario.getTelefono());
			
			//Optional<com.baseprojectapi.crud.jpa.model.Usuario> usuarioData = usuarioRepository.findById(usuario.getCodigo());
			Optional<com.baseprojectapi.crud.jpa.model.MUsuario> usuarioData = musuarioRepository.findById(usuario.getId());
			
			if (usuarioData.isPresent()) {
				//usuarioRepository.save(usuario);
				musuarioRepository.save(usuario);
				
				return true;
			}else {
				
				return false;
			}
			
			
			
			
		} catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
		
		
		//return userdao.modificarUsuario(usuario);
	}
	
	@DeleteMapping("/eliminausuario/{datos}")
	public boolean eliminarUsuario(@PathVariable  String datos) {
		System.out.println("Eliminando usuario "+datos);
		//UsuariosDAO userdao = new UsuariosDAO();
		
		//boolean inserto = db.insertaBancos(ban);
		//return userdao.eliminarUsuario(datos);
		
		try {
			//usuarioRepository.deleteById(datos);
			musuarioRepository.deleteById(datos);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	
	@GetMapping("/verusrindividual/{datos}")
	//public com.baseprojectapi.crud.jpa.model.Usuario verusrindividual(@PathVariable  String datos) {
	public com.baseprojectapi.crud.jpa.model.MUsuario verusrindividual(@PathVariable  String datos) {
		
		
		System.out.println("entrando a consultar usuario individual "+datos);
		
		
		
		try {
			
			//Optional<com.baseprojectapi.crud.jpa.model.Usuario> usuarioData = usuarioRepository.findById(datos);
			Optional<com.baseprojectapi.crud.jpa.model.MUsuario> usuarioData = musuarioRepository.findById(datos);
			
			
			if (usuarioData.isPresent()) {
				return usuarioData.get();
			}else {
				return null;
			}
			
			

		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
}
