package com.DAO.TecnoGamers;

import java.beans.*;
import java.sql.*;
import java.sql.Statement;
import java.util.*;

import com.DTO.TecnoGamers.*;

public class ClienteDAO {
	
	//lista de clientes	
	public ArrayList<ClienteVO> listaDeClientes(){
		ArrayList<ClienteVO> misClientes = new ArrayList<ClienteVO>();
		Conexion conex = new Conexion();
		try {
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM clientes");
			ResultSet res = consulta.executeQuery();				
			while(res.next()) {
				ClienteVO Cliente = new ClienteVO();
				Cliente.setCedula_c(res.getLong("cedula_c"));
				Cliente.setDireccion_c(res.getString("direccion_c"));
				Cliente.setEmail_c(res.getString("email_c"));
				Cliente.setNombre_c(res.getString("nombre_c"));
				Cliente.setTelefono_c(res.getString("telefono_c"));
				misClientes.add(Cliente);
			}
			res.close();
			consulta.close();
			conex.desconectar();				
		} catch (Exception e) {
			System.out.println("No se pudo conectar");
		}
		return misClientes;
	}
		
	//buscar cliente
	public ArrayList<ClienteVO> buscarCliente(long cedula_c){
		ArrayList<ClienteVO> misClientes = new ArrayList<ClienteVO>();
		Conexion conex = new Conexion();
		try {
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM clientes WHERE cedula_c=?");			
			consulta.setLong(1,cedula_c);
			ResultSet res = consulta.executeQuery();
			while(res.next()) {
				ClienteVO Cliente = new ClienteVO();
				Cliente.setCedula_c(res.getLong("cedula_c"));
				Cliente.setDireccion_c(res.getString("direccion_c"));
				Cliente.setEmail_c(res.getString("email_c"));
				Cliente.setNombre_c(res.getString("nombre_c"));
				Cliente.setTelefono_c(res.getString("telefono_c"));
				misClientes.add(Cliente);
			}
			res.close();
			consulta.close();
			conex.desconectar();
		} catch (Exception e) {
			System.out.println("No se pudo conectar");
		}
		return misClientes;
	}
	
	//verificar que el cliente existe	
	public boolean existeCliente(Long cedula_c) {
		boolean existe = false;
		Conexion conex = new Conexion();
		try {
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM clientes WHERE cedula_c=?");			
			consulta.setLong(1,cedula_c);
			ResultSet res = consulta.executeQuery();
			if(res.next()) {
				existe = true;
			}
			res.close();
			consulta.close();
			conex.desconectar();
			
		} catch (Exception e) {
			System.out.println("No se pudo verificar si existe el cliente");
		}
		return existe;
	}
	
	//crear cliente	
	public boolean crearCliente(ClienteVO Cliente) {
		boolean swCrear = false;
		if(!existeCliente(Cliente.getCedula_c())) {
			Conexion conex = new Conexion();
			try {
				Statement consulta = (Statement) conex.getConnection().createStatement();
				String SQL ="INSERT INTO clientes (cedula_c,direccion_c,email_c,nombre_c,telefono_c) VALUES ("+
						Cliente.getCedula_c()+",'"+Cliente.getDireccion_c()+"','"+Cliente.getEmail_c()+"','"+Cliente.getNombre_c()+"','"+Cliente.getTelefono_c()+"');";
				((java.sql.Statement) consulta).executeUpdate(SQL);
				((java.sql.Statement) consulta).close();				
				conex.desconectar();
				swCrear = true;				
			} catch (Exception e) {
				System.out.println("No se pudo crear el cliente");
			}
		}else {
			System.out.println("El cliente ya existe");
		}
		return swCrear;
	}
	
	//borra cliente	
	public boolean borrarCliente(Long cedula_c) {
		boolean swCrear = false;
		if(existeCliente(cedula_c)) {
			Conexion conex = new Conexion();
			try {
				Statement consulta = (Statement) conex.getConnection().createStatement();
				String SQL = "DELETE FROM clientes WHERE cedula_c="+cedula_c;	
				consulta.executeUpdate(SQL);
				consulta.close();				
				conex.desconectar();
				swCrear = true;				
			} catch (Exception e) {
				System.out.println("No se pudo borrar el cliente");
			}
		}else {
			System.out.println("El cliente no existe");
		}
		return swCrear;
	}
	
	//actualizar cliente
	public boolean actualizarCliente(ClienteVO Cliente) {
		boolean swActualizar = false;
		if(existeCliente(Cliente.getCedula_c())) {
			Conexion conex = new Conexion();
			try {
				Statement consulta = (Statement) conex.getConnection().createStatement();
				String SQL ="UPDATE clientes SET direccion_c='"+Cliente.getDireccion_c()+"',"+"email_c='"+Cliente.getEmail_c()+"',"+"nombre_c='"+Cliente.getNombre_c()+"',"+
				"telefono_c='"+Cliente.getTelefono_c()+"' WHERE cedula_c="+Cliente.getCedula_c();
				((java.sql.Statement) consulta).executeUpdate(SQL);
				((java.sql.Statement) consulta).close();				
				conex.desconectar();
				swActualizar = true;			
			} catch (Exception e) {
				System.out.println("No se pudo actualizar el cliente");
			}
		}else {
			System.out.println("El cliente no existe");
		}
		return swActualizar;
	}
}
