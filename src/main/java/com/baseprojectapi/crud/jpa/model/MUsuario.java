package com.baseprojectapi.crud.jpa.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


//Annotations
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "usuarios")
public class MUsuario {

	 // Attributes
    
	@Id private String id;
	private String codigo;
    private String nombre;
    private String telefono;
    
    
    public void setId(String id) {
		this.id = id;
	}
    
    public String getId() {
		return id;
	}
    
    public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
    public void setNombre(String nombre) {
		this.nombre = nombre;
	}
    public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
    
    public String getCodigo() {
		return codigo;
	}
    public String getNombre() {
		return nombre;
	}
    public String getTelefono() {
		return telefono;
	}
	
}
