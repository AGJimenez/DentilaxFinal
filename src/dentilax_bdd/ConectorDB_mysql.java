package dentilax_bdd;
import java.awt.event.ItemEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import dialogos_consultas.jd_historial_cita;
import dialogos_consultas.jd_nueva_consulta;


public class ConectorDB_mysql {

	private static final String CONTROLADOR = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/dentilax?useSSL=false";
	private static final String USUARIO = "root";
	String tablaNombre;
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
	
public String consulta_paciente_editar(String dni) throws SQLException{
		
		try {
			conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
			statement = conect.createStatement();
			String query = "SELECT * FROM pacientes WHERE DNI_paciente = '" + dni +"'";
            ResultSet resultSet = statement.executeQuery(query);
			
            if (resultSet.next()) {
                // Resultado encontrado
                System.out.println("Resultado encontrado");
                String dniSql = resultSet.getString("DNI_paciente");
                String nombreSql = resultSet.getString("Nombre");
                String apellidosSql = resultSet.getString("Apellidos");
                
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

public String consulta_paciente_cargar(String dni) throws SQLException{
	
	try {
		conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
		statement = conect.createStatement();
		String query = "SELECT * FROM pacientes WHERE DNI_paciente = '" + dni +"'";
        ResultSet resultSet = statement.executeQuery(query);
		
        if (resultSet.next()) {
            // Resultado encontrado
            System.out.println("Resultado encontrado");
            dialogos_pacientes.jd_pacientes_editar ventana = new dialogos_pacientes.jd_pacientes_editar();
            String dniSql = resultSet.getString("DNI_paciente");
            String apellidosSql = resultSet.getString("Apellidos");
            String nombreSql = resultSet.getString("Nombre");
            String nacimiento = resultSet.getString("Nacimiento");
            String seguro = resultSet.getString("Seguro");
            String estado = resultSet.getString("Estado");
            String genero = resultSet.getString("Genero");
            String observaciones = resultSet.getString("Observaciones");
            String telefono = resultSet.getString("Telefono");
            String correo = resultSet.getString("Correo");
            String direccion = resultSet.getString("Direccion");
           // System.out.println(dniSql);
            ventana.setTxt_dni(dniSql);
            ventana.setTxt_apellidos(apellidosSql);
            ventana.setTxt_nombre(nombreSql);
            ventana.setTxt_nacimiento(nacimiento);
            ventana.setTxt_seguro(seguro);
            //ventana.setTxt_genero(genero);
            ventana.setTxt_observaciones(observaciones);
            ventana.setTxt_telefono(telefono);
            ventana.setTxt_correo(correo);
            ventana.setTxt_direccion(direccion);
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
	
	public String consulta_doctor(String dni) throws SQLException{
		
		try {
			conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
			statement = conect.createStatement();
			String query = "SELECT * FROM doctores WHERE DNI_doctor = '" + dni +"'";
            ResultSet resultSet = statement.executeQuery(query);
			
            if (resultSet.next()) {
                // Resultado encontrado
                System.out.println("Resultado encontrado");
                dialogos_doctores.jd_buscar_dr_encontrado ventana = new dialogos_doctores.jd_buscar_dr_encontrado();
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
	
public String consulta_paciente(String dni) throws SQLException{
		
		try {
			conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
			statement = conect.createStatement();
			String query = "SELECT * FROM pacientes WHERE DNI_paciente = '" + dni +"'";
            ResultSet resultSet = statement.executeQuery(query);
			
            if (resultSet.next()) {
                // Resultado encontrado
                System.out.println("Resultado encontrado");
                dialogos_pacientes.jd_buscar_paciente_encontrado ventana = new dialogos_pacientes.jd_buscar_paciente_encontrado();
                String dniSql = resultSet.getString("DNI_paciente");
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

public String consulta_buscar_cita(String dni, String fecha) throws SQLException{
	
	try {
		conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
		statement = conect.createStatement();
		String query =  "SELECT citas.ID_cita, citas.Fecha, doctores.Nombre, pacientes.Nombre FROM citas JOIN doctores ON citas.DNI_doctor = doctores.DNI_doctor JOIN pacientes ON citas.DNI_paciente = pacientes.DNI_paciente WHERE citas.DNI_paciente = '" + dni +"' AND citas.Fecha = '"+ fecha+ "'";
        ResultSet resultSet = statement.executeQuery(query);
		
        if (resultSet.next()) {
            // Resultado encontrado
            System.out.println("Resultado encontrado");
            dialogos_consultas.jd_buscar_consulta_encontrada ventana = new dialogos_consultas.jd_buscar_consulta_encontrada();
            String IDSql = resultSet.getString("citas.ID_cita");
            String FechaSql = resultSet.getString("citas.Fecha");
            String DoctorSql = resultSet.getString("doctores.Nombre");
            String PacienteSql = resultSet.getString("pacientes.Nombre");
            ventana.setLbl_id(IDSql);
            ventana.setTxt_fecha(FechaSql);
            ventana.setTxt_doctor(DoctorSql);
            ventana.setTxt_paciente(PacienteSql);
            
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

public String consulta_paciente_eliminar(String dni) throws SQLException{
	
	try {
		conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
		statement = conect.createStatement();
		String query = "SELECT * FROM pacientes WHERE DNI_paciente = '" + dni +"'";
        ResultSet resultSet = statement.executeQuery(query);
		
        if (resultSet.next()) {
            // Resultado encontrado
            System.out.println("Resultado encontrado");
            dialogos_pacientes.jd_buscar_paciente_baja_encontrado ventana = new dialogos_pacientes.jd_buscar_paciente_baja_encontrado();
            String dniSql = resultSet.getString("DNI_paciente");
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

public String consulta_doctor_eliminar(String dni) throws SQLException{
	
	try {
		conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
		statement = conect.createStatement();
		String query = "SELECT * FROM doctores WHERE DNI_doctor = '" + dni +"'";
        ResultSet resultSet = statement.executeQuery(query);
		
        if (resultSet.next()) {
            // Resultado encontrado
            System.out.println("Resultado encontrado");
            dialogos_doctores.jd_buscar_doctor_baja_encontrado ventana = new dialogos_doctores.jd_buscar_doctor_baja_encontrado();
            String dniSql = resultSet.getString("DNI_doctor");
            String nombreSql = resultSet.getString("Nombre");
            String apellidosSql = resultSet.getString("Apellidos");
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
	
	public String consulta_doctor_editar(String dni) throws SQLException{
		
		try {
			conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
			statement = conect.createStatement();
			String query = "SELECT * FROM doctores WHERE DNI_doctor = '" + dni +"'";
            ResultSet resultSet = statement.executeQuery(query);
			
            if (resultSet.next()) {
                // Resultado encontrado
                System.out.println("Resultado encontrado");
                String dniSql = resultSet.getString("DNI_doctor");
                String nombreSql = resultSet.getString("Nombre");
                String apellidosSql = resultSet.getString("Apellidos");
                               
                
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
	
	public List<jd_historial_cita> obtenerInfoCitas() {
	    List<jd_historial_cita> historiales = new ArrayList<>();

	    try {
	        conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
	        statement = conect.createStatement();
	        String query = "SELECT Fecha, Especialidad, DNI_paciente FROM citas";
	        ResultSet resultSet = statement.executeQuery(query);

	        while (resultSet.next()) {
	            String fecha = resultSet.getString("Fecha");
	            String especialidad = resultSet.getString("Especialidad");
	            String dniPaciente = resultSet.getString("DNI_paciente");

	           // jd_historial_cita historial = new jd_historial_cita();
	          //  historial.setFecha(fecha);
	          //  historial.setEspecialidad(especialidad);
	          //  historial.setDNI_paciente(dniPaciente);

	        //    historiales.add(historial);
	        }

	    } catch (SQLException ex) {
	        ex.printStackTrace();  // 
	    } finally {
	        // Aqui vamos a cerrar recursos (statement y conexión) en el bloque finally
	        try {
	            if (statement != null) {
	                statement.close();
	            }
	            if (conect != null) {
	                conect.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return historiales;
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
                dialogos_doctores.jd_buscar_dr_ficha ventana = new dialogos_doctores.jd_buscar_dr_ficha();
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

public String consulta_paciente_ficha(String dni) throws SQLException{
	
	try {
		conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
		statement = conect.createStatement();
		String query = "SELECT * FROM pacientes WHERE DNI_paciente = '" + dni +"'";
        ResultSet resultSet = statement.executeQuery(query);
		
        if (resultSet.next()) {
            // Resultado encontrado
            System.out.println("Resultado encontrado");
            dialogos_pacientes.jd_buscar_paciente_ficha ventana = new dialogos_pacientes.jd_buscar_paciente_ficha();
            String dniSql = resultSet.getString("DNI_paciente");
            String nombreSql = resultSet.getString("Nombre");
            String apellidosSql = resultSet.getString("Apellidos");
            String estado = resultSet.getString("Estado");
            String genero = resultSet.getString("Genero");
            String seguro = resultSet.getString("Seguro");
            String telefono = resultSet.getString("Telefono");
           // System.out.println(dniSql);
            ventana.setTxt_dni(dniSql);
            ventana.setTxt_nombre(nombreSql);
            ventana.setTxt_apellidos(apellidosSql);
            ventana.setTxt_estado(estado);
            ventana.setTxt_genero(genero);
            ventana.setTxt_seguro(seguro);
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

public List<String> cargarEspecialidades() {
    List<String> especialidades = new ArrayList<>();

    try (Connection connection = DriverManager.getConnection(URL, USUARIO, CLAVE)) {
        String sql = "SELECT Nombre FROM especialidad";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    especialidades.add(resultSet.getString("Nombre"));
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return especialidades;
}

public String consulta_doctor_cargar(String dni) throws SQLException{
	
	try {
		conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
		statement = conect.createStatement();
		String query = "SELECT * FROM doctores WHERE DNI_doctor = '" + dni +"'";
        ResultSet resultSet = statement.executeQuery(query);
		
        if (resultSet.next()) {
            // Resultado encontrado
            System.out.println("Resultado encontrado");
            dialogos_doctores.jd_doctores_editar ventana = new dialogos_doctores.jd_doctores_editar();
            String dniSql = resultSet.getString("DNI_doctor");
            String nombreSql = resultSet.getString("Nombre");
            String apellidosSql = resultSet.getString("Apellidos");
            String salario = resultSet.getString("Salario");
            String especialidad = resultSet.getString("Especialidad");
            String telefono = resultSet.getString("Telefono");
            String nacimiento = resultSet.getString("Nacimiento");
            String correo = resultSet.getString("Correo");
            String direccion = resultSet.getString("Direccion");
            String genero = resultSet.getString("Genero");
           // System.out.println(dniSql);
            ventana.setTxt_dni(dniSql);
            ventana.setTxt_nombre(nombreSql);
            ventana.setTxt_apellidos(apellidosSql);
            ventana.setTxt_especialidad(especialidad);
            ventana.setTxt_salario(salario);
            ventana.setTxt_telefono(telefono);
            ventana.setTxt_nacimiento(nacimiento);
            ventana.setTxt_correo(correo);
           // ventana.setTxt_genero(genero);
            ventana.setTxt_direccion(direccion);
            
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
			JOptionPane.showMessageDialog(null, "Doctor añadido con éxito");
		} else {
			System.out.println("La inserción no tuvo éxito.");
			
		}
		
	}
	catch(SQLException ex) {
		JOptionPane.showMessageDialog(null, "Error en la inserción de doctor, comprueba los campos.");
		ex.printStackTrace();
	}
}

public void baja_doctor(String dni) throws SQLException {

    try {
        // Conectar con la base de datos
        conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
        statement = conect.createStatement();

        // Crear la consulta
        String query = "UPDATE doctores " +
                "SET Estado = '" + "Baja" + "'" +
                "WHERE DNI_doctor = '" + dni + "'";

        // Ejecutar la consulta
        int fila = statement.executeUpdate(query);

        // Verificar si la actualización se realizó con éxito
        if (fila > 0) {
            System.out.println("Baja con exito.");
            JOptionPane.showMessageDialog(null, "Baja dada con éxito");
        } else {
            System.out.println("La baja no tuvo éxito.");
        }

    } catch (SQLException ex) {
    	JOptionPane.showMessageDialog(null, "Error al dar de baja, comprueba los campos.");
        ex.printStackTrace();
    }
}

public void insertar_paciente(String dni, String apellidos, String nombre, String nacimiento, String telefono, String correo, String direccion, String seguro,
		String observaciones, String genero, String estado) throws SQLException{
	
	try {//inserto paciente 
		conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
		statement = conect.createStatement();
		String query = "INSERT INTO pacientes (DNI_paciente, Nombre, Apellidos, Nacimiento, Genero, Estado, Telefono, Correo, Direccion, Seguro, Observaciones) " +
            "VALUES ('" + dni + "', '" + nombre + "', '" + apellidos + "', '" + nacimiento + "', '" + genero + "', '" + estado + "', '" + telefono + "', '" + correo + "', '" + direccion + "', '" + seguro + "', '" + observaciones + "')";

		int fila = statement.executeUpdate(query);
		
		// Verificar si la inserción se realizó con éxito
		if (fila > 0) {
			System.out.println("Inserción exitosa.");
			JOptionPane.showMessageDialog(null, "Paciente añadido con éxito");
		} else {
			System.out.println("La inserción no tuvo éxito.");
			
		}
		
	}
	catch(SQLException ex) {
		JOptionPane.showMessageDialog(null, "Error en la inserción de paciente, comprueba los campos.");
		ex.printStackTrace();
	}
}

public void editar_paciente(String dni, String apellidos, String nombre, String nacimiento, String telefono, String correo, String seguro, String direccion,
		String observacion, String genero) throws SQLException {

    try {
        // Conectar con la base de datos
        conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
        statement = conect.createStatement();

        // Crear la consulta
        String query = "UPDATE pacientes " +
                "SET Apellidos = '" + apellidos + "', " +
                "Observacion = '" + observacion + "', " +
                "Nacimiento = '" + nacimiento + "', " +
                "Genero = '" + genero + "', " +
                "Nombre = '" + nombre + "', " +
                "Correo = '" + correo + "', " +
                "Direccion = '" + direccion + "', " +
                "Telefono = '" + telefono + "', " +
                "Seguro = '" + seguro + "'" +
                "WHERE DNI_paciente = '" + dni + "'";

        // Ejecutar la consulta
        int fila = statement.executeUpdate(query);

        // Verificar si la actualización se realizó con éxito
        if (fila > 0) {
            System.out.println("Actualización exitosa.");
            JOptionPane.showMessageDialog(null, "Actualización con éxito");
        } else {
            System.out.println("La actualización no tuvo éxito.");
        }

    } catch (SQLException ex) {
    	JOptionPane.showMessageDialog(null, "Error al actualizar, comprueba los campos.");
        ex.printStackTrace();
    }
}

public void baja_paciente(String dni) throws SQLException {

    try {
        // Conectar con la base de datos
        conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
        statement = conect.createStatement();

        // Crear la consulta
        String query = "UPDATE pacientes " +
                "SET Estado = '" + "baja" + "'" +
                "WHERE DNI_paciente = '" + dni + "'";

        // Ejecutar la consulta
        int fila = statement.executeUpdate(query);

        // Verificar si la actualización se realizó con éxito
        if (fila > 0) {
            System.out.println("Baja con exito.");
            JOptionPane.showMessageDialog(null, "Baja dada con éxito");
        } else {
            System.out.println("La baja no tuvo éxito.");
        }

    } catch (SQLException ex) {
    	JOptionPane.showMessageDialog(null, "Error al dar de baja, comprueba los campos.");
        ex.printStackTrace();
    }
}


public void editar_doctor(String dni, String apellidos, String nombre, String nacimiento, String telefono, String correo, String especialidad, String direccion,
		String salario, String genero) throws SQLException {

    try {
        // Conectar con la base de datos
        conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
        statement = conect.createStatement();

        // Crear la consulta
        String query = "UPDATE doctores " +
                "SET Apellidos = '" + apellidos + "', " +
                "Salario = '" + salario + "', " +
                "Nacimiento = '" + nacimiento + "', " +
                "Genero = '" + genero + "', " +
                "Nombre = '" + nombre + "', " +
                "Correo = '" + correo + "', " +
                "Direccion = '" + direccion + "', " +
                "Telefono = '" + telefono + "', " +
                "Especialidad = '" + especialidad + "'" +
                "WHERE DNI_doctor = '" + dni + "'";

        // Ejecutar la consulta
        int fila = statement.executeUpdate(query);

        // Verificar si la actualización se realizó con éxito
        if (fila > 0) {
            System.out.println("Actualización exitosa.");
            JOptionPane.showMessageDialog(null, "Actualización con éxito");
        } else {
            System.out.println("La actualización no tuvo éxito.");
        }

    } catch (SQLException ex) {
    	JOptionPane.showMessageDialog(null, "Error al actualizar, comprueba los campos.");
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

public void insertar_especialidad(String especialidad) {
	
	try {
		conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
		statement = conect.createStatement();
		String query = "INSERT INTO especialidad (Nombre) " +
            "VALUES ('" + especialidad + "')";

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

public void eliminar_especialidad(String especialidad) throws SQLException{
	String query = "DELETE FROM especialidad WHERE Nombre = ?";
	
	try (Connection conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
		PreparedStatement pstmt = conect.prepareStatement(query)){
		pstmt.setString(1, especialidad);
		pstmt.executeUpdate();
		System.out.println("Especialidad eliminada");
	}
	catch(SQLException ex) {
		System.out.println("Error en eliminar la especialidad");
	}
}

public String consulta_cita_eliminar_encontrar(String id) throws SQLException{

	
	try {
		conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
		statement = conect.createStatement();
		String query = "SELECT citas.ID_cita, citas.Fecha, doctores.Nombre, pacientes.Nombre FROM citas JOIN doctores ON citas.DNI_doctor = doctores.DNI_doctor JOIN pacientes ON citas.DNI_paciente = pacientes.DNI_paciente WHERE citas.ID_cita = '" + id +"'";
		ResultSet resultSet = statement.executeQuery(query);
		
        if (resultSet.next()) {
            // Resultado encontrado
            System.out.println("Resultado encontrado");
            dialogos_consultas.jd_buscar_consulta_eliminar_encontrada ventana = new dialogos_consultas.jd_buscar_consulta_eliminar_encontrada();
            String ID = resultSet.getString("citas.ID_cita");
            String FechaSql = resultSet.getString("citas.Fecha");
            String DoctorSql = resultSet.getString("doctores.Nombre");
            String PacienteSql = resultSet.getString("pacientes.Nombre");
            ventana.setTxt_fecha(FechaSql);
            ventana.setTxt_doctor(DoctorSql);
            ventana.setTxt_paciente(PacienteSql);
            ventana.setLbl_id(ID);
            
            ventana.setVisible(true);
            
            
            
        } else {
            // Acceso denegado
            System.out.println("No se ha encontrado nada");
            JOptionPane.showMessageDialog(null, "Error, no se ha encontrado nada");
        }
		
		
	}
	catch(SQLException ex) {
		
	}
	return id;
	
}

public void consulta_eliminar_cita(String id) throws SQLException{
	String query = "DELETE FROM citas WHERE ID_cita = ?";
	
	try (Connection conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
		PreparedStatement pstmt = conect.prepareStatement(query)){
		pstmt.setString(1, id);
		pstmt.executeUpdate();
		System.out.println("Cita eliminada");
	}
	catch(SQLException ex) {
		System.out.println("Error en eliminar la cita");
	}
}

public String consulta_eliminar_ficha(String ID) throws SQLException{
	
	try {
		conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
		statement = conect.createStatement();
		String query = "SELECT pacientes.Nombre, pacientes.Apellidos, doctores.Nombre, citas.Especialidad, citas.Fecha, citas.Hora, citas.Observaciones FROM citas JOIN pacientes ON pacientes.DNI_paciente = citas.DNI_paciente JOIN doctores ON doctores.DNI_doctor = citas.DNI_doctor WHERE ID_cita = '" + ID +"'";
        ResultSet resultSet = statement.executeQuery(query);
		
        if (resultSet.next()) {
            // Resultado encontrado
            System.out.println("Resultado encontrado");
            dialogos_consultas.jd_buscar_consulta_eliminar_ficha ventana = new dialogos_consultas.jd_buscar_consulta_eliminar_ficha();
            String NombreSql = resultSet.getString("pacientes.Nombre");
            String ApellidosSql = resultSet.getString("pacientes.Apellidos");
            String DoctorSql = resultSet.getString("doctores.Nombre");
            String EspecialidadSql = resultSet.getString("citas.Especialidad");
            String FechaSql = resultSet.getString("citas.Fecha");
            String HoraSql = resultSet.getString("citas.Hora");
            String ObservacionesSql = resultSet.getString("citas.Observaciones");
           // System.out.println(dniSql);
            ventana.setTxt_nombre(NombreSql);
            ventana.setTxt_apellidos(ApellidosSql);
            ventana.setTxt_doctor(DoctorSql);
            ventana.setTxt_especialidad(EspecialidadSql);
            ventana.setTxt_fecha(FechaSql);
            ventana.setTxt_hora(HoraSql);
            ventana.setTxt_observaciones(ObservacionesSql);
            
            ventana.setVisible(true);
            
            
        } else {
            // Acceso denegado
            System.out.println("No se ha encontrado nada");
            JOptionPane.showMessageDialog(null, "Error, no se ha encontrado nada");
        }
		
		
	}
	catch(SQLException ex) {
		
	}
	return ID;
	
}

public String consulta_ver_ficha(String ID) throws SQLException{
	
	try {
		conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
		statement = conect.createStatement();
		String query = "SELECT pacientes.Nombre, pacientes.Apellidos, doctores.Nombre, citas.Especialidad, citas.Fecha, citas.Hora, citas.Observaciones FROM citas JOIN pacientes ON pacientes.DNI_paciente = citas.DNI_paciente JOIN doctores ON doctores.DNI_doctor = citas.DNI_doctor WHERE ID_cita = '" + ID +"'";
        ResultSet resultSet = statement.executeQuery(query);
		
        if (resultSet.next()) {
            // Resultado encontrado
            System.out.println("Resultado encontrado");
            dialogos_consultas.jd_buscar_consulta_ver_ficha ventana = new dialogos_consultas.jd_buscar_consulta_ver_ficha();
            String NombreSql = resultSet.getString("pacientes.Nombre");
            String ApellidosSql = resultSet.getString("pacientes.Apellidos");
            String DoctorSql = resultSet.getString("doctores.Nombre");
            String EspecialidadSql = resultSet.getString("citas.Especialidad");
            String FechaSql = resultSet.getString("citas.Fecha");
            String HoraSql = resultSet.getString("citas.Hora");
            String ObservacionesSql = resultSet.getString("citas.Observaciones");
           // System.out.println(dniSql);
            ventana.setTxt_nombre(NombreSql);
            ventana.setTxt_apellidos(ApellidosSql);
            ventana.setTxt_doctor(DoctorSql);
            ventana.setTxt_especialidad(EspecialidadSql);
            ventana.setTxt_fecha(FechaSql);
            ventana.setTxt_hora(HoraSql);
            ventana.setTxt_observaciones(ObservacionesSql);
            
            ventana.setVisible(true);
            
            
        } else {
            // Acceso denegado
            System.out.println("No se ha encontrado nada");
            JOptionPane.showMessageDialog(null, "Error, no se ha encontrado nada");
        }
		
		
	}
	catch(SQLException ex) {
		
	}
	return ID;
	
}


public void agendar_cita(String DNI_doctor, String fecha, String especialidad, String observaciones, String DNI_paciente, String hora ) {
	
	try {
		conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
		statement = conect.createStatement();
		String query = "INSERT INTO citas (DNI_doctor, Fecha, Especialidad, Observaciones, DNI_paciente, hora) " +
            "VALUES ('" + DNI_doctor + "', '" + fecha + "', '" + especialidad +"', '"  + " " + "', '" + DNI_paciente + "', '" + hora + "')";

		int fila = statement.executeUpdate(query);
		
		// Verificar si la inserción se realizó con éxito
		if (fila > 0) {
			System.out.println("Inserción exitosa.");
		} else {
			System.out.println("La inserción no tuvo éxito.");
		}
		
		System.out.println("Valores antes de la inserción:");
	    System.out.println("DNI_doctor: " + DNI_doctor);
	    System.out.println("fecha: " + fecha);
	    System.out.println("especialidad: " + especialidad);
	    System.out.println("observaciones: " + observaciones);
	    System.out.println("DNI_paciente: " + DNI_paciente);
	    System.out.println("hora: " + hora);
		
	}
	catch(SQLException ex) {
		ex.printStackTrace();
	}
	

}

public void mostarCbCitasPac(jd_nueva_consulta datos) throws SQLException {
    // Consulta para ver el nombre de las tablas
	conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
    statement = conect.createStatement();
    try {
        String sql = "SELECT DNI_paciente FROM pacientes";
        ResultSet rs = statement.executeQuery(sql);

        // Extraer datos del result set
        while (rs.next()) {
            // Obtener el nombre de la tabla
            tablaNombre = rs.getString(1);
            datos.setCb_paciente(tablaNombre);
        }
    } finally {
        if (statement != null) {
            statement.close();
        }
    }
}

public void mostarCbCitasDr(jd_nueva_consulta datos) throws SQLException {
    // Consulta para ver el nombre de las tablas
	conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
    statement = conect.createStatement();
    try {
        String sql = "SELECT DNI_doctor FROM doctores";
        ResultSet rs = statement.executeQuery(sql);

        // Extraer datos del result set
        while (rs.next()) {
            // Obtener el nombre de la tabla
            tablaNombre = rs.getString(1);
            datos.setCb_doctor(tablaNombre);
        }
    } finally {
        if (statement != null) {
            statement.close();
        }
    }
}

public List<String> getEspecialidades() throws SQLException {
    List<String> especialidades = new ArrayList<>();


    conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
    statement = conect.createStatement();
    try {
        // Establecer conexión a la base de datos
       

        // Consulta SQL para obtener las especialidades
        String query = "SELECT Nombre FROM especialidad";
        statement = conect.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery(query);

        // Recorrer los resultados y agregar las especialidades a la lista
        while (resultSet.next()) {
            String especialidad = resultSet.getString("nombre");
            especialidades.add(especialidad);
        }
    }
finally {
	
}
         
    

    return especialidades;
}

public void mostarCbCitasEsp(jd_nueva_consulta datos) throws SQLException {
    // Consulta para ver el nombre de las tablas
	conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
    statement = conect.createStatement();
    try {
        String sql = "SELECT Nombre FROM especialidad";
        ResultSet rs = statement.executeQuery(sql);

        // Extraer datos del result set
        while (rs.next()) {
            // Obtener el nombre de la tabla
            tablaNombre = rs.getString(1);
            datos.setCb_especialidad(tablaNombre);
        }
    } finally {
        if (statement != null) {
            statement.close();
        }
    }
}

}

	
