package com.BO.TecnoGamers;

import java.util.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DAO.TecnoGamers.*;
import com.DTO.TecnoGamers.*;

@RestController
public class ClienteController {
	//Lista de clientes
	@RequestMapping("/listaclientes")
	public ArrayList<ClienteVO> listaDeClientes(){
		ClienteDAO dao = new ClienteDAO();	
		
		return dao.listaDeClientes();
	}
	
	//Buscar por ID	
	@RequestMapping("/buscarclienteID")
	public ArrayList<ClienteVO> buscarCliente(String cedula_c){
		ClienteDAO dao = new ClienteDAO();		
		
		return dao.buscarCliente(Long.parseLong(cedula_c));
	}
	
	//Crear cliente
	@RequestMapping("/crearcliente")
	public boolean crearCliente(String cedula_c,String direccion_c, String email_c, String nombre_c, String telefono_c) {
		ClienteDAO dao = new ClienteDAO();
		ClienteVO Cliente = new ClienteVO();
		
		Cliente.setCedula_c(Long.parseLong(cedula_c));
		Cliente.setDireccion_c(direccion_c);
		Cliente.setEmail_c(email_c);
		Cliente.setNombre_c(nombre_c);
		Cliente.setTelefono_c(telefono_c);
		
		return dao.crearCliente(Cliente);
	}
	
	//Eliminar cliente
	@RequestMapping("/borrarcliente")
	public boolean borrarCliente(String cedula_c) {
		ClienteDAO dao = new ClienteDAO();
		
		return dao.borrarCliente(Long.parseLong(cedula_c));
	}
	
	//Actualizar cliente	
	@RequestMapping("/actualizarcliente")
	public boolean actualizarCliente(String cedula_c,String direccion_c, String email_c, String nombre_c, String telefono_c) {
		ClienteDAO dao = new ClienteDAO();
		ClienteVO Cliente = new ClienteVO();
			
		Cliente.setCedula_c(Long.parseLong(cedula_c));
		Cliente.setDireccion_c(direccion_c);
		Cliente.setEmail_c(email_c);
		Cliente.setNombre_c(nombre_c);
		Cliente.setTelefono_c(telefono_c);
			
		return dao.actualizarCliente(Cliente);
	}
}
