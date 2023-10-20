import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;


public class ConectorDB_mysql {

	private static final String CONTROLADOR = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/dentilax";
	private static final String USUARIO = "root";
	private static final String CLAVE = "1234";
	ResultSet resultado = null;
	Connection conect = null;
	Statement statement;


	static {
		try {
			Class.forName(CONTROLADOR);
		} catch (ClassNotFoundException e) {
			System.out.println("Error al cargar el controlador");
			e.printStackTrace();
		}
	}
	
	public Connection conectar() {
		Connection conexion = null;
		
		try {
			conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
			System.out.println("Conexión OK");
			 statement = conect.createStatement();
			

		} catch (SQLException e) {
			System.out.println("Error en la conexión");
			e.printStackTrace();
		}
		
		return conexion;
	}
	public String consulta_login(String user, String pass) throws SQLException
	{
		String valor_rol=null;
		
		 try {
			 		 
			 conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
             statement = conect.createStatement();
             String query = "SELECT * FROM usuario WHERE DNI_usuario = '" + user + "' AND Contraseña = '" + pass + "'";
             ResultSet resultSet = statement.executeQuery(query);

             if (resultSet.next()) {
                 // Acceso concedido
                 System.out.println("Acceso concedido");
                 valor_rol = resultSet.getString("Rol");
                 
             } else {
                 // Acceso denegado
                 System.out.println("Acceso denegado");
             }
             
             //connection.close();
         } catch (SQLException ex) {
             ex.printStackTrace();
         }
		 return valor_rol;
		
	}
	
	public String consulta_doctor(String dni) throws SQLException{
		
		try {
			conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
			statement = conect.createStatement();
			String query = "SELECT * FROM doctores WHERE DNI_doctor = '" + dni +"'";
            ResultSet resultSet = statement.executeQuery(query);
			
            if (resultSet.next()) {
                // Resultado encontrado
                System.out.println("Resultado encontrado");
                jd_buscar_dr_encontrado ventana = new jd_buscar_dr_encontrado();
                String dniSql = resultSet.getString("DNI_doctor");
                String nombreSql = resultSet.getString("Nombre");
                String apellidosSql = resultSet.getString("Apellidos");
               // System.out.println(dniSql);
                ventana.setTxt_dni(dniSql);
                ventana.setTxt_nombre(nombreSql);
                ventana.setTxt_apellidos(apellidosSql);
                
                ventana.setVisible(true);
                
                
            } else {
                // Acceso denegado
                System.out.println("No se ha encontrado nada");
                JOptionPane.showMessageDialog(null, "Error, no se ha encontrado nada");
            }
			
			
		}
		catch(SQLException ex) {
			
		}
		return dni;
		
	}
	
public String consulta_doctor_ficha(String dni) throws SQLException{
		
		try {
			conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
			statement = conect.createStatement();
			String query = "SELECT * FROM doctores WHERE DNI_doctor = '" + dni +"'";
            ResultSet resultSet = statement.executeQuery(query);
			
            if (resultSet.next()) {
                // Resultado encontrado
                System.out.println("Resultado encontrado");
                jd_buscar_dr_ficha ventana = new jd_buscar_dr_ficha();
                String dniSql = resultSet.getString("DNI_doctor");
                String nombreSql = resultSet.getString("Nombre");
                String apellidosSql = resultSet.getString("Apellidos");
                String salario = resultSet.getString("Salario");
                String especialidad = resultSet.getString("Especialidad");
                String telefono = resultSet.getString("Telefono");
               // System.out.println(dniSql);
                ventana.setTxt_dni(dniSql);
                ventana.setTxt_nombre(nombreSql);
                ventana.setTxt_apellidos(apellidosSql);
                ventana.setTxt_especialidad(especialidad);
                ventana.setTxt_salario(salario);
                ventana.setTxt_telefono(telefono);
                
                ventana.setVisible(true);
                
                
            } else {
                // Acceso denegado
                System.out.println("No se ha encontrado nada");
                JOptionPane.showMessageDialog(null, "Error, no se ha encontrado nada");
            }
			
			
		}
		catch(SQLException ex) {
			
		}
		return dni;
		
	}



public void insertar_doctor(String dni, String apellidos, String nombre, String nacimiento, String telefono, String correo, String especialidad, String direccion,
		String salario, String genero, String estado) throws SQLException{
	
	try {//inserto doctor en doctores
		conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
		statement = conect.createStatement();
		String query = "INSERT INTO doctores (DNI_doctor, Nombre, Apellidos, Nacimiento, Genero, Estado, Telefono, Correo, Direccion, Salario, Especialidad) " +
            "VALUES ('" + dni + "', '" + nombre + "', '" + apellidos + "', '" + nacimiento + "', '" + genero + "', '" + estado + "', '" + telefono + "', '" + correo + "', '" + direccion + "', '" + salario + "', '" + especialidad + "')";

		int fila = statement.executeUpdate(query);
		
		// Verificar si la inserción se realizó con éxito
		if (fila > 0) {
			System.out.println("Inserción exitosa.");
		} else {
			System.out.println("La inserción no tuvo éxito.");
		}
		
	}
	catch(SQLException ex) {
		ex.printStackTrace();
	}
}

public void insertar_dr_usuario(String dni, String estado, String contrasena) {
	
	try {
		conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
		statement = conect.createStatement();
		String query = "INSERT INTO usuario (DNI_usuario, Rol, Contraseña) " +
            "VALUES ('" + dni + "', '" + "Doctor" + "', '" + contrasena + "')";

		int fila = statement.executeUpdate(query);
		
		// Verificar si la inserción se realizó con éxito
		if (fila > 0) {
			System.out.println("Inserción exitosa.");
		} else {
			System.out.println("La inserción no tuvo éxito.");
		}
		
	}
	catch(SQLException ex) {
		ex.printStackTrace();
	}
	
}

public String consulta_especialidades(String especialidades) throws SQLException{
	
	try {
		conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
		statement = conect.createStatement();
		String query = "SELECT * FROM especialidades";
        ResultSet resultSet = statement.executeQuery(query);
		
        if (resultSet.next()) {
            // Resultado encontrado
            System.out.println("Resultado encontrado");
            jd_especialidades ventana = new jd_especialidades();
            String especialidadSql = resultSet.getString("Nombre_especialidad");          
           // System.out.println(dniSql);
            ventana.jl_listaEspecialidad.
            ventana.setVisible(true);
            
            
        } else {
            // Acceso denegado
            System.out.println("No se ha encontrado nada");
            JOptionPane.showMessageDialog(null, "Error, no se ha encontrado nada");
        }
		
		
	}
	catch(SQLException ex) {
		
	}
	return dni;
	
}

	
}