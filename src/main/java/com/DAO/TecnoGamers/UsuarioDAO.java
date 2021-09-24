package com.DAO.TecnoGamers;


import java.beans.*;
import java.sql.*;
import java.sql.Statement;
import java.util.*;

import com.DTO.TecnoGamers.*;

public class UsuarioDAO {
	
	//lista de usuarios
	
	public ArrayList<UsuarioVO> listaDeUsuarios(){
		ArrayList<UsuarioVO> misUsuarios = new ArrayList<UsuarioVO>();
		Conexion conex = new Conexion();
		try {
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM usuarios");
			ResultSet res = consulta.executeQuery();
			
			while(res.next()) {
				UsuarioVO Usuario = new UsuarioVO();
				Usuario.setCedula_usuario(res.getLong("cedula_usuario"));
				Usuario.setNombre_usuario(res.getString("nombre_usuario"));
				Usuario.setEmail_usuario(res.getString("email_usuario"));
				Usuario.setUsuario(res.getString("usuario"));
				Usuario.setClave(res.getString("clave"));
				misUsuarios.add(Usuario);
			}
			res.close();
			consulta.close();
			conex.desconectar();
			
		} catch (Exception e) {
			System.out.println("No se pudo conectar");
		}
		return misUsuarios;
	}
	
	//buscar Usuario
	
	public ArrayList<UsuarioVO> buscarUsuario(long cedula_usuario){
		ArrayList<UsuarioVO> misUsuarios = new ArrayList<UsuarioVO>();
		Conexion conex = new Conexion();
		try {
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM usuarios WHERE cedula_usuario=?");
			//ResultSet res = consulta.executeQuery();
			
			consulta.setLong(1,cedula_usuario);
			ResultSet res = consulta.executeQuery();
			
			while(res.next()) {
				UsuarioVO Usuario = new UsuarioVO();
				
				Usuario.setCedula_usuario(res.getLong("cedula_usuario"));
				Usuario.setNombre_usuario(res.getString("nombre_usuario"));
				Usuario.setEmail_usuario(res.getString("email_usuario"));
				Usuario.setUsuario(res.getString("usuario"));
				Usuario.setClave(res.getString("clave"));
				misUsuarios.add(Usuario);
			}
			res.close();
			consulta.close();
			conex.desconectar();
		} catch (Exception e) {
			System.out.println("No se pudo conectar");
		}
		return misUsuarios;
	}
	
	//verificar que usuario existe
	
	public boolean existeUsuario(Long cedula_usuario) {
		boolean existe = false;
		Conexion conex = new Conexion();
		try {
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM usuarios WHERE cedula_usuario=?");
			
			consulta.setLong(1,cedula_usuario);
			ResultSet res = consulta.executeQuery();
			if(res.next()) {
				existe = true;
			}
			res.close();
			consulta.close();
			conex.desconectar();
			
		} catch (Exception e) {
			System.out.println("No se pudo verificar si existe el usuario");
		}
		return existe;
	}
	
	//crear usuario
	
	public boolean crearUsuario(UsuarioVO Usuario) {
		boolean swCrear = false;
		if(!existeUsuario(Usuario.getCedula_usuario())) {
			Conexion conex = new Conexion();
			try {
				Statement consulta = (Statement) conex.getConnection().createStatement();
				String SQL ="INSERT INTO usuarios (cedula_usuario,nombre_usuario,email_usuario,usuario,clave) VALUES ("+
						Usuario.getCedula_usuario()+",'"+Usuario.getNombre_usuario()+"','"+Usuario.getEmail_usuario()+"','"+Usuario.getUsuario()+"','"+Usuario.getClave()+"');";
				((java.sql.Statement) consulta).executeUpdate(SQL);
				((java.sql.Statement) consulta).close();
				
				conex.desconectar();
				swCrear = true;
				
			} catch (Exception e) {
				System.out.println("No se pudo crear el usuario");
			}
		}else {
			System.out.println("El usuario ya existe");
		}
		return swCrear;
	}
	
	//borra usuario
	
	public boolean borrarUsuario(Long cedula_usuario) {
		boolean swCrear = false;
		if(existeUsuario(cedula_usuario)) {
			Conexion conex = new Conexion();
			try {
				Statement consulta = (Statement) conex.getConnection().createStatement();
				String SQL = "DELETE FROM usuarios WHERE cedula_usuario="+cedula_usuario;
				//((java.sql.Statement) consulta).executeUpdate(SQL);
				//((java.sql.Statement) consulta).close();
				
				consulta.executeUpdate(SQL);
				consulta.close();
				
				conex.desconectar();
				swCrear = true;
				
			} catch (Exception e) {
				System.out.println("No se pudo borrar el usuario");
			}
		}else {
			System.out.println("El usuario no existe");
		}
		return swCrear;
	}
	
	//actualizar
	
	public boolean actualizarUsuario(UsuarioVO Usuario) {
		boolean swActualizar = false;
		if(existeUsuario(Usuario.getCedula_usuario())) {
			Conexion conex = new Conexion();
			try {
				Statement consulta = (Statement) conex.getConnection().createStatement();
				String SQL ="UPDATE usuarios SET nombre_usuario='"+Usuario.getNombre_usuario()+"',"+"email_usuario='"+Usuario.getEmail_usuario()+"',"+"usuario='"+Usuario.getUsuario()+"',"+
				"clave='"+Usuario.getClave()+"' WHERE cedula_usuario="+Usuario.getCedula_usuario();
				((java.sql.Statement) consulta).executeUpdate(SQL);
				((java.sql.Statement) consulta).close();
				
				conex.desconectar();
				swActualizar = true;
				
			} catch (Exception e) {
				System.out.println("No se pudo actualizar el usuario");
			}
		}else {
			System.out.println("El usuario no existe");
		}
		return swActualizar;
	}
		
	
}
