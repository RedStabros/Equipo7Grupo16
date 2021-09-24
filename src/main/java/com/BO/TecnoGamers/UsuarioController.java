package com.BO.TecnoGamers;

import java.util.*;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DAO.TecnoGamers.*;
import com.DTO.TecnoGamers.*;


@RestController
public class UsuarioController {
	
	//lista de usuarios
	
	@RequestMapping("/listausuarios")
	public ArrayList<UsuarioVO> listaDeUsuarios(){
		UsuarioDAO dao = new UsuarioDAO();
		
		return dao.listaDeUsuarios();
	}
	
	//buscar por ID
	
	@RequestMapping("/buscarusuarioID")
	public ArrayList<UsuarioVO> buscarUsuario(String cedula_usuario){
		UsuarioDAO dao = new UsuarioDAO();
		
		return dao.buscarUsuario(Long.parseLong(cedula_usuario));
	}
	
	//crear usuario
	
	@RequestMapping("/crearusuario")
	public boolean crearUsuario(String cedula_usuario,String nombre_usuario, String email_usuario, String usuario, String clave) {
		UsuarioDAO dao = new UsuarioDAO();
		UsuarioVO Usuario = new UsuarioVO();
		
		Usuario.setCedula_usuario(Long.parseLong(cedula_usuario));
		Usuario.setNombre_usuario(nombre_usuario);
		Usuario.setEmail_usuario(email_usuario);
		Usuario.setUsuario(usuario);
		Usuario.setClave(clave);
		
		return dao.crearUsuario(Usuario);
	}
	
	//Eliminar
	
	@RequestMapping("/borrarusuario")
	public boolean borrarUsuario(String cedula_usuario) {
		UsuarioDAO dao = new UsuarioDAO();
		
		return dao.borrarUsuario(Long.parseLong(cedula_usuario));
	}
	
	//Actualizar
	
	@RequestMapping("/actualizarusuario")
	public boolean actualizarUsuario(String cedula_usuario,String nombre_usuario, String email_usuario, String usuario, String clave) {
		UsuarioDAO dao = new UsuarioDAO();
		UsuarioVO Usuario = new UsuarioVO();
			
		Usuario.setCedula_usuario(Long.parseLong(cedula_usuario));
		Usuario.setNombre_usuario(nombre_usuario);
		Usuario.setEmail_usuario(email_usuario);
		Usuario.setUsuario(usuario);
		Usuario.setClave(clave);
			
		return dao.actualizarUsuario(Usuario);
	}
}
