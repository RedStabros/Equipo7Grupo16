package com.BO.TecnoGamers;

import java.util.ArrayList;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DAO.TecnoGamers.ClienteDAO;
import com.DAO.TecnoGamers.VentaDAO;
import com.DTO.TecnoGamers.ClienteVO;
import com.DTO.TecnoGamers.VentaVO;

@RestController
public class VentasController {
	
	@GetMapping("/contadorventa")
	public Integer contadorVentas() {
		VentaDAO Dao = new VentaDAO();
		return Dao.contadorVentas();
	}
	
	@PostMapping("/registrarventa")
	public void registrarVenta(VentaVO venta) {
		VentaDAO Dao = new VentaDAO();
		Dao.registrarVenta(venta);
	}
	
	@RequestMapping("/buscarventasC")
	public ArrayList<VentaVO> buscarVentaC(String cedula_c){
		VentaDAO dao = new VentaDAO();		
		
		return dao.buscarVentaC(Integer.parseInt(cedula_c));
	}
	
}






/*
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.TecnoGamers.ClienteDAO;
import com.DAO.TecnoGamers.ProductosDAO;
import com.DAO.TecnoGamers.UsuarioDAO;
import com.DAO.TecnoGamers.VentaDAO;
import com.DTO.TecnoGamers.ProductosVO;
import com.DTO.TecnoGamers.UsuarioVO;
import com.DTO.TecnoGamers.VentaVO;

@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class VentasController {
	
	UsuarioVO usuario = new UsuarioVO();
	UsuarioDAO usuariodao = new UsuarioDAO();
	Long cedula_usuario;
	ProductosVO producto = new ProductosVO();
	ProductosDAO productodao = new ProductosDAO();
	Long codigo_producto;
	VentaVO venta = new VentaVO();
	int cantidad_producto;
	Double valor_venta;
	String nombre_producto;
	Double total_venta = 0.0;
	Double subtotal = 0.0;
	Double ivaventa;
	
	List<VentaVO>listaVentas = new ArrayList();
	VentaDAO ventadao = new VentaDAO();
	int numfac=0;
	NumberFormat formatoNumero1;
	String totall;
	ClienteDAO clientedao = new ClienteDAO();
	
	/**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        if (menu.equals("Principal")) {
            request.getRequestDispatcher("Principal.jsp").forward(request, response);
        }
        if (menu.equals("Productos")) {
            switch (accion) {
                case "Listar":
                    List lista = productodao.Listar();
                    request.setAttribute("productos", lista);
                
                    break;
                case "Agregar":
                    String codigoProducto = request.getParameter("txtCodigoProducto");
                    String nombreProducto = request.getParameter("txtDescripcion");
                    String precioProducto = request.getParameter("txtPrecio");
                    String ivaProducto = request.getParameter("txtiva");
                    String cantidadProducto = request.getParameter("cantidad");
                  
                    producto.setCodigo_producto(Long.parseLong(codigoProducto));
                    producto.setNombre_producto(nombreProducto);
                    producto.setPrecio_venta(Double.parseDouble(precioProducto));
                    producto.setIva_compra(Double.parseDouble(ivaProducto));                    
                    producto.setCantidad_producto(Long.parseLong(cantidadProducto));
                    
                    productodao.crearProducto(producto);
                    request.getRequestDispatcher("Controlador?menu=Productos&accion=Listar").forward(request, response);

                    break;
                case "Eliminar":

                    break;
                case "Actualizar":

                    break;
                case "Cargar":

                    Long codigoProducto1 = Long.parseLong(request.getParameter("id"));
                    //producto = productoDAO.buscarProducto(codProducto);
                    System.out.println("" + producto.getNombre_producto());
                    request.setAttribute("producto", producto);
                    break;
            }
            request.getRequestDispatcher("Productos.jsp").forward(request, response);}
        }
	
	/**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     
    public String getServletInfo() {
        return "Short description";
    } // </editor-fold>
	
}*/
