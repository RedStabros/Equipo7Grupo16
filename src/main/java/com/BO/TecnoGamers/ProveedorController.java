package com.BO.TecnoGamers;

import java.util.*;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DAO.TecnoGamers.*;
import com.DTO.TecnoGamers.*;


@RestController
public class ProveedorController {
	
	//lista de proveedores
	
	@RequestMapping("/listaproveedores")
	public ArrayList<ProveedorVO> listaDeProveedores(){
		ProveedorDAO dao = new ProveedorDAO();
		
		return dao.listaDeProveedores();
	}
	
	//buscar por ID
	
	@RequestMapping("/buscarproveedorID")
	public ArrayList<ProveedorVO> buscarProveedor(String nit){
		ProveedorDAO dao = new ProveedorDAO();
		
		return dao.buscarProveedor(Long.parseLong(nit));
	}
	
	//crear proveedor
	
	@RequestMapping("/crearproveedor")
	public boolean crearProveedor(String nit,String ciudad, String direccion, String nombre, String telefono) {
		ProveedorDAO dao = new ProveedorDAO();
		ProveedorVO Proveedor = new ProveedorVO();
		
		Proveedor.setNit(Long.parseLong(nit));
		Proveedor.setCiudad(ciudad);
		Proveedor.setDireccion(direccion);
		Proveedor.setNombre(nombre);
		Proveedor.setTelefono(telefono);
		
		return dao.crearProveedor(Proveedor);
	}
	
	//Eliminar 
	
	@RequestMapping("/borrarproveedor")
	public boolean borrarProveedor(String nit) {
		ProveedorDAO dao = new ProveedorDAO();
		
		return dao.borrarProveedor(Long.parseLong(nit));
	}
	
	//Actualizar
	
	@RequestMapping("/actualizarproveedor")
	public boolean actualizarProveedor(String nit,String ciudad, String direccion, String nombre, String telefono) {
		ProveedorDAO dao = new ProveedorDAO();
		ProveedorVO Proveedor = new ProveedorVO();
		
		Proveedor.setNit(Long.parseLong(nit));
		Proveedor.setCiudad(ciudad);
		Proveedor.setDireccion(direccion);
		Proveedor.setNombre(nombre);
		Proveedor.setTelefono(telefono);
		
		return dao.actualizarProveedor(Proveedor);
	}
}
