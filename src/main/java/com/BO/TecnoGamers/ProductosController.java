package com.BO.TecnoGamers;

import java.util.*;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DAO.TecnoGamers.*;
import com.DTO.TecnoGamers.*;


@RestController
public class ProductosController {
	
	//lista
	
		@RequestMapping("/listaproductos")
		public ArrayList<ProductosVO> listaDeProductos(){
			ProductosDAO dao = new ProductosDAO();
			
			return dao.listaDeProductos();
		}
		
		//buscar por ID
		
		@RequestMapping("/buscarproductoID")
		public ArrayList<ProductosVO> buscarProducto(String codigo_producto){
			ProductosDAO dao = new ProductosDAO();
			
			return dao.buscarProducto(Long.parseLong(codigo_producto));
		}
		
		//crear 
		
		@RequestMapping("/crearproducto")
		public boolean crearProducto(String codigo_producto,String nombre_producto, String nit, String precio_compra, String iva_compra, String precio_venta) {
			ProductosDAO dao = new ProductosDAO();
			ProductosVO Producto = new ProductosVO();
			
			Producto.setCodigo_producto(Long.parseLong(codigo_producto));
			Producto.setNombre_producto(nombre_producto);
			Producto.setNit(Long.parseLong(nit));
			Producto.setPrecio_compra(Double.parseDouble(precio_compra));
			Producto.setIva_compra(Double.parseDouble(iva_compra));
			Producto.setPrecio_venta(Double.parseDouble(precio_venta));
			
			return dao.crearProducto(Producto);
		}
		
		//Eliminar
		
		@RequestMapping("/borrarproducto")
		public boolean borrarProducto(String codigo_producto) {
			ProductosDAO dao = new ProductosDAO();
			
			return dao.borrarProducto(Long.parseLong(codigo_producto));
		}
		
		//Actualizar
		
		@RequestMapping("/actualizarproducto")
		public boolean actualizarProducto(String codigo_producto,String nombre_producto, String nit, String precio_compra, String iva_compra, String precio_venta) {
			ProductosDAO dao = new ProductosDAO();
			ProductosVO Producto = new ProductosVO();
			
			Producto.setCodigo_producto(Long.parseLong(codigo_producto));
			Producto.setNombre_producto(nombre_producto);
			Producto.setNit(Long.parseLong(nit));
			Producto.setPrecio_compra(Double.parseDouble(precio_compra));
			Producto.setIva_compra(Double.parseDouble(iva_compra));
			Producto.setPrecio_venta(Double.parseDouble(precio_venta));
			
			return dao.actualizarProducto(Producto);
		}
	}

