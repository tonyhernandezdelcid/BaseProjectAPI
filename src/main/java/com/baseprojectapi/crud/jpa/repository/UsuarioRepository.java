package com.baseprojectapi.crud.jpa.repository;


import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

import com.baseprojectapi.crud.jpa.model.Usuario;

@RestController
public interface UsuarioRepository extends JpaRepository<Usuario,String> {

	List<Usuario> findByNombre(String nombre);
	List<Usuario> findByTelefono(String telefono);
	
	
}



