package com.baseprojectapi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	public Connection AbrirConexion() {
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			 con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/baseproject","root","");  
			System.out.println("Conexion exitosa");
			return con;
		} catch (SQLException | ClassNotFoundException ex) {
			System.out.println("Error al abrir conexion");
			return con;
		}
	}

}
