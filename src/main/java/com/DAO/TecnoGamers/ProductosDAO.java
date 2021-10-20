package com.DAO.TecnoGamers;

import java.beans.*;
import java.sql.*;
import java.sql.Statement;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.DTO.TecnoGamers.*;

public class ProductosDAO {

	//lista
	
		public ArrayList<ProductosVO> listaDeProductos(){
			ArrayList<ProductosVO> misProductos = new ArrayList<ProductosVO>();
			Conexion conex = new Conexion();
			try {
				PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM productos");
				ResultSet res = consulta.executeQuery();
				
				while(res.next()) {
					ProductosVO Producto = new ProductosVO();
					Producto.setCodigo_producto(res.getLong("codigo_producto"));
					Producto.setNombre_producto(res.getString("nombre_producto"));
					Producto.setNit(res.getLong("nit"));
					Producto.setPrecio_compra(res.getDouble("precio_compra"));
					Producto.setIva_compra(res.getDouble("iva_compra"));
					Producto.setPrecio_venta(res.getDouble("precio_venta"));
					misProductos.add(Producto);
				}
				res.close();
				consulta.close();
				conex.desconectar();
				
			} catch (Exception e) {
				System.out.println("No se pudo conectar");
			}
			return misProductos;
		}
		
		//buscar
		
		public ArrayList<ProductosVO> buscarProducto(long codigo_producto){
			ArrayList<ProductosVO> misProductos = new ArrayList<ProductosVO>();
			Conexion conex = new Conexion();
			try {
				PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM productos WHERE codigo_producto=?");
				
				consulta.setLong(1,codigo_producto);
				ResultSet res = consulta.executeQuery();
				
				while(res.next()) {
					ProductosVO Producto = new ProductosVO();
					
					Producto.setCodigo_producto(res.getLong("codigo_producto"));
					Producto.setNombre_producto(res.getString("nombre_producto"));
					Producto.setNit(res.getLong("nit"));
					Producto.setPrecio_compra(res.getDouble("precio_compra"));
					Producto.setIva_compra(res.getDouble("iva_compra"));
					Producto.setPrecio_venta(res.getDouble("precio_venta"));
					misProductos.add(Producto);
				}
				res.close();
				consulta.close();
				conex.desconectar();
			} catch (Exception e) {
				System.out.println("No se pudo conectar");
			}
			return misProductos;
		}
		
		//verificar que existe
		
		public boolean existeProducto(Long codigo_producto) {
			boolean existe = false;
			Conexion conex = new Conexion();
			try {
				PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM productos WHERE codigo_producto=?");
				
				consulta.setLong(1,codigo_producto);
				ResultSet res = consulta.executeQuery();
				if(res.next()) {
					existe = true;
				}
				res.close();
				consulta.close();
				conex.desconectar();
				
			} catch (Exception e) {
				System.out.println("No se pudo verificar si existe el producto");
			}
			return existe;
		}
		
		//crear
		
		public boolean crearProducto(ProductosVO Producto) {
			boolean swCrear = false;
			if(!existeProducto(Producto.getCodigo_producto())) {
				Conexion conex = new Conexion();
				try {
					Statement consulta = (Statement) conex.getConnection().createStatement();
					String SQL ="INSERT INTO productos (codigo_producto, nombre_producto, nit, precio_compra, iva_compra, precio_venta) VALUES ("+
							Producto.getCodigo_producto()+",'"+Producto.getNombre_producto()+"','"+Producto.getNit()+"','"+Producto.getPrecio_compra()+"','"+Producto.getIva_compra()+"','"+Producto.getPrecio_venta()+"');";
					((java.sql.Statement) consulta).executeUpdate(SQL);
					((java.sql.Statement) consulta).close();
					
					conex.desconectar();
					swCrear = true;
					
				} catch (Exception e) {
					System.out.println("No se pudo crear el producto");
				}
			}else {
				System.out.println("El producto ya existe");
			}
			return swCrear;
		}
		
		//borrar
		
		public boolean borrarProducto(Long codigo_producto) {
			boolean swCrear = false;
			if(existeProducto(codigo_producto)) {
				Conexion conex = new Conexion();
				try {
					Statement consulta = (Statement) conex.getConnection().createStatement();
					String SQL = "DELETE FROM productos WHERE codigo_producto="+codigo_producto;
									
					consulta.executeUpdate(SQL);
					consulta.close();
					
					conex.desconectar();
					swCrear = true;
					
				} catch (Exception e) {
					System.out.println("No se pudo borrar el producto");
				}
			}else {
				System.out.println("El producto no existe");
			}
			return swCrear;
		}
		
		//actualizar
		
		public boolean actualizarProducto(ProductosVO Producto) {
			boolean swActualizar = false;
			if(existeProducto(Producto.getCodigo_producto())) {
				Conexion conex = new Conexion();
				try {
					Statement consulta = (Statement) conex.getConnection().createStatement();
					String SQL ="UPDATE productos SET nombre_producto='"+Producto.getNombre_producto()+"',"+"nit='"+Producto.getNit()+"',"+"precio_compra='"+Producto.getPrecio_compra()+"',"+"iva_compra='"+Producto.getIva_compra()+"',"+
					"precio_venta='"+Producto.getPrecio_venta()+"' WHERE codigo_producto="+Producto.getCodigo_producto();
					((java.sql.Statement) consulta).executeUpdate(SQL);
					((java.sql.Statement) consulta).close();
					
					conex.desconectar();
					swActualizar = true;
					
				} catch (Exception e) {
					System.out.println("No se pudo actualizar el producto");
				}
			}else {
				System.out.println("El producto no existe");
			}
			return swActualizar;
		}
			
	//////////////////////////////////////////
		
		public List Listar() {
		     
	        List<ProductosVO> lista = new ArrayList();
	        Conexion conex = new Conexion();
	        
	        try {
	        	Statement consulta = (Statement) conex.getConnection().createStatement();
	        	ResultSet res = consulta.executeQuery(null);
	            while (res.next()) {
	                ProductosVO producto = new ProductosVO();
	                producto.setCodigo_producto(res.getLong("id"));
	                producto.setNombre_producto(res.getString("nombreproducto")); 
	                producto.setPrecio_venta(res.getDouble("precio"));
	                producto.setIva_compra(res.getDouble("iva"));
	                lista.add(producto);

	            }
	        } catch (SQLException ex) {
	            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        return lista;

	    }
	
}
