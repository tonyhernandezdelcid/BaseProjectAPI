package com.baseprojectapi.crud.apis;


import java.sql.Connection;
import java.util.LinkedList;
import java.util.List;

import org.json.JSONObject;
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
import com.baseprojectapi.dao.DBConnection;
import com.baseprojectapi.dao.UsuariosDAO;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/baseprojectapi")
public class restController {

	

	
	@GetMapping("/consultausuarios")
	public List<Usuario> consultaUsuarioss() {
		System.out.println("Entrando a micro servicios");
		UsuariosDAO userdao = new UsuariosDAO();
		List<Usuario> res =  userdao.consultarUsuarios();
		
		
		
		return res;
	}
	
	
	@PostMapping("/crearusuario")
	public boolean insertaUsuario(@RequestBody String datos) {
		System.out.println("creando usuario");
		UsuariosDAO userdao = new UsuariosDAO();
		Usuario usuario = new Usuario();
		try {
			JSONObject object = new JSONObject(datos);
			usuario.setCodigo(object.getString("codigo"));
			usuario.setNombre(object.getString("nombre"));
			usuario.setTelefono(object.getString("telefono"));
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		System.out.println("codigo: "+ usuario.getCodigo());
		System.out.println("nombre: "+ usuario.getNombre());
		System.out.println("telefono: "+ usuario.getTelefono());
		
		return userdao.insertarUsuario(usuario);
	}
	
	
	@PutMapping("/modificarusuario")
	public boolean modificaUsuario(@RequestBody String datos) {
		System.out.println("entrando a editar usuarios");
		UsuariosDAO userdao = new UsuariosDAO();
		Usuario usuario = new Usuario();
		try {
			JSONObject object = new JSONObject(datos);
			usuario.setCodigo(object.getString("codigo"));
			usuario.setNombre(object.getString("nombre"));
			usuario.setTelefono(object.getString("telefono"));
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		System.out.println("codigo mod: "+ usuario.getCodigo());
		System.out.println("nombre mod: "+ usuario.getNombre());
		System.out.println("telefono mod: "+ usuario.getTelefono());
		return userdao.modificarUsuario(usuario);
	}
	
	@DeleteMapping("/eliminausuario/{datos}")
	public boolean eliminarUsuario(@PathVariable  String datos) {
		System.out.println("Eliminando usuario "+datos);
		UsuariosDAO userdao = new UsuariosDAO();
		
		//boolean inserto = db.insertaBancos(ban);
		return userdao.eliminarUsuario(datos);
	}
	
}