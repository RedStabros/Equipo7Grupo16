package com.BO.TecnoGamers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.DAO.TecnoGamers.ArchivoDAO;
import com.DTO.TecnoGamers.ProductosVO;

@RestController
public class ArchivoController {
	
	@RequestMapping("/cargarArchivo")
	public String cargarArchivo(MultipartFile archivoCSV) {
		File archivoNew;
		String salida = "";
		FileReader fuente = null;
		String linea = "";
		ArrayList<ProductosVO> listado=new ArrayList<ProductosVO>();
		
		try {
			archivoNew = deMultipartAFile(archivoCSV);
			fuente = new FileReader(archivoNew.getName());
			BufferedReader archivo = new BufferedReader(fuente);
			do {
				linea = archivo.readLine();
				if (linea!=null) {
					String tmpLinea = linea.replace("\"","'");
					ArrayList<String> miLista = new ArrayList<String>(Arrays.asList(tmpLinea.split(",")));
					
					ProductosVO producto = new ProductosVO();
					producto.setCodigo_producto(Long.parseLong(miLista.get(0)));
					producto.setNombre_producto(miLista.get(1).replace("'",""));
					producto.setNit(Long.parseLong(miLista.get(2).replace("'","")));
					producto.setPrecio_compra(Double.parseDouble(miLista.get(3).replace("'","")));
					producto.setIva_compra(Double.parseDouble(miLista.get(4).replace("'","")));
					producto.setPrecio_venta(Double.parseDouble(miLista.get(5).replace("'","")));
					
					listado.add(producto);
				}
			}while(linea!=null);
			archivo.close();
			fuente.close();
			
			boolean secreo = false;
			for(ProductosVO registro:listado) {
				ArchivoDAO dao = new ArchivoDAO();
				secreo= dao.registrarProducto(registro);
				
				salida=salida+"**"+secreo+"**"+ registro.getCodigo_producto() + "---" +
						registro.getNombre_producto() + "---"+
						registro.getNit() + "---"+
						registro.getPrecio_compra() + "---"+
						registro.getIva_compra() + "---"+
						registro.getPrecio_venta() + "<br>";
			}
			salida = salida + " RTA: " + (secreo?"OK":"No se inserto a la BD");
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}catch(IOException e2) {
			System.out.println(e2.getMessage());
		}
		return salida;
		}
	
		private File deMultipartAFile(MultipartFile archivo) {
			File convFile = new File(archivo.getOriginalFilename());
			FileOutputStream salida;
			try {
				salida = new FileOutputStream(convFile);
				salida.write(archivo.getBytes());
				salida.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			return convFile;
}
}
