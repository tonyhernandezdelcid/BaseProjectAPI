package com.baseprojectapi.crud.jpa.model;


import javax.persistence.*; // for Spring Boot 2

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;



@RestController
@Entity
@Table(name = "usuarios")
public class Usuario {


@Id
private String codigo;

@Column(name = "nombre")
private String nombre;

@Column(name = "telefono")
private String telefono;

public Usuario() {
	
}

public Usuario(String codigo, String nombre, String telefono) {
	this.codigo = codigo;
	this.nombre = nombre;
	this.telefono = telefono;
}

public String getCodigo() {
	return codigo;
}

public void setCodigo(String codigo) {
	this.codigo = codigo;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public String getTelefono() {
	return telefono;
}

public void setTelefono(String telefono) {
	this.telefono = telefono;
}

@Override
public String toString() {
	return "Usuario [codigo=" + codigo + ", nombre=" + nombre + ", telefono=" + telefono + "]";
}
	
	



}
