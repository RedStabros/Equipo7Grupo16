package com.DAO.TecnoGamers;


import java.beans.*;
import java.sql.*;
import java.sql.Statement;
import java.util.*;

import com.DTO.TecnoGamers.*;

public class ProveedorDAO {
	
	//lista de proveedores
	
	public ArrayList<ProveedorVO> listaDeProveedores(){
		ArrayList<ProveedorVO> misProveedores = new ArrayList<ProveedorVO>();
		Conexion conex = new Conexion();
		try {
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM proveedores");
			ResultSet res = consulta.executeQuery();
			
			while(res.next()) {
				ProveedorVO Proveedor = new ProveedorVO();
				Proveedor.setNit(res.getLong("nit"));
				Proveedor.setCiudad(res.getString("ciudad"));
				Proveedor.setDireccion(res.getString("direccion"));
				Proveedor.setNombre(res.getString("nombre"));
				Proveedor.setTelefono(res.getString("telefono"));
				misProveedores.add(Proveedor);
			}
			res.close();
			consulta.close();
			conex.desconectar();
			
		} catch (Exception e) {
			System.out.println("No se pudo conectar");
		}
		return misProveedores;
	}
	
	//buscar Proveedor
	
	public ArrayList<ProveedorVO> buscarProveedor(long nit){
		ArrayList<ProveedorVO> misProveedores = new ArrayList<ProveedorVO>();
		Conexion conex = new Conexion();
		try {
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM proveedores WHERE nit=?");
						
			consulta.setLong(1,nit);
			ResultSet res = consulta.executeQuery();
			
			while(res.next()) {
				ProveedorVO Proveedor = new ProveedorVO();
				
				Proveedor.setNit(res.getLong("nit"));
				Proveedor.setCiudad(res.getString("ciudad"));
				Proveedor.setDireccion(res.getString("direccion"));
				Proveedor.setNombre(res.getString("nombre"));
				Proveedor.setTelefono(res.getString("telefono"));
				misProveedores.add(Proveedor);
			}
			res.close();
			consulta.close();
			conex.desconectar();
		} catch (Exception e) {
			System.out.println("No se pudo conectar");
		}
		return misProveedores;
	}
	
	//verificar que proveedor existe
	
	public boolean existeProveedor(Long nit) {
		boolean existe = false;
		Conexion conex = new Conexion();
		try {
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM proveedores WHERE nit=?");
			
			consulta.setLong(1,nit);
			ResultSet res = consulta.executeQuery();
			if(res.next()) {
				existe = true;
			}
			res.close();
			consulta.close();
			conex.desconectar();
			
		} catch (Exception e) {
			System.out.println("No se pudo verificar si existe el proveedor");
		}
		return existe;
	}
	
	//crear proveedor
	
	public boolean crearProveedor(ProveedorVO Proveedor) {
		boolean swCrear = false;
		if(!existeProveedor(Proveedor.getNit())) {
			Conexion conex = new Conexion();
			try {
				Statement consulta = (Statement) conex.getConnection().createStatement();
				String SQL ="INSERT INTO proveedores (nit,ciudad,direccion,nombre,telefono) VALUES ("+
						Proveedor.getNit()+",'"+Proveedor.getCiudad()+"','"+Proveedor.getDireccion()+"','"+Proveedor.getNombre()+"','"+Proveedor.getTelefono()+"');";
				((java.sql.Statement) consulta).executeUpdate(SQL);
				((java.sql.Statement) consulta).close();
				
				conex.desconectar();
				swCrear = true;
				
			} catch (Exception e) {
				System.out.println("No se pudo crear el proveedor");
			}
			
		}else {
			System.out.println("El proveedor ya existe");
		}
		return swCrear;
	}
	
	//borrar proveedor
	
	public boolean borrarProveedor(Long nit) {
		boolean swCrear = false;
		if(existeProveedor(nit)) {
			Conexion conex = new Conexion();
			try {
				Statement consulta = (Statement) conex.getConnection().createStatement();
				String SQL = "DELETE FROM proveedores WHERE nit="+nit;
				
				consulta.executeUpdate(SQL);
				consulta.close();
				
				conex.desconectar();
				swCrear = true;
				
			} catch (Exception e) {
				System.out.println("No se pudo borrar el proveedor");
			}
		}else {
			System.out.println("El proveedor no existe");
		}
		return swCrear;
	}
	
	//actualizar
	
	public boolean actualizarProveedor(ProveedorVO Proveedor) {
		boolean swActualizar = false;
		if(existeProveedor(Proveedor.getNit())) {
			Conexion conex = new Conexion();
			try {
				Statement consulta = (Statement) conex.getConnection().createStatement();
				String SQL ="UPDATE proveedores SET nombre='"+Proveedor.getNombre()+"',"+"direccion='"+Proveedor.getDireccion()+"',"+"ciudad='"+Proveedor.getCiudad()+"',"+
				"telefono='"+Proveedor.getTelefono()+"' WHERE nit="+Proveedor.getNit();
				((java.sql.Statement) consulta).executeUpdate(SQL);
				((java.sql.Statement) consulta).close();
				
				conex.desconectar();
				swActualizar = true;
				
			} catch (Exception e) {
				System.out.println("No se pudo actualizar el proveedor");
			}
		}else {
			System.out.println("El proveedor no existe");
		}
		return swActualizar;
	}
		
	
}

