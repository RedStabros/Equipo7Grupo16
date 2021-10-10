package com.DAO.TecnoGamers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.DAO.TecnoGamers.Conexion;
import com.DTO.TecnoGamers.ProductosVO;

public class ArchivoDAO {
	
	public boolean registrarProducto(ProductosVO producto) {
		boolean creado = false;
		if(!existeProducto(producto.getCodigo_producto())) {
			Conexion conex = new Conexion();
			try {
				Statement consulta = (Statement) conex.getConnection().createStatement();
				String sql = "INSERT INTO productos (codigo_producto, nombre_producto, nit, precio_compra, iva_compra, precio_venta) VALUES ("+
						producto.getCodigo_producto()+",'"+producto.getNombre_producto()+"','"+producto.getNit()+"','"+producto.getPrecio_compra()+"','"+producto.getIva_compra()+"','"+producto.getPrecio_venta()+"');";
				
				((java.sql.Statement) consulta).executeUpdate(sql);
				((java.sql.Statement) consulta).close();
				conex.desconectar();
				creado=true;
				
			} catch (SQLException e) {
				System.out.println("El Producto no se registro");
			}
			}else {
				System.out.println("El Producto ya existe");
			
		}return creado;
	}
	
	public boolean existeProducto(Long codigo_producto) {
		boolean existe = false;
		Conexion conex = new Conexion();
		try {
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM productos WHERE codigo_producto=?");
			consulta.setLong(1,codigo_producto);
			ResultSet res = consulta.executeQuery();
			if (res.next()) {
				existe=true;
			}
			res.close();
			consulta.close();
			conex.desconectar();
			
		} catch (Exception e) {
			System.out.println("No se conecto a la BD");
		}
		return existe;
	}
}
