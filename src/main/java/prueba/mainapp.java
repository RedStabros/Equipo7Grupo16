package prueba;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import com.DAO.TecnoGamers.Conexion;

public class mainapp {

		
		public static void main(String[] args) {
			Connection con;
			Conexion co = new Conexion();
		    try {
		    	con = co.getConnection();
				PreparedStatement ps = con.prepareStatement("Select * from usuarios ");
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
		             
					System.out.println("Cedula : " + rs.getInt("cedula_usuario") + "\n"
							+ "Email : " + rs.getString("email_usuario")+ "\n"
							+ "Nombre : " + rs.getString("nombre_usuario")+ "\n"		                      
		                    + "Usuario : " + rs.getString("usuario") + "\n"
							+ "Clave : " + rs.getString("clave")+ "\n");
					
				}
						
			} catch (Exception e) {
				System.out.println("No se encontro info ");
			}	 

		}
}

