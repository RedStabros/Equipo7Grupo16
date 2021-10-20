package com.DAO.TecnoGamers;


import java.sql.*;
import java.util.ArrayList;

import com.DAO.TecnoGamers.Conexion;
import com.DTO.TecnoGamers.DetalleVentaVO;


public class DetalleVentaDAO {

	
	public void registrarDetalleVenta(DetalleVentaVO detalleventa) {
		// llama y crea una instancia de la clase encargada de hacer la conexión
		Conexion conex = new Conexion();

		try {
			// sentencia que se ejecutara en la base de datos
			Statement estatuto = conex.getConnection().createStatement();

			// String que contiene la sentencia insert a ejecutar
			String sentencia = "INSERT INTO detalle_ventas VALUES(" + detalleventa.getCodigo_detalle_venta() + ","
					+ detalleventa.getCantidad_producto() + "," + detalleventa.getCodigo_producto() + ","
					+ detalleventa.getCodigo_venta() + "," + detalleventa.getValor_total() + ","
					+ detalleventa.getValor_venta() + "," + detalleventa.getValoriva() + "" + ");";

			// se ejecuta la sentencia en la base de datos
			estatuto.executeUpdate(sentencia);
			// impresión en consola para verificación
			System.out.println("Registrado " + sentencia);
			// cerrando la sentencia y la conexión
			estatuto.close();
			conex.desconectar();

		} catch (SQLException e) {
			// si hay un error en el sql mostrarlo
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo insertar la detalleventa");
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
		} catch (Exception e) {
			// si hay cualquier otro error mostrarlo
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo insertar la detalleventa2");
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}

	}
	
}
