package com.baseprojectapi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import com.baseprojectapi.crud.beans.Usuario;

public class UsuariosDAO {

	
	public void UsuariosDao() {
		
		
		
	}
	
	
	
	public List<Usuario> consultarUsuarios(){
		List<Usuario> usuarios = new LinkedList<>();
		DBConnection dbcon = new DBConnection();
		String query = "SELECT CODIGO, NOMBRE, TELEFONO FROM USUARIOS";
		
		try(Connection conexion = dbcon.AbrirConexion(); PreparedStatement ps = conexion.prepareStatement(query);
				ResultSet rs = ps.executeQuery()) {
			
		while(rs.next()) {
			Usuario user = new Usuario();
			user.setCodigo(rs.getString("CODIGO"));
			user.setNombre(rs.getString("NOMBRE"));
			user.setTelefono(rs.getString("TELEFONO"));
			usuarios.add(user);
			
		}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return usuarios;
		
		
	}
	
	
	
	public boolean insertarUsuario(Usuario usr){
		boolean resultado = false;
		DBConnection dbcon = new DBConnection();
		String query = "INSERT INTO USUARIOS (CODIGO, NOMBRE, TELEFONO) VALUES (?,?,?)";
		
		try(Connection conexion = dbcon.AbrirConexion(); PreparedStatement ps = conexion.prepareStatement(query);
				) {
			
			ps.setString(1, usr.getCodigo());
			ps.setString(2, usr.getNombre());
			ps.setString(3, usr.getTelefono());
			
			int res = ps.executeUpdate();
			resultado = res>0?true:false;
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return resultado;
		
		
	}
	
	
	public boolean modificarUsuario(Usuario usr){
		boolean resultado = false;
		DBConnection dbcon = new DBConnection();
		String query = "UPDATE USUARIOS SET NOMBRE = ?, TELEFONO = ? WHERE CODIGO = ?";
		
		try(Connection conexion = dbcon.AbrirConexion(); PreparedStatement ps = conexion.prepareStatement(query);
				) {
			
			ps.setString(1, usr.getNombre());
			ps.setString(2, usr.getTelefono());
			ps.setString(3, usr.getCodigo());
			
			
			int res = ps.executeUpdate();
			resultado = res>0?true:false;
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return resultado;
		
		
	}
	
	
	public boolean eliminarUsuario(String codigo){
		boolean resultado = false;
		DBConnection dbcon = new DBConnection();
		String query = "DELETE FROM USUARIOS WHERE CODIGO = ?";
		
		try(Connection conexion = dbcon.AbrirConexion(); PreparedStatement ps = conexion.prepareStatement(query);
				) {
			
			ps.setString(1, codigo);
			
			
			
			int res = ps.executeUpdate();
			resultado = res>0?true:false;
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return resultado;
		
		
	}
	
	
}
