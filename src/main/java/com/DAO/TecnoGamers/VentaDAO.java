package com.DAO.TecnoGamers;

import java.sql.*;
import java.util.ArrayList;

import com.DAO.TecnoGamers.*;
import com.DAO.TecnoGamers.Conexion;
import com.DTO.TecnoGamers.ClienteVO;
import com.DTO.TecnoGamers.VentaVO;

public class VentaDAO {
	
	
	public int contadorVentas() {
		// lista que contendra el o los usuarios obtenidos
		int contador = 0;

		// instancia de la conexión
		Conexion conex = new Conexion();

		try {
			// prepare la sentencia en la base de datos
			//PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT `AUTO_INCREMENT` " + "FROM  INFORMATION_SCHEMA.TABLES "
			//				+ "WHERE TABLE_SCHEMA = 'tecno_tienda' " + "AND   TABLE_NAME   = 'ventas'");
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT MAX(codigo_venta) FROM ventas");
			
			// ejecute la sentencia
			ResultSet res = consulta.executeQuery();

			// cree un objeto para cada encontrado en la base de datos basado en la clase
			// entidad con los datos encontrados
			while (res.next()) {
				contador = (res.getInt("MAX(codigo_venta)"));
			}

			// cerrar resultado, sentencia y conexión
			res.close();
			consulta.close();
			conex.desconectar();

		} catch (SQLException e) {
			// si hay un error en el sql mostrarlo
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo consultar contador");
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
		} catch (Exception e) {
			// si hay cualquier otro error mostrarlo
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo consultar contador");
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}

		return contador;
	
	}
	
	public void registrarVenta(VentaVO venta) {
		// llama y crea una instancia de la clase encargada de hacer la conexión
		Conexion conex = new Conexion();

		try {
			// sentencia que se ejecutara en la base de datos
			Statement estatuto = conex.getConnection().createStatement();

			// String que contiene la sentencia insert a ejecutar
			String sentencia = "INSERT INTO ventas VALUES(" + venta.getCodigo_venta() + "," + venta.getCedula_c()
			 		+ "," + venta.getCedula_usuario() + "," + venta.getIvaventa() + "," + venta.getValor_venta() + ","
					+ venta.getTotal_venta() + "" + ");";

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
			System.out.println("No se pudo insertar la venta");
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
		} catch (Exception e) {
			// si hay cualquier otro error mostrarlo
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo insertar la venta2");
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}

	}
	
	//buscar ventas cliente
		public ArrayList<VentaVO>buscarVentaC(int cedula_c){
			ArrayList<VentaVO> misVentas = new ArrayList<VentaVO>();
			Conexion conex = new Conexion();
			try {
				PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM ventas WHERE cedula_c=?");			
				consulta.setInt(1, cedula_c);
				ResultSet res = consulta.executeQuery();
				while(res.next()) {
					VentaVO Venta = new VentaVO();
					Venta.setCodigo_venta(res.getInt("codigo_venta"));
					Venta.setCedula_c(res.getInt("cedula_c"));
					Venta.setCedula_usuario(res.getInt("cedula_usuario"));
					Venta.setIvaventa(res.getDouble("ivaventa"));
					Venta.setValor_venta(res.getDouble("valor_venta"));
					Venta.setTotal_venta(res.getDouble("total_venta"));		
					misVentas.add(Venta);
				}
				res.close();
				consulta.close();
				conex.desconectar();
			} catch (Exception e) {
				System.out.println("No se pudo conectar mierda");
			}
			return misVentas;
		}
	
}



/*
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.DTO.TecnoGamers.VentaVO;

public class VentaDAO {

	Connection con;
	Conexion cn = new Conexion();
	PreparedStatement ps;
	ResultSet rs;
	
	
	public String GenerarSerieFactura() {
		String numeroserie="";
		String sql = "SELECT max(codigo_venta) FROM ventas";
		con = cn.getConnection();
		try {
			
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				numeroserie=rs.getString(1);
				System.err.println("numfac"+numeroserie);
			}
			
			
		} catch (SQLException ex) {
			Logger.getLogger(VentaDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		return numeroserie;
	}
	
	
	public void RegistrarVenta(VentaVO venta) {
		String consulta = "INSERT INTO ventas (codigo_venta,cedula_c,cedula_usuario,ivaventa,valor_venta,total_venta) VALUES(?,?,?,?,?,?)";
		con = cn.getConnection();
		try {
			ps = con.prepareStatement(consulta);
			ps.setLong(1, venta.getCodigo_venta());
			ps.setLong(2, venta.getCedula_c());
			ps.setLong(3, venta.getCedula_usuario());
			ps.setDouble(4, venta.getIvaventa());
			ps.setDouble(5, venta.getValor_venta());
			ps.setDouble(6, venta.getTotal_venta());
			ps.executeUpdate();	
			
			
		} catch (SQLException ex) {
			Logger.getLogger(VentaDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	
	public void GuardarDetalleVenta(VentaVO venta) {
		String consulta = "INSERT INTO detalle_ventas (codigo_detalle_venta,cantidad_producto,codigo_producto,codigo_venta,valor_total,valor_venta,valoriva) VALUES(?,?,?,?,?,?,?)";
		con = cn.getConnection();
		try {
			ps = con.prepareStatement(consulta);
			ps.setLong(1, venta.getCodigo_detalle_venta());
			ps.setLong(2, venta.getCantidad_producto());
			ps.setLong(3, venta.getCodigo_producto());
			ps.setLong(4, venta.getCodigo_venta());
			ps.setDouble(5, venta.getTotal_venta());
			ps.setDouble(6, venta.getValor_venta());
			ps.setDouble(7, venta.getIvaventa());
			
			ps.executeUpdate();
			
		} catch (SQLException ex) {
			Logger.getLogger(VentaDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	
	public int ObtenerMaximoVentas() {
		
		int idVenta=0;
		String consulta = "SELECT MAX(codigo_venta) FROM ventas";
		con = cn.getConnection();
		try {
			ps = con.prepareStatement(consulta);
			rs = ps.executeQuery();
			while (rs.next()) {
				idVenta=(int) rs.getLong(1);
				System.out.println("max"+idVenta);
			}
			
		} catch (SQLException ex) {
            Logger.getLogger(VentaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
		return idVenta;
	}
	
}*/
