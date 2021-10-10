package com.DAO.TecnoGamers;

import java.sql.*;

public class Conexion {
	static String bd =  "tecno_tienda"; 
	   static String login = "root"; 
	   static String password = "1234"; 
	 
	   static String url = "jdbc:mysql://localhost:3307/"+bd; 
	   Connection connection = null; 
	 
	   /** Constructor de Conexion a base de datos */ 
	   public Conexion() { 
	      try{ 
	         Class.forName("com.mysql.cj.jdbc.Driver"); 
	         connection = DriverManager.getConnection(url,login,password); 	 
	         if (connection!=null){ 
	            System.out.println("Conexión a base de datos "+bd+" OK Conectado \n"); 
	         } 
	      } 
	      catch(SQLException e){ 
	         System.out.println(e); 
	      }catch(ClassNotFoundException e){ 
	         System.out.println(e); 	     
	      } 
	   } 
	   public Connection getConnection(){ 
	      return connection; 
	   } 	 
	   public void desconectar(){ 
	      connection = null; 
	   }
}