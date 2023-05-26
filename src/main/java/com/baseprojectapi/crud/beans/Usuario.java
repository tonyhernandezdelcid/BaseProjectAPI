package com.baseprojectapi.crud.beans;

public class Usuario {

	private String codigo;
	private String nombre;
	private String telefono;
	
	
	
	public Usuario() {
		
	}
	
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
}
