package com.BO.TecnoGamers;

import java.util.ArrayList;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DAO.TecnoGamers.DetalleVentaDAO;
import com.DTO.TecnoGamers.DetalleVentaVO;


@RestController
public class DetalleVentaController {
	
	
	@PostMapping("/registrardetalleventa")
	public void registrarDetalleVenta(DetalleVentaVO venta) {
		DetalleVentaDAO Dao = new DetalleVentaDAO();
		Dao.registrarDetalleVenta(venta);
	}
	
}