package dentilax_bdd;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ItemEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.sql.Date;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import com.toedter.calendar.JCalendar;

import Modelo.Cita;
import Modelo.Doctor;
import Modelo.Factura;
import Modelo.Inventario;
import Modelo.Odontograma;
import Modelo.Paciente;
import Modelo.Pedido;
import Modelo.Proveedores;
import Modelo.Solicitud;
import dialogos_consultas.jd_buscar_cita;
import dialogos_consultas.jd_buscar_consulta_editar;
import dialogos_consultas.jd_buscar_consulta_eliminar;
import dialogos_consultas.jd_historial_cita;
import dialogos_consultas.jd_mod_consulta;
import dialogos_consultas.jd_nueva_consulta;
import dialogos_doctores.jd_buscar_doctor;
import dialogos_doctores.jd_buscar_doctor_baja;
import dialogos_doctores.jd_buscar_doctor_editar;
import dialogos_doctores.jd_buscar_dr_historial;
import dialogos_facturas.jd_buscar_factura;
import dialogos_facturas.jd_historial_cobro;
import dialogos_facturas.jd_nueva_factura;
import dialogos_materiales.jd_buscar_pedidos;
import dialogos_materiales.jd_hacer_pedido;
import dialogos_materiales.jd_historial_solicitud;
import dialogos_materiales.jd_inventario;
import dialogos_materiales.jd_pedido_menudr;
import dialogos_materiales.jd_proveedores;
import dialogos_materiales.jd_revisar_solicitud;
import dialogos_pacientes.jd_buscar_paciente;
import dialogos_pacientes.jd_buscar_paciente_baja;
import dialogos_pacientes.jd_buscar_paciente_editar;
import dialogos_pacientes.jd_buscar_paciente_historial;
import dialogos_pacientes.jd_buscar_paciente_menudr;


public class ConectorDB_mysql {
	private boolean citaCorrecta = false;
	private static final String CONTROLADOR = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/dentilax?useSSL=false";
	private static final String USUARIO = "root";
	String tablaNombre;
	private static final String CLAVE = "1234";
	ResultSet resultado = null;
	Connection conect = null;
	Statement statement;
    JCalendar calendar = new JCalendar();
	


	static {
		try {
			Class.forName(CONTROLADOR);
		} catch (ClassNotFoundException e) {
			System.out.println("Error al cargar el controlador");
			e.printStackTrace();
		}
	}
	
	public Connection conectar() {
	
		
		try {
			conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
			System.out.println("Conexión OK");
			 statement = conect.createStatement();
			

		} catch (SQLException e) {
			System.out.println("Error en la conexión");
			e.printStackTrace();
		}
		
		return conect;
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

public String consulta_paciente_cargar(String nombre, String apellidos) throws SQLException{
	
	try {
		conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
		statement = conect.createStatement();
		String query = "SELECT * FROM pacientes WHERE Nombre = '" + nombre +"' AND Apellidos = '"+ apellidos+"'";
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
	return nombre;
	
}
	
	public String consulta_doctor(String nombre, String apellidos) throws SQLException{
		
		try {
			conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
			statement = conect.createStatement();
			String query = "SELECT * FROM doctores WHERE Nombre = '" + nombre +"' AND Apellidos = '" + apellidos + "'";
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
		return nombre;
		
	}
	
public String consulta_paciente(String nombre, String apellidos) throws SQLException{
		
		try {
			conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
			statement = conect.createStatement();
			String query = "SELECT * FROM pacientes WHERE Nombre = '" + nombre +"' AND Apellidos = '"+ apellidos+"'";
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
		return nombre;
		
	}


public String consulta_paciente_menudr(String nombre, String apellidos) throws SQLException{
	
	try {
		conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
		statement = conect.createStatement();
		String query = "SELECT DNI_paciente, Nombre, Apellidos FROM pacientes WHERE Nombre = '" + nombre + "' AND Apellidos = '" + apellidos + "'";
        ResultSet resultSet = statement.executeQuery(query);
		
        if (resultSet.next()) {
            // Resultado encontrado
            System.out.println("Resultado encontrado");
            dialogos_pacientes.jd_buscar_paciente_encontrado_menudr ventana = new dialogos_pacientes.jd_buscar_paciente_encontrado_menudr();
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
	return nombre;
	
}



public String consulta_pedido(int id) throws SQLException{
	String id_string=String.valueOf(id);
	try {
		conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
		statement = conect.createStatement();
		String query = "SELECT pedidos.ID_pedidos, pedidos.Producto, pedidos.Cantidad, pedidos.Precio, pedidos.Fecha, pedidos.id_proveedor, proveedores.Proveedor FROM pedidos JOIN proveedores ON proveedores.ID_proveedor = pedidos.id_proveedor WHERE pedidos.ID_pedidos = '" + id_string +"'";
        ResultSet resultSet = statement.executeQuery(query);
		
        if (resultSet.next()) {
            // Resultado encontrado
            System.out.println("Resultado encontrado");
            dialogos_materiales.jd_buscar_pedido_ficha ventana = new dialogos_materiales.jd_buscar_pedido_ficha();
            String idSql = resultSet.getString("pedidos.ID_pedidos");
            String productoSql = resultSet.getString("pedidos.Producto");
            String cantidadSql = resultSet.getString("pedidos.Cantidad");
            String precioSql = resultSet.getString("pedidos.Precio");
            String fechaSql = resultSet.getString("pedidos.Fecha");
            String proveedorSql = resultSet.getString("proveedores.Proveedor");
            ventana.setTxt_id(idSql);
            ventana.setTxt_producto(productoSql);
            ventana.setTxt_cantidad(cantidadSql);
            ventana.setTxt_precio(precioSql);
            ventana.setTxt_fecha(fechaSql);
            ventana.setTxt_proveedor(proveedorSql);
            ventana.setVisible(true);
            
            
        } else {
            // Acceso denegado
            System.out.println("No se ha encontrado nada");
            JOptionPane.showMessageDialog(null, "Error, no se ha encontrado nada");
        }
		
		
	}
	catch(SQLException ex) {
		
	}
	return id_string;
	
}

public String consulta_buscar_cita(String fecha, String dni) throws SQLException{
	
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

public String consulta_eliminar_cita(String fecha, String dni) throws SQLException{
	
	try {
		conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
		statement = conect.createStatement();
		String query =  "SELECT citas.ID_cita, citas.Fecha, doctores.Nombre, pacientes.Nombre FROM citas JOIN doctores ON citas.DNI_doctor = doctores.DNI_doctor JOIN pacientes ON citas.DNI_paciente = pacientes.DNI_paciente WHERE citas.DNI_paciente = '" + dni +"' AND citas.Fecha = '"+ fecha+ "'";
        ResultSet resultSet = statement.executeQuery(query);
		
        if (resultSet.next()) {
            // Resultado encontrado
            System.out.println("Resultado encontrado");
            dialogos_consultas.jd_buscar_consulta_eliminar_encontrada ventana = new dialogos_consultas.jd_buscar_consulta_eliminar_encontrada();
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

public String consulta_paciente_eliminar(String nombre, String apellidos) throws SQLException{
	
	try {
		conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
		statement = conect.createStatement();
		String query = "SELECT * FROM pacientes WHERE Nombre = '" + nombre +"' AND Apellidos = '"+ apellidos +"'";
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
	return nombre;
	
}

public String consulta_doctor_eliminar(String nombre, String apellidos) throws SQLException{
	
	try {
		conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
		statement = conect.createStatement();
		String query = "SELECT * FROM doctores WHERE Nombre = '" + nombre + "' AND Apellidos = '" + apellidos + "'";
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
	return nombre;
	
}
	
	public List<Cita> obtenerInfoCitas() {
        List<Cita> historiales = new ArrayList<>();

        try {
            conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
            statement = conect.createStatement();
            String query = "SELECT Fecha, Especialidad, DNI_paciente, ID_cita FROM citas";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String fecha = resultSet.getString("Fecha");
                String especialidad = resultSet.getString("Especialidad");
                String dniPaciente = resultSet.getString("DNI_paciente");
                String id = resultSet.getString("ID_cita");

               Cita historial = new Cita(fecha,especialidad,dniPaciente,id);

                historiales.add(historial);
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
	
	public List<Factura> obtener_facturas() {
        List<Factura> historiales = new ArrayList<>();

        try {
            conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
            statement = conect.createStatement();
            String query = "SELECT Fecha, Nombre, Apellidos, Por_pagar, ID_factura, Pagado, DNI_paciente FROM facturacion";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String Fecha = resultSet.getString("Fecha");
                String Nombre = resultSet.getString("Nombre");
                String Apellidos = resultSet.getString("Apellidos");
                String Por_pagar = resultSet.getString("Por_pagar");
                String ID_factura = resultSet.getString("ID_factura");
                String Pagado = resultSet.getString("Pagado");
                String DNI_paciente = resultSet.getString("DNI_paciente");

                Factura historial = new Factura(Fecha,Nombre,Apellidos,Por_pagar,ID_factura, Pagado, DNI_paciente);

                historiales.add(historial);
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
	
	public List<Factura> obtener_facturas_nuevas() {
        List<Factura> historiales = new ArrayList<>();

        try {
            conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
            statement = conect.createStatement();
            String query = "SELECT Fecha, Nombre, Apellidos, Por_pagar, ID_factura FROM facturacion WHERE Pagado = 0 AND Por_pagar = 0";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String Fecha = resultSet.getString("Fecha");
                String Nombre = resultSet.getString("Nombre");
                String Apellidos = resultSet.getString("Apellidos");
                String Por_pagar = resultSet.getString("Por_pagar");
                String ID_factura = resultSet.getString("ID_factura");
                
                Factura historial = new Factura(Fecha,Nombre,Apellidos,Por_pagar,ID_factura, "", "");

                historiales.add(historial);
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
	
	
	public List<Factura> obtener_facturas_cobro(String id) {
        List<Factura> historiales = new ArrayList<>();

        try {
            conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
            statement = conect.createStatement();
            String query = "SELECT Fecha, DNI_paciente, Cobro, Por_pagar, DNI_paciente FROM historial_facturacion WHERE ID_facturacion = '" + id + "'";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String Fecha = resultSet.getString("Fecha");
                String DNI_paciente = resultSet.getString("DNI_paciente");
                String Cobro = resultSet.getString("Cobro");
                String Por_pagar = resultSet.getString("Por_pagar");

                Factura historial = new Factura(Fecha, DNI_paciente, Cobro, Por_pagar);

                historiales.add(historial);
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
	
	public List<Cita> obtenerInfoDoctor(String DNI_doctor) {
        List<Cita> historiales = new ArrayList<>();

        try {
            conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
            statement = conect.createStatement();
            String query = "SELECT Fecha, Especialidad, DNI_paciente FROM citas WHERE DNI_doctor = ?";
            
            PreparedStatement preparedStatement = conect.prepareStatement(query);
            preparedStatement.setString(1, DNI_doctor);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String fecha = resultSet.getString("Fecha");
                String especialidad = resultSet.getString("Especialidad");
                String dniPaciente = resultSet.getString("DNI_paciente");

                Cita historial = new Cita(fecha, especialidad, dniPaciente,"");
                historiales.add(historial);
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
	
	public List<Cita> obtenerInfoPaciente(String DNI_paciente) {
	    List<Cita> historiales = new ArrayList<>();

	    
	    try {
	        conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
	        statement = conect.createStatement();
	        String query = "SELECT Fecha, Especialidad, DNI_doctor FROM citas WHERE DNI_paciente = ?";
	        
	        PreparedStatement preparedStatement = conect.prepareStatement(query);
	        preparedStatement.setString(1, DNI_paciente);
	        ResultSet resultSet = preparedStatement.executeQuery();

	        while (resultSet.next()) {
	            String fecha = resultSet.getString("Fecha");
	            String esp = resultSet.getString("Especialidad");
	            String dni = resultSet.getString("DNI_doctor");

	            Cita historial = new Cita(fecha, esp, dni);
	            historiales.add(historial);
	        }

	    } catch (SQLException ex) {
	        ex.printStackTrace();  
	    } finally {
	        // Cierre de recursos
	    }

	    return historiales;
	}
	
	public List<Inventario> obtenerInventario() {
        List<Inventario> inventarios = new ArrayList<>();

        try {
            conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
            statement = conect.createStatement();
            String query = "SELECT ID_producto, Nombre, Cantidad FROM inventario";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String id = resultSet.getString("ID_producto");
                String producto = resultSet.getString("Nombre");
                String cantidad = resultSet.getString("Cantidad");

                Inventario Inventario = new Inventario(id,producto,cantidad);

                inventarios.add(Inventario);
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

        return inventarios;
    }
	
	public List<Solicitud> obtenerSolicitudes() {
	    List<Solicitud> solicitudes = new ArrayList<>();

	    try {
	        conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
	        statement = conect.createStatement();
	        String query = "SELECT ID_solicitud, Nombre_producto, DNI_doctor, Cantidad, Fecha, Estado FROM solicitudes";
	        ResultSet resultSet = statement.executeQuery(query);

	        while (resultSet.next()) {
	            int id = resultSet.getInt("ID_solicitud");
	            String nombreProducto = resultSet.getString("Nombre_producto");
	            String dniDoctor = resultSet.getString("DNI_doctor");
	            int cantidad = resultSet.getInt("Cantidad");
	            String fecha = resultSet.getString("Fecha");
	            String estado = resultSet.getString("Estado");

	            Solicitud solicitud = new Solicitud(id, nombreProducto, dniDoctor, cantidad, fecha, estado);

	            solicitudes.add(solicitud);
	        }

	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    } finally {
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

	    return solicitudes;
	}

	public List<Solicitud> obtenerSolicitudesActivas() {
	    List<Solicitud> solicitudesActivas = new ArrayList<>();

	    try {
	        conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
	        statement = conect.createStatement();
	        String query = "SELECT * FROM solicitudes WHERE Estado = 'Activa'";
	        ResultSet resultSet = statement.executeQuery(query);

	        while (resultSet.next()) {
	            int id = resultSet.getInt("ID_solicitud");
	            String nombreProducto = resultSet.getString("Nombre_producto");
	            String dniDoctor = resultSet.getString("DNI_doctor");
	            int cantidad = resultSet.getInt("Cantidad");
	            String fecha = resultSet.getString("Fecha");
	            String estado = resultSet.getString("Estado");

	            Solicitud solicitud = new Solicitud(id, nombreProducto, dniDoctor, cantidad, fecha, estado);

	            solicitudesActivas.add(solicitud);
	        }

	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    } finally {
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

	    return solicitudesActivas;
	}
	
	public List<Doctor> obtener_doctores() {
	    List<Doctor> doctores = new ArrayList<>();

	    try {
	        conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
	        statement = conect.createStatement();
	        String query = "SELECT nombre, apellidos, especialidad, telefono, correo FROM doctores";
	        ResultSet resultSet = statement.executeQuery(query);

	        while (resultSet.next()) {
	            String nombre = resultSet.getString("nombre");
	            String apellidos = resultSet.getString("apellidos");
	            String especialidad = resultSet.getString("especialidad");
	            String telefono = resultSet.getString("telefono");
	            String correo = resultSet.getString("correo");

	            Doctor doctor = new Doctor(nombre, apellidos, especialidad, telefono, correo);

	            doctores.add(doctor);
	        }

	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    } finally {
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

	    return doctores;
	}
	
	
	public List<Paciente> obtener_pacientes() {
	    List<Paciente> pacientes = new ArrayList<>();

	    try {
	        conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
	        statement = conect.createStatement();
	        String query = "SELECT nombre, apellidos, observaciones, seguro FROM pacientes";
	        ResultSet resultSet = statement.executeQuery(query);

	        while (resultSet.next()) {
	            String nombre = resultSet.getString("nombre");
	            String apellidos = resultSet.getString("apellidos");
	            String observaciones = resultSet.getString("observaciones");
	            String seguro = resultSet.getString("seguro");

	            Paciente paciente = new Paciente(nombre, apellidos, observaciones, seguro);

	            pacientes.add(paciente);
	        }

	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    } finally {
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

	    return pacientes;
	}
	
	public List<Pedido> obtener_pedidos() {
	    List<Pedido> pedidos = new ArrayList<>();

	    try {
	        conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
	        statement = conect.createStatement();
	        String query = "SELECT ID_pedidos, Producto, Fecha FROM pedidos";
	        ResultSet resultSet = statement.executeQuery(query);

	        while (resultSet.next()) {
	            int id = resultSet.getInt("ID_pedidos");
	            String nombreProducto = resultSet.getString("Producto");
	            String fecha = resultSet.getString("Fecha");
	            Pedido pedido = new Pedido(id, nombreProducto, fecha);
	            pedidos.add(pedido);
	        }

	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    } finally {
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

	    return pedidos;
	}

	
	
	public List<Odontograma> obtenerOdontogramaPorDiente(int idDiente, int idPaciente) {
	    List<Odontograma> dientes = new ArrayList<>();

	    try (Connection connection = DriverManager.getConnection(URL, USUARIO, CLAVE);
	         PreparedStatement preparedStatement = connection.prepareStatement("SELECT id_diente, observaciones, fecha FROM odontograma WHERE id_diente = ? AND id_paciente = ?");
	    ) {
	        preparedStatement.setInt(1, idDiente);
	        preparedStatement.setInt(2, idPaciente);

	        try (ResultSet resultSet = preparedStatement.executeQuery()) {
	            while (resultSet.next()) {
	                int diente = resultSet.getInt("id_diente");
	                String observaciones = resultSet.getString("observaciones");
	                Date fecha = resultSet.getDate("fecha");

	                Odontograma odontograma = new Odontograma(diente, observaciones, fecha);
	                dientes.add(odontograma);
	            }
	        }

	    } catch (SQLException ex) {
	        // Manejar la excepción adecuadamente, puedes lanzar una nueva excepción personalizada o utilizar un sistema de registro
	        ex.printStackTrace();
	    }

	    return dientes;
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
                dialogos_doctores.jd_buscar_dr_ficha ventana = new dialogos_doctores.jd_buscar_dr_ficha(dni);
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
            dialogos_pacientes.jd_buscar_paciente_ficha ventana = new dialogos_pacientes.jd_buscar_paciente_ficha(dni);
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

public String consulta_doctor_cargar(String nombre, String apellidos) throws SQLException{
	
	try {
		conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
		statement = conect.createStatement();
		String query = "SELECT * FROM doctores WHERE Nombre = '" + nombre +"' AND Apellidos = '" + apellidos + "'";
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
	return nombre;
	
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

public void insertar_pedido(String producto, int cantidad) throws SQLException {
    int precio = 0;
    int id_proveedor = 0;

    try {
        conect = DriverManager.getConnection(URL, USUARIO, CLAVE);

        // Obtener el precio del producto desde la tabla de proveedores
        String obtenerPrecioQuery = "SELECT Precio_Producto FROM proveedores WHERE Producto = ?";
        try (PreparedStatement obtenerPrecioStatement = conect.prepareStatement(obtenerPrecioQuery)) {
            obtenerPrecioStatement.setString(1, producto);
            try (ResultSet resultSet = obtenerPrecioStatement.executeQuery()) {
                if (resultSet.next()) {
                    precio = resultSet.getInt("Precio_Producto");
                }
            }
        }

        // Obtener el ID del proveedor desde la tabla de proveedores
        String obtenerIdProveedorQuery = "SELECT ID_proveedor FROM proveedores WHERE Producto = ?";
        try (PreparedStatement obtenerIdProveedorStatement = conect.prepareStatement(obtenerIdProveedorQuery)) {
            obtenerIdProveedorStatement.setString(1, producto);
            try (ResultSet resultSet = obtenerIdProveedorStatement.executeQuery()) {
                if (resultSet.next()) {
                    id_proveedor = resultSet.getInt("ID_proveedor");
                }
            }
        }

        // Verificar si se encontró un proveedor
        if (id_proveedor == 0) {
            // Mostrar un JOptionPane informando del error y recomendando crear un proveedor
            JOptionPane.showMessageDialog(null, "Error: No se encontró un proveedor para el producto '"
                    + producto + "'. Recomendamos crear un proveedor para este producto.");
            return; // Salir del método, ya que no se puede continuar sin un proveedor
        }

        // Obtener la fecha actual
        String fechaStr = LocalDate.now().toString();

        // Convertir la cadena de fecha a un objeto Date
        java.sql.Date fecha = null;
        try {
            fecha = new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse(fechaStr).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Utilizar una consulta parametrizada para evitar la inyección de SQL
        String query = "INSERT INTO pedidos (Producto, Cantidad, Precio, Fecha, id_proveedor) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = conect.prepareStatement(query)) {
            preparedStatement.setString(1, producto);
            preparedStatement.setInt(2, cantidad);
            preparedStatement.setDouble(3, precio);
            preparedStatement.setDate(4, fecha);
            preparedStatement.setInt(5, id_proveedor);

            int fila = preparedStatement.executeUpdate();

            if (fila > 0) {
                System.out.println("Inserción exitosa.");
                JOptionPane.showMessageDialog(null, "Pedido añadido con éxito");
            } else {
                System.out.println("La inserción no tuvo éxito.");
            }
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error en la inserción del pedido, comprueba los campos.");
        ex.printStackTrace();
    } finally {
        // Cerrar la conexión en el bloque finally para asegurar su cierre
        if (conect != null) {
            conect.close();
        }
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

public void insertar_paciente(String dni, String apellidos, String nombre, String nacimiento, String seguro, String estado, String genero, String observaciones,
		String telefono, String correo, String direccion) throws SQLException{
	
	try {//inserto paciente 
		conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
		statement = conect.createStatement();
		String query = "INSERT INTO pacientes (DNI_paciente, Apellidos, Nombre, Nacimiento, Seguro, Estado, Genero, Observaciones, Telefono, Correo, Direccion) " +
            "VALUES ('" + dni + "', '" + apellidos + "', '" + nombre + "', '" + nacimiento + "', '" + seguro + "', '" + estado + "', '" + genero + "', '" + observaciones + "', '" + telefono + "', '" + correo + "', '" + direccion + "')";

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

public void insertar_solicitud(String solicitud, String DNI_doctor, String cantidad) {
	
	Date fechaDelMomento = new Date(Calendar.getInstance().getTime().getTime());
	
	try {
		conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
		statement = conect.createStatement();
		String query = "INSERT INTO solicitudes (Nombre_producto, DNI_doctor, Cantidad, Fecha, Estado) " +
            "VALUES ('" + solicitud + "', '" + DNI_doctor + "', '" + cantidad + "', '" + fechaDelMomento + "', '"+ "Activa" + "')";

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
		String query = "SELECT citas.ID_cita, citas.Fecha, doctores.Nombre, pacientes.Nombre FROM citas JOIN doctores ON citas.DNI_doctor = doctores.DNI_doctor "
				+ "JOIN pacientes ON citas.DNI_paciente = pacientes.DNI_paciente WHERE citas.ID_cita = '" + id + "'AND citas.Fecha >= CURDATE()";
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
            JOptionPane.showMessageDialog(null, "Error, no se ha encontrado nada o la cita es anterior al día presente");
        }
		
		
	}
	catch(SQLException ex) {
		
	}
	return id;
	
}

public String consulta_cita_modificar_encontrar(String id) throws SQLException {
    try {
        conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
        statement = conect.createStatement();
        String query = "SELECT citas.ID_cita, citas.Fecha, doctores.Nombre AS DoctorNombre, pacientes.Nombre AS PacienteNombre " +
                "FROM citas " +
                "JOIN doctores ON citas.DNI_doctor = doctores.DNI_doctor " +
                "JOIN pacientes ON citas.DNI_paciente = pacientes.DNI_paciente " +
                "WHERE citas.ID_cita = '" + id + "' AND citas.Fecha >= CURDATE()";

        ResultSet resultSet = statement.executeQuery(query);

        if (resultSet.next()) {
            // Resultado encontrado
            System.out.println("Resultado encontrado");
            String ID = resultSet.getString("citas.ID_cita");
            String fechaSql = resultSet.getString("citas.Fecha");
            String doctorSql = resultSet.getString("DoctorNombre");
            String pacienteSql = resultSet.getString("PacienteNombre");

            // Continuar con la ventana de modificación
            dialogos_consultas.jd_buscar_consulta_modificar_encontrada ventana = new dialogos_consultas.jd_buscar_consulta_modificar_encontrada();
            ventana.setTxt_fecha(fechaSql);
            ventana.setTxt_doctor(doctorSql);
            ventana.setTxt_paciente(pacienteSql);
            ventana.setLbl_id(ID);
            ventana.setVisible(true);
        } else {
            // No se encontró nada o la cita es anterior al día presente
            System.out.println("No se ha encontrado nada o la cita es anterior al día presente");
            JOptionPane.showMessageDialog(null, "Error, no se ha encontrado nada o la cita es anterior al día presente");
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return id;
}

public void consulta_modificar_factura(String id, int por_pagar) throws SQLException{
    conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
    statement = conect.createStatement();
	String query = "UPDATE facturacion SET Por_pagar = '"+ por_pagar + "' WHERE ID_factura = '" + id + "'";
    
		if(por_pagar>=0) {
			statement.executeUpdate(query);
            System.out.println("Factura modificada");
            JOptionPane.showMessageDialog(null, "Factura modificada");
		}
		else {
			JOptionPane.showMessageDialog(null, "Error campo vacio o numero negativo");
		}
	}

public void consulta_cobrar_factura(String id, int por_pagar, int pagado, int pagar, String DNI_paciente) throws SQLException{
	dialogos_facturas.jd_cobrar_factura ventana = new dialogos_facturas.jd_cobrar_factura();
    conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
    statement = conect.createStatement();
    int total_pagado = pagado + pagar;
    int total_pagar = por_pagar - pagar;
	String query = "UPDATE facturacion SET Pagado = '"+ total_pagado + "', Por_pagar = '" + total_pagar + "' WHERE ID_factura = '" + id + "'";
	String query_2 = "INSERT INTO dentilax.historial_facturacion (Fecha, DNI_paciente, ID_facturacion, Cobro, Por_pagar) VALUES (CURDATE(), '" + DNI_paciente +"', '" + id + "', '" + pagar +"', '" + total_pagar + "');";
    
		if(por_pagar>=0) {
			if(total_pagar > 0) {
				statement.executeUpdate(query);
				statement.executeUpdate(query_2);
	            System.out.println("Factura cobrada");
	            JOptionPane.showMessageDialog(null, "Factura cobrada");
			}
			else {
				JOptionPane.showMessageDialog(null, "Error cobrado mas de lo que se tiene que pagar");
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Error campo vacio o numero negativo");
		}
	}



public void consulta_eliminar_cita(String id) throws SQLException{
	String query = "DELETE FROM citas WHERE ID_cita = ? AND Fecha > CURDATE()";
	
	try (Connection conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
		PreparedStatement pstmt = conect.prepareStatement(query)){
		pstmt.setString(1, id);
		int affectedRows = pstmt.executeUpdate();
		if (affectedRows > 0) {
            System.out.println("Cita eliminada");
        }
	}
	catch(SQLException ex) {
		System.out.println("Error en eliminar la cita");
		JOptionPane.showMessageDialog(null, "La cita es anterior al día actual.", "Error", JOptionPane.ERROR_MESSAGE);
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


private static final String FORMATO_FECHA = "yyyy/MM/dd";

public void agendar_cita(String DNI_doctor, String fecha, String especialidad, String observaciones, String DNI_paciente, String hora) {
    Connection conect = null;
    Statement statement = null;

    try {
        conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
        statement = conect.createStatement();

        // Convertir el string de fecha al formato deseado
        java.util.Date actual_date = calendar.getDate();
        System.out.println(actual_date);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date utilDate = sdf.parse(fecha);
        long time = utilDate.getTime();
        java.sql.Date sqlDate = new java.sql.Date(time);
        System.out.println(sqlDate);

        // Realizar SELECT para obtener Nombre y Apellidos del paciente
        String queryApoyo = "SELECT Nombre, Apellidos FROM pacientes WHERE DNI_paciente = '" + DNI_paciente + "'";
        ResultSet resultSet = statement.executeQuery(queryApoyo);

        // Obtener los valores de Nombre y Apellidos
        String nombrePaciente = "";
        String apellidosPaciente = "";
        if (resultSet.next()) {
            nombrePaciente = resultSet.getString("Nombre");
            apellidosPaciente = resultSet.getString("Apellidos");
        }

        // Verificar si la fecha de facturación es posterior a la actual
        if (sqlDate.after(actual_date)) {
            // Construir queryFactura sin especificar ID_factura (se asumirá AUTO_INCREMENT)
            String queryFactura = "INSERT INTO facturacion (DNI_paciente, Nombre, Apellidos, Fecha, Pagado, Por_pagar) " +
                    "VALUES ('" + DNI_paciente + "', '" + nombrePaciente + "', '" + apellidosPaciente + "', '" + sqlDate + "', '" + 0 + "', '" + 0 + "')";

            // Ejecutar INSERT para la factura
            int filaFactura = statement.executeUpdate(queryFactura, Statement.RETURN_GENERATED_KEYS);

            // Obtener el ID_factura recién insertado
            ResultSet generatedKeys = statement.getGeneratedKeys();
            int nuevoIdFactura = 0;
            if (generatedKeys.next()) {
                nuevoIdFactura = generatedKeys.getInt(1);
            }

            // Construir query para la cita con el nuevo valor de ID_factura
            String queryCita = "INSERT INTO citas (ID_factura, DNI_doctor, Fecha, Especialidad, Observaciones, DNI_paciente, Hora) " +
                    "VALUES ('" + nuevoIdFactura + "', '" + DNI_doctor + "', '" + sqlDate + "', '" + especialidad + "', '" + observaciones + "', '" + DNI_paciente + "', '" + hora + "')";

            if (sqlDate.after(actual_date)) {
                // Ejecutar INSERT para la cita
                int filaCita = statement.executeUpdate(queryCita);
                if (filaCita > 0) {
                    System.out.println("Inserción de cita exitosa.");
                    JOptionPane.showMessageDialog(null, "Cita añadida con éxito");
                } else {
                    System.out.println("La inserción de cita no tuvo éxito.");
                }

                System.out.println("Valores antes de la inserción:");
                System.out.println("DNI_doctor: " + DNI_doctor);
                System.out.println("fecha: " + fecha);
                System.out.println("especialidad: " + especialidad);
                System.out.println("observaciones: " + observaciones);
                System.out.println("DNI_paciente: " + DNI_paciente);
                System.out.println("hora: " + hora);
            } else {
                JOptionPane.showMessageDialog(null, "Fecha anterior a la actual");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Fecha de facturación anterior a la actual");
        }

    } catch (SQLException | ParseException ex) {
        ex.printStackTrace();
    } finally {
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
}


public void modificarCita(int idCita, String DNI_doctor, String fecha, String especialidad, String observaciones, String DNI_paciente, String hora) {
    try {
        conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
        statement = conect.createStatement();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date utilDate = sdf.parse(fecha);
        long time = utilDate.getTime();
        java.sql.Date sqlDate = new java.sql.Date(time);
        
        String query = "UPDATE citas SET DNI_doctor='" + DNI_doctor + "', Fecha='" + fecha + "', Especialidad='" + especialidad + "', "
                + "Observaciones='" + observaciones + "', DNI_paciente='" + DNI_paciente + "', Hora='" + hora + "' "
                + "WHERE ID_cita=" + idCita+ "')";

        int fila = statement.executeUpdate(query);

        // Verificar si la actualización se realizó con éxito
        if (fila > 0) {
            System.out.println("Actualización exitosa.");
            JOptionPane.showMessageDialog(null, "Cita actualizada");
            citaCorrecta = true;
        } else {
            System.out.println("La actualización no tuvo éxito o la cita es anterior al día presente.");
            JOptionPane.showMessageDialog(null, "No se puede modificar una cita anterior al día presente", "Error en la modificación de cita", 0, null);
        }

        System.out.println("Valores antes de la actualización:");
        System.out.println("idCita: " + idCita);
        System.out.println("DNI_doctor: " + DNI_doctor);
        System.out.println("fecha: " + fecha);
        System.out.println("especialidad: " + especialidad);
        System.out.println("observaciones: " + observaciones);
        System.out.println("DNI_paciente: " + DNI_paciente);
        System.out.println("hora: " + hora);

    } catch (SQLException | ParseException ex) {
        JOptionPane.showMessageDialog(null, "No puedes seleccionar una fecha anterior a la actual", "Error en la modificación de cita", 0, null);
        ex.printStackTrace();
    }
}




public boolean isCitaCorrecta() {
	return citaCorrecta;
}
public void setCitaCorrecta(boolean citaCorrecta) {
	this.citaCorrecta = citaCorrecta;
}
public void mostarCbCitasPac(jd_nueva_consulta datos) throws SQLException {
    // Consulta para ver el nombre de las tablas
	conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
    statement = conect.createStatement();
    try {
        String sql = "SELECT Nombre, DNI_paciente FROM pacientes";
        ResultSet rs = statement.executeQuery(sql);

        // Extraer datos del result set
        while (rs.next()) {
            // Obtener el nombre y el DNI de la tabla
            String nombre = rs.getString("Nombre");
            String dni = rs.getString("DNI_paciente");
            
            // Crear una cadena con el nombre y el DNI y agregarla al combo
            String nombreYDNI = nombre + " con DNI: " + dni;
            datos.setCb_paciente(nombreYDNI);
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
        String sql = "SELECT Nombre, DNI_doctor FROM doctores";
        ResultSet rs = statement.executeQuery(sql);

        // Extraer datos del result set
        while (rs.next()) {
            // Obtener el nombre de la tabla
        	String nombre = rs.getString("Nombre");
        	String dni = rs.getString("DNI_doctor");
            tablaNombre = nombre+" con DNI: "+dni;
            datos.setCb_doctor(tablaNombre);
        }
    } finally {
        if (statement != null) {
            statement.close();
        }
    }
}

public void mostarCbProductosProv(jd_hacer_pedido datos) throws SQLException {
    // Consulta para ver el nombre de las tablas
	conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
    statement = conect.createStatement();
    try {
        String sql = "SELECT Producto FROM proveedores";
        ResultSet rs = statement.executeQuery(sql);

        // Extraer datos del result set
        while (rs.next()) {
            // Obtener el nombre y el DNI de la tabla
            String nombre = rs.getString("Producto");
            datos.setCb_productos(nombre);
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
        //String sql = "SELECT especialidad.Nombre FROM especialidad JOIN doctores ON doctores.Especialidad = especialidad.Nombre WHERE doctores.DNI_doctor = '"+ dni + "'";
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
int idPaciente;
public int obtenerIdPacientePorDni(String DNI_paciente) {
    idPaciente = -1; // Valor predeterminado si no se encuentra el paciente

    try {
    	 conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
        // Crear la sentencia SQL para obtener el ID del paciente por DNI
        String query = "SELECT ID_paciente FROM pacientes WHERE DNI_paciente = ?";
        
        // Crear la instancia del PreparedStatement
        try (PreparedStatement preparedStatement = conect.prepareStatement(query)) {
            // Establecer el parámetro en el PreparedStatement
            preparedStatement.setString(1, DNI_paciente);

            // Ejecutar la consulta
            ResultSet resultSet = preparedStatement.executeQuery();

            // Verificar si se encontró el paciente
            if (resultSet.next()) {
                idPaciente = resultSet.getInt("ID_paciente");
            }
        }

    } catch (SQLException ex) {
        ex.printStackTrace();
    }

    return idPaciente;
}

public void mostrar_filtro_paciente(jd_buscar_paciente datos) throws SQLException {
    // Consulta para ver el nombre de las tablas
	conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
    statement = conect.createStatement();
    try {
        String sql = "SHOW fields FROM pacientes WHERE field = 'DNI_paciente' OR field = 'Nombre' OR field = 'Apellidos' OR field = 'Estado';";
        ResultSet rs = statement.executeQuery(sql);

        // Extraer datos del result set
        while (rs.next()) {
            // Obtener el nombre de la tabla
        	String Field = rs.getString("Field");
            datos.setCb_filtrar(Field);
        }
    } finally {
        if (statement != null) {
            statement.close();
        }
    }
}

public void mostrar_filtro_paciente_menu_dr(jd_buscar_paciente_menudr datos) throws SQLException {
    // Consulta para ver el nombre de las tablas
	conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
    statement = conect.createStatement();
    try {
        String sql = "SHOW fields FROM pacientes WHERE field = 'DNI_paciente' OR field = 'Nombre' OR field = 'Apellidos' OR field = 'Estado';";
        ResultSet rs = statement.executeQuery(sql);

        // Extraer datos del result set
        while (rs.next()) {
            // Obtener el nombre de la tabla
        	String Field = rs.getString("Field");
            datos.setCb_filtrar(Field);
        }
    } finally {
        if (statement != null) {
            statement.close();
        }
    }
}

public void mostrar_filtro_paciente_editar(jd_buscar_paciente_editar datos) throws SQLException {
    // Consulta para ver el nombre de las tablas
	conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
    statement = conect.createStatement();
    try {
        String sql = "SHOW fields FROM pacientes WHERE field = 'DNI_paciente' OR field = 'Nombre' OR field = 'Apellidos' OR field = 'Estado';";
        ResultSet rs = statement.executeQuery(sql);

        // Extraer datos del result set
        while (rs.next()) {
            // Obtener el nombre de la tabla
        	String Field = rs.getString("Field");
            datos.setCb_filtrar(Field);
        }
    } finally {
        if (statement != null) {
            statement.close();
        }
    }
}

public void mostrar_filtro_paciente_baja(jd_buscar_paciente_baja datos) throws SQLException {
    // Consulta para ver el nombre de las tablas
	conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
    statement = conect.createStatement();
    try {
        String sql = "SHOW fields FROM pacientes WHERE field = 'DNI_paciente' OR field = 'Nombre' OR field = 'Apellidos' OR field = 'Estado';";
        ResultSet rs = statement.executeQuery(sql);

        // Extraer datos del result set
        while (rs.next()) {
            // Obtener el nombre de la tabla
        	String Field = rs.getString("Field");
            datos.setCb_filtrar(Field);
        }
    } finally {
        if (statement != null) {
            statement.close();
        }
    }
}

public void mostrar_filtro_doctor(jd_buscar_doctor datos) throws SQLException {
    // Consulta para ver el nombre de las tablas
	conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
    statement = conect.createStatement();
    try {
        String sql = "SHOW fields FROM doctores WHERE field = 'DNI_doctor' OR field = 'Nombre' OR field = 'Apellidos' OR field = 'Estado' OR field = 'Especialidad';";
        ResultSet rs = statement.executeQuery(sql);

        // Extraer datos del result set
        while (rs.next()) {
            // Obtener el nombre de la tabla
        	String Field = rs.getString("Field");
            datos.setCb_filtrar(Field);
        }
    } finally {
        if (statement != null) {
            statement.close();
        }
    }
}

public void mostrar_filtro_doctor_editar(jd_buscar_doctor_editar datos) throws SQLException {
    // Consulta para ver el nombre de las tablas
	conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
    statement = conect.createStatement();
    try {
        String sql = "SHOW fields FROM doctores WHERE field = 'DNI_doctor' OR field = 'Nombre' OR field = 'Apellidos' OR field = 'Estado' OR field = 'Especialidad';";
        ResultSet rs = statement.executeQuery(sql);

        // Extraer datos del result set
        while (rs.next()) {
            // Obtener el nombre de la tabla
        	String Field = rs.getString("Field");
            datos.setCb_filtrar(Field);
        }
    } finally {
        if (statement != null) {
            statement.close();
        }
    }
}

public void mostrar_filtro_doctor_baja(jd_buscar_doctor_baja datos) throws SQLException {
    // Consulta para ver el nombre de las tablas
	conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
    statement = conect.createStatement();
    try {
        String sql = "SHOW fields FROM doctores WHERE field = 'DNI_doctor' OR field = 'Nombre' OR field = 'Apellidos' OR field = 'Estado' OR field = 'Especialidad';";
        ResultSet rs = statement.executeQuery(sql);

        // Extraer datos del result set
        while (rs.next()) {
            // Obtener el nombre de la tabla
        	String Field = rs.getString("Field");
            datos.setCb_filtrar(Field);
        }
    } finally {
        if (statement != null) {
            statement.close();
        }
    }
}

public void mostrar_filtro_pedidos(jd_buscar_pedidos datos) throws SQLException {
    // Consulta para ver el nombre de las tablas
	conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
    statement = conect.createStatement();
    try {
        String sql = "SHOW fields FROM pedidos WHERE field = 'Producto' OR field = 'Fecha';";
        ResultSet rs = statement.executeQuery(sql);

        // Extraer datos del result set
        while (rs.next()) {
            // Obtener el nombre de la tabla
        	String Field = rs.getString("Field");
            datos.setCb_filtrar(Field);
        }
    } finally {
        if (statement != null) {
            statement.close();
        }
    }
}

public void mostrar_filtro_proveedores(jd_proveedores datos) throws SQLException {
    // Consulta para ver el nombre de las tablas
	conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
    statement = conect.createStatement();
    try {
        String sql = "SHOW fields FROM proveedores WHERE field = 'Proveedor' OR field = 'Producto';";
        ResultSet rs = statement.executeQuery(sql);

        // Extraer datos del result set
        while (rs.next()) {
            // Obtener el nombre de la tabla
        	String Field = rs.getString("Field");
            datos.setCb_filtrar(Field);
        }
    } finally {
        if (statement != null) {
            statement.close();
        }
    }
}

public void mostrar_filtro_inventario(jd_inventario datos) throws SQLException {
    // Consulta para ver el nombre de las tablas
	conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
    statement = conect.createStatement();
    try {
        String sql = "SHOW fields FROM inventario WHERE field = 'Nombre';";
        ResultSet rs = statement.executeQuery(sql);

        // Extraer datos del result set
        while (rs.next()) {
            // Obtener el nombre de la tabla
        	String Field = rs.getString("Field");
            datos.setCb_filtrar(Field);
        }
    } finally {
        if (statement != null) {
            statement.close();
        }
    }
}

public void mostrar_filtro_inventario_menu_dr(jd_pedido_menudr datos) throws SQLException {
    // Consulta para ver el nombre de las tablas
	conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
    statement = conect.createStatement();
    try {
        String sql = "SHOW fields FROM inventario WHERE field = 'Nombre';";
        ResultSet rs = statement.executeQuery(sql);

        // Extraer datos del result set
        while (rs.next()) {
            // Obtener el nombre de la tabla
        	String Field = rs.getString("Field");
            datos.setCb_filtrar(Field);
        }
    } finally {
        if (statement != null) {
            statement.close();
        }
    }
}

public void mostrar_filtro_solicitudes_activas(jd_revisar_solicitud datos) throws SQLException {
    // Consulta para ver el nombre de las tablas
	conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
    statement = conect.createStatement();
    try {
        String sql = "SHOW fields FROM solicitudes WHERE field = 'Nombre_producto' OR field = 'Fecha';";
        ResultSet rs = statement.executeQuery(sql);

        // Extraer datos del result set
        while (rs.next()) {
            // Obtener el nombre de la tabla
        	String Field = rs.getString("Field");
            datos.setCb_filtrar(Field);
        }
    } finally {
        if (statement != null) {
            statement.close();
        }
    }
}

public void mostrar_filtro_solicitudes(jd_historial_solicitud datos) throws SQLException {
    // Consulta para ver el nombre de las tablas
	conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
    statement = conect.createStatement();
    try {
        String sql = "SHOW fields FROM solicitudes WHERE field = 'Nombre_producto' OR field = 'Fecha'  OR field = 'Estado';";
        ResultSet rs = statement.executeQuery(sql);

        // Extraer datos del result set
        while (rs.next()) {
            // Obtener el nombre de la tabla
        	String Field = rs.getString("Field");
            datos.setCb_filtrar(Field);
        }
    } finally {
        if (statement != null) {
            statement.close();
        }
    }
}

public void mostrar_filtro_cita(jd_buscar_cita datos) throws SQLException {
    // Consulta para ver el nombre de las tablas
	conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
    statement = conect.createStatement();
    try {
        String sql = "SHOW fields FROM citas WHERE field = 'Fecha' OR field = 'Especialidad'  OR field = 'DNI_paciente';";
        ResultSet rs = statement.executeQuery(sql);

        // Extraer datos del result set
        while (rs.next()) {
            // Obtener el nombre de la tabla
        	String Field = rs.getString("Field");
            datos.setCb_filtrar(Field);
        }
    } finally {
        if (statement != null) {
            statement.close();
        }
    }
}

public void mostrar_filtro_historial_cita(jd_historial_cita datos) throws SQLException {
    // Consulta para ver el nombre de las tablas
	conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
    statement = conect.createStatement();
    try {
        String sql = "SHOW fields FROM citas WHERE field = 'Fecha' OR field = 'Especialidad'  OR field = 'DNI_paciente';";
        ResultSet rs = statement.executeQuery(sql);

        // Extraer datos del result set
        while (rs.next()) {
            // Obtener el nombre de la tabla
        	String Field = rs.getString("Field");
            datos.setCb_filtrar(Field);
        }
    } finally {
        if (statement != null) {
            statement.close();
        }
    }
}

public void mostrar_filtro_cita_eliminar(jd_buscar_consulta_eliminar datos) throws SQLException {
    // Consulta para ver el nombre de las tablas
	conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
    statement = conect.createStatement();
    try {
        String sql = "SHOW fields FROM citas WHERE field = 'Fecha' OR field = 'Especialidad'  OR field = 'DNI_paciente';";
        ResultSet rs = statement.executeQuery(sql);

        // Extraer datos del result set
        while (rs.next()) {
            // Obtener el nombre de la tabla
        	String Field = rs.getString("Field");
            datos.setCb_filtrar(Field);
        }
    } finally {
        if (statement != null) {
            statement.close();
        }
    }
}

public void mostrar_filtro_cita_editar(jd_buscar_consulta_editar datos) throws SQLException {
    // Consulta para ver el nombre de las tablas
	conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
    statement = conect.createStatement();
    try {
        String sql = "SHOW fields FROM citas WHERE field = 'Fecha' OR field = 'Especialidad'  OR field = 'DNI_paciente';";
        ResultSet rs = statement.executeQuery(sql);

        // Extraer datos del result set
        while (rs.next()) {
            // Obtener el nombre de la tabla
        	String Field = rs.getString("Field");
            datos.setCb_filtrar(Field);
        }
    } finally {
        if (statement != null) {
            statement.close();
        }
    }
}

public void mostrar_filtro_factura(jd_buscar_factura datos) throws SQLException {
    // Consulta para ver el nombre de las tablas
	conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
    statement = conect.createStatement();
    try {
        String sql = "SHOW fields FROM facturacion WHERE field = 'DNI_paciente' OR field = 'Nombre'  OR field = 'Apellidos' OR field = 'Fecha' OR field = 'Por_pagar';";
        ResultSet rs = statement.executeQuery(sql);

        // Extraer datos del result set
        while (rs.next()) {
            // Obtener el nombre de la tabla
        	String Field = rs.getString("Field");
            datos.setCb_filtrar(Field);
        }
    } finally {
        if (statement != null) {
            statement.close();
        }
    }
}

public void mostrar_filtro_factura_nueva(jd_nueva_factura datos) throws SQLException {
    // Consulta para ver el nombre de las tablas
	conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
    statement = conect.createStatement();
    try {
        String sql = "SHOW fields FROM facturacion WHERE field = 'DNI_paciente' OR field = 'Nombre'  OR field = 'Apellidos' OR field = 'Fecha';";
        ResultSet rs = statement.executeQuery(sql);

        // Extraer datos del result set
        while (rs.next()) {
            // Obtener el nombre de la tabla
        	String Field = rs.getString("Field");
            datos.setCb_filtrar(Field);
        }
    } finally {
        if (statement != null) {
            statement.close();
        }
    }
}

public void mostrar_filtro_historial_cobro(jd_historial_cobro datos) throws SQLException {
    // Consulta para ver el nombre de las tablas
	conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
    statement = conect.createStatement();
    try {
        String sql = "SHOW fields FROM historial_facturacion WHERE field = 'Fecha';";
        ResultSet rs = statement.executeQuery(sql);

        // Extraer datos del result set
        while (rs.next()) {
            // Obtener el nombre de la tabla
        	String Field = rs.getString("Field");
            datos.setCb_filtrar(Field);
        }
    } finally {
        if (statement != null) {
            statement.close();
        }
    }
}
public void mostrar_filtro_paciente_historial(jd_buscar_paciente_historial datos) throws SQLException {
    // Consulta para ver el nombre de las tablas
	conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
    statement = conect.createStatement();
    try {
        String sql = "SHOW fields FROM citas WHERE field = 'Fecha' OR field = 'Especialidad' OR field = 'DNI_doctor';";
        ResultSet rs = statement.executeQuery(sql);

        // Extraer datos del result set
        while (rs.next()) {
            // Obtener el nombre de la tabla
        	String Field = rs.getString("Field");
            datos.setCb_filtrar(Field);
        }
    } finally {
        if (statement != null) {
            statement.close();
        }
    }
}

public void mostrar_filtro_dr_historial(jd_buscar_dr_historial datos) throws SQLException {
    // Consulta para ver el nombre de las tablas
	conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
    statement = conect.createStatement();
    try {
        String sql = "SHOW fields FROM citas WHERE field = 'Fecha' OR field = 'Especialidad' OR field = 'DNI_paciente';";
        ResultSet rs = statement.executeQuery(sql);

        // Extraer datos del result set
        while (rs.next()) {
            // Obtener el nombre de la tabla
        	String Field = rs.getString("Field");
            datos.setCb_filtrar(Field);
        }
    } finally {
        if (statement != null) {
            statement.close();
        }
    }
}

public List<Paciente> filtrar_tabla_paciente(String campo, String variable) throws SQLException{
	List<Paciente> pacientes = new ArrayList<>();
	try {
		conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
		statement = conect.createStatement();
		String query = "SELECT * FROM pacientes WHERE " + campo + " LIKE '" + variable + "%' OR " + campo + " LIKE '%" + variable + "'";
        ResultSet resultSet = statement.executeQuery(query);
		
        while (resultSet.next()) {
            String nombre = resultSet.getString("nombre");
            String apellidos = resultSet.getString("apellidos");
            String observaciones = resultSet.getString("observaciones");
            String seguro = resultSet.getString("seguro");

            Paciente paciente = new Paciente(nombre, apellidos, observaciones, seguro);

            pacientes.add(paciente);
        }

    } catch (SQLException ex) {
        ex.printStackTrace();
    } finally {
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

    return pacientes;
	
}

public List<Cita> filtrar_tabla_paciente_historial(String campo, String variable, String datos) throws SQLException{
	List<Cita> citas = new ArrayList<>();
	try {
		conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
		statement = conect.createStatement();
		String query = "SELECT * FROM citas WHERE DNI_paciente = '"+ datos + "' AND " + campo + " LIKE '" + variable + "%' OR " + campo + " LIKE '%" + variable + "'";
        ResultSet resultSet = statement.executeQuery(query);
		
        while (resultSet.next()) {
            String fecha = resultSet.getString("Fecha");
            String especialidad = resultSet.getString("Especialidad");
            String dni_doctor = resultSet.getString("DNI_doctor");

            Cita cita = new Cita(fecha, especialidad, dni_doctor);

            citas.add(cita);
        }

    } catch (SQLException ex) {
        ex.printStackTrace();
    } finally {
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

    return citas;
	
}


public List<Doctor> filtrar_tabla_doctor(String campo, String variable) throws SQLException{
	List<Doctor> doctores = new ArrayList<>();
	try {
		conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
		statement = conect.createStatement();
		String query = "SELECT * FROM doctores WHERE " + campo + " LIKE '" + variable + "%' OR " + campo + " LIKE '%" + variable + "'";
        ResultSet resultSet = statement.executeQuery(query);
		
        while (resultSet.next()) {
            String nombre = resultSet.getString("nombre");
            String apellidos = resultSet.getString("apellidos");
            String especialidad = resultSet.getString("especialidad");
            String telefono = resultSet.getString("telefono");
            String correo = resultSet.getString("correo");

            Doctor doctor = new Doctor(nombre, apellidos, especialidad, telefono, correo);

            doctores.add(doctor);
        }

    } catch (SQLException ex) {
        ex.printStackTrace();
    } finally {
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

    return doctores;
	
}

public List<Cita> filtrar_tabla_dr_historial(String campo, String variable, String datos) throws SQLException{
	List<Cita> citas = new ArrayList<>();
	try {
		conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
		statement = conect.createStatement();
		String query = "SELECT * FROM citas WHERE DNI_doctor = '"+ datos + "' AND " + campo + " LIKE '" + variable + "%' OR " + campo + " LIKE '%" + variable + "'";
        ResultSet resultSet = statement.executeQuery(query);
		
        while (resultSet.next()) {
            String fecha = resultSet.getString("Fecha");
            String especialidad = resultSet.getString("Especialidad");
            String dni_paciente = resultSet.getString("DNI_paciente");

            Cita cita = new Cita(fecha, especialidad, dni_paciente,"");

            citas.add(cita);
        }

    } catch (SQLException ex) {
        ex.printStackTrace();
    } finally {
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

    return citas;
	
}

public List<Pedido> filtrar_tabla_pedidos(String campo, String variable) throws SQLException{
	List<Pedido> pedidos = new ArrayList<>();
	try {
		conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
		statement = conect.createStatement();
		String query = "SELECT * FROM pedidos WHERE " + campo + " LIKE '" + variable + "%' OR " + campo + " LIKE '%" + variable + "'";
        ResultSet resultSet = statement.executeQuery(query);
		
        while (resultSet.next()) {
            int id_pedido = resultSet.getInt("ID_pedidos");
            String nombre_producto = resultSet.getString("Producto");
            String fecha = resultSet.getString("Fecha");

            Pedido class_pedido = new Pedido(id_pedido, nombre_producto, fecha);

            pedidos.add(class_pedido);
        }

    } catch (SQLException ex) {
        ex.printStackTrace();
    } finally {
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

    return pedidos;
	
}

public List<Proveedores> filtrar_tabla_proveedor(String campo, String variable) throws SQLException{
	List<Proveedores> proveedores = new ArrayList<>();
	try {
		conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
		statement = conect.createStatement();
		String query = "SELECT * FROM proveedores WHERE " + campo + " LIKE '" + variable + "%' OR " + campo + " LIKE '%" + variable + "'";
        ResultSet resultSet = statement.executeQuery(query);
		
        while (resultSet.next()) {
            int id_proveedor = resultSet.getInt("ID_proveedor");
            String proveedor = resultSet.getString("Proveedor");
            String producto = resultSet.getString("Producto");
            int precio = resultSet.getInt("Precio_producto");

            Proveedores class_proveedor = new Proveedores(id_proveedor, proveedor, producto, precio);

            proveedores.add(class_proveedor);
        }

    } catch (SQLException ex) {
        ex.printStackTrace();
    } finally {
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

    return proveedores;
	
}

public List<Inventario> filtrar_tabla_inventario(String campo, String variable) throws SQLException{
	List<Inventario> inventarios = new ArrayList<>();
	try {
		conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
		statement = conect.createStatement();
		String query = "SELECT * FROM inventario WHERE " + campo + " LIKE '" + variable + "%' OR " + campo + " LIKE '%" + variable + "'";
        ResultSet resultSet = statement.executeQuery(query);
		
        while (resultSet.next()) {
        	String id_producto = resultSet.getString("ID_producto");
            String nombre = resultSet.getString("Nombre");
            String cantidad = resultSet.getString("Cantidad");

            Inventario class_inventario = new Inventario(id_producto, nombre, cantidad);

            inventarios.add(class_inventario);
        }

    } catch (SQLException ex) {
        ex.printStackTrace();
    } finally {
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

    return inventarios;
	
}

public List<Solicitud> filtrar_tabla_solicitudes_activas(String campo, String variable) throws SQLException{
	List<Solicitud> solicitudes = new ArrayList<>();
	try {
		conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
		statement = conect.createStatement();
		String query = "SELECT * FROM solicitudes WHERE Estado = 'Activa' AND " + campo + " LIKE '" + variable + "%' OR " + campo + " LIKE '%" + variable + "'";
        ResultSet resultSet = statement.executeQuery(query);
		
        while (resultSet.next()) {
            int id_solicitud = resultSet.getInt("ID_solicitud");
            String nombre_producto = resultSet.getString("Nombre_producto");
            String dni_doctor = resultSet.getString("DNI_doctor");
            int cantidad = resultSet.getInt("Cantidad");
            String fecha = resultSet.getString("Fecha");
            String estado = resultSet.getString("Estado");
            

            Solicitud class_solicitud = new Solicitud(id_solicitud, nombre_producto, dni_doctor, cantidad, fecha, estado);

            solicitudes.add(class_solicitud);
        }

    } catch (SQLException ex) {
        ex.printStackTrace();
    } finally {
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

    return solicitudes;
	
}

public List<Solicitud> filtrar_tabla_solicitudes(String campo, String variable) throws SQLException{
	List<Solicitud> solicitudes = new ArrayList<>();
	try {
		conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
		statement = conect.createStatement();
		String query = "SELECT * FROM solicitudes WHERE " + campo + " LIKE '" + variable + "%' OR " + campo + " LIKE '%" + variable + "'";
        ResultSet resultSet = statement.executeQuery(query);
		
        while (resultSet.next()) {
            int id_solicitud = resultSet.getInt("ID_solicitud");
            String nombre_producto = resultSet.getString("Nombre_producto");
            String dni_doctor = resultSet.getString("DNI_doctor");
            int cantidad = resultSet.getInt("Cantidad");
            String fecha = resultSet.getString("Fecha");
            String estado = resultSet.getString("Estado");
            

            Solicitud class_solicitud = new Solicitud(id_solicitud, nombre_producto, dni_doctor, cantidad, fecha, estado);

            solicitudes.add(class_solicitud);
        }

    } catch (SQLException ex) {
        ex.printStackTrace();
    } finally {
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

    return solicitudes;
	
}

public List<Cita> filtrar_tabla_buscar_citas(String campo, String variable) throws SQLException{
	List<Cita> citas = new ArrayList<>();
	try {
		conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
		statement = conect.createStatement();
		String query = "SELECT * FROM citas WHERE " + campo + " LIKE '" + variable + "%' OR " + campo + " LIKE '%" + variable + "'";
        ResultSet resultSet = statement.executeQuery(query);
		
        while (resultSet.next()) {
            String fecha = resultSet.getString("Fecha");
            String especialidad = resultSet.getString("Especialidad");
            String dni_paciente = resultSet.getString("DNI_paciente");
            

            Cita class_cita = new Cita(fecha, especialidad, dni_paciente, "");

            citas.add(class_cita);
        }

    } catch (SQLException ex) {
        ex.printStackTrace();
    } finally {
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

    return citas;
	
}

public List<Cita> filtrar_tabla_historial_citas(String campo, String variable) throws SQLException{
	List<Cita> citas = new ArrayList<>();
	try {
		conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
		statement = conect.createStatement();
		String query = "SELECT * FROM citas WHERE " + campo + " LIKE '" + variable + "%' OR " + campo + " LIKE '%" + variable + "'";
        ResultSet resultSet = statement.executeQuery(query);
		
        while (resultSet.next()) {
            String fecha = resultSet.getString("Fecha");
            String especialidad = resultSet.getString("Especialidad");
            String dni_paciente = resultSet.getString("DNI_paciente");
            

            Cita class_cita = new Cita(fecha, especialidad, dni_paciente, "");

            citas.add(class_cita);
        }

    } catch (SQLException ex) {
        ex.printStackTrace();
    } finally {
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

    return citas;
	
}

public List<Cita> filtrar_tabla_eliminar_citas(String campo, String variable) throws SQLException{
	List<Cita> citas = new ArrayList<>();
	try {
		conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
		statement = conect.createStatement();
		String query = "SELECT * FROM citas WHERE " + campo + " LIKE '" + variable + "%' OR " + campo + " LIKE '%" + variable + "'";
        ResultSet resultSet = statement.executeQuery(query);
		
        while (resultSet.next()) {
            String fecha = resultSet.getString("Fecha");
            String especialidad = resultSet.getString("Especialidad");
            String dni_paciente = resultSet.getString("DNI_paciente");
            

            Cita class_cita = new Cita(fecha, especialidad, dni_paciente, "");

            citas.add(class_cita);
        }

    } catch (SQLException ex) {
        ex.printStackTrace();
    } finally {
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

    return citas;
	
}

public List<Cita> filtrar_tabla_editar_citas(String campo, String variable) throws SQLException{
	List<Cita> citas = new ArrayList<>();
	try {
		conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
		statement = conect.createStatement();
		String query = "SELECT * FROM citas WHERE " + campo + " LIKE '" + variable + "%' OR " + campo + " LIKE '%" + variable + "'";
        ResultSet resultSet = statement.executeQuery(query);
		
        while (resultSet.next()) {
            String fecha = resultSet.getString("Fecha");
            String especialidad = resultSet.getString("Especialidad");
            String dni_paciente = resultSet.getString("DNI_paciente");
            

            Cita class_cita = new Cita(fecha, especialidad, dni_paciente, "");

            citas.add(class_cita);
        }

    } catch (SQLException ex) {
        ex.printStackTrace();
    } finally {
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

    return citas;
	
}

public List<Factura> filtrar_tabla_buscar_facturas(String campo, String variable) throws SQLException{
	List<Factura> factura = new ArrayList<>();
	try {
		conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
		statement = conect.createStatement();
		String query = "SELECT * FROM facturacion WHERE " + campo + " LIKE '" + variable + "%' OR " + campo + " LIKE '%" + variable + "'";
        ResultSet resultSet = statement.executeQuery(query);
		
        while (resultSet.next()) {
            String fecha = resultSet.getString("Fecha");
            String Nombre = resultSet.getString("Nombre");
            String Apellidos = resultSet.getString("Apellidos");
            String Por_pagar = resultSet.getString("Por_pagar");
            

            Factura class_factura = new Factura(fecha, Nombre, Apellidos, Por_pagar,"", "", "");

            factura.add(class_factura);
        }

    } catch (SQLException ex) {
        ex.printStackTrace();
    } finally {
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

    return factura;
	
}

public List<Factura> filtrar_tabla_buscar_facturas_nuevas(String campo, String variable) throws SQLException{
	List<Factura> factura = new ArrayList<>();
	try {
		conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
		statement = conect.createStatement();
		String query = "SELECT * FROM facturacion WHERE Pagado = 0 AND Por_pagar = 0 AND (" + campo + " LIKE '" + variable + "%' OR " + campo + " LIKE '%" + variable + "')";
        ResultSet resultSet = statement.executeQuery(query);
		
        while (resultSet.next()) {
            String fecha = resultSet.getString("Fecha");
            String Nombre = resultSet.getString("Nombre");
            String Apellidos = resultSet.getString("Apellidos");
            String Por_pagar = resultSet.getString("Por_pagar");
            

            Factura class_factura = new Factura(fecha, Nombre, Apellidos, Por_pagar,"", "", "");

            factura.add(class_factura);
        }

    } catch (SQLException ex) {
        ex.printStackTrace();
    } finally {
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

    return factura;
	
}

public List<Factura> filtrar_tabla_cobros_facturas(String campo, String variable, String id) throws SQLException{
	List<Factura> factura = new ArrayList<>();
	try {
		conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
		statement = conect.createStatement();
		String query = "SELECT * FROM historial_facturacion WHERE ID_facturacion = '" + id + "' AND (" + campo + " LIKE '" + variable + "%' OR " + campo + " LIKE '%" + variable + "')";
        ResultSet resultSet = statement.executeQuery(query);
		
        while (resultSet.next()) {
            String fecha = resultSet.getString("Fecha");
            String DNI_paciente = resultSet.getString("DNI_paciente");
            String Cobro = resultSet.getString("Cobro");
            String Por_pagar = resultSet.getString("Por_pagar");
            

            Factura class_factura = new Factura(fecha, DNI_paciente, Cobro, Por_pagar);

            factura.add(class_factura);
        }

    } catch (SQLException ex) {
        ex.printStackTrace();
    } finally {
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

    return factura;
	
}


public void insertarOdontograma(int id_diente, String observaciones, int id_paciente) {
    try {
        // Validar que los campos obligatorios no estén vacíos
        if (observaciones == null || observaciones.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error: Observaciones no pueden estar vacías.");
            return;
        }

        conect = DriverManager.getConnection(URL, USUARIO, CLAVE);

        // Obtener el ID del diente a partir del DNI del paciente y el ID del diente

        // Crear la sentencia de inserción
        String query = "INSERT INTO odontograma (id_diente, observaciones, fecha, id_paciente) VALUES (?, ?, ?, ?)";

        // Crear la instancia del PreparedStatement
        try (PreparedStatement preparedStatement = conect.prepareStatement(query)) {
            // Establecer los parámetros en el PreparedStatement
            preparedStatement.setInt(1, id_diente);
            preparedStatement.setString(2, observaciones);

            // Obtener la fecha actual del sistema y convertirla a formato SQL DATE
            Date fechaActual = new Date(System.currentTimeMillis());
            preparedStatement.setDate(3, new java.sql.Date(fechaActual.getTime()));

            preparedStatement.setInt(4, id_paciente);

            // Ejecutar la sentencia de inserción
            int fila = preparedStatement.executeUpdate();

            // Verificar si la inserción se realizó con éxito
            if (fila > 0) {
                System.out.println("Inserción exitosa.");
                JOptionPane.showMessageDialog(null, "Cambios realizados con éxito");
            } else {
                System.out.println("La inserción no tuvo éxito.");
            }
        }

    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}

public List<Integer> mostrarDientes(int id_paciente) {
    List<Integer> listaIdDientes = new ArrayList<>();

    try {
        conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
        // Crear la sentencia SQL para obtener los id_diente asociados a un id_paciente
        String query = "SELECT id_diente FROM odontograma WHERE id_paciente = ?";

        // Crear la instancia del PreparedStatement
        try (PreparedStatement preparedStatement = conect.prepareStatement(query)) {
            // Establecer el parámetro en el PreparedStatement
            preparedStatement.setInt(1, id_paciente);

            // Ejecutar la consulta
            ResultSet resultSet = preparedStatement.executeQuery();

            // Iterar sobre los resultados y agregarlos a la lista
            while (resultSet.next()) {
                int idDiente = resultSet.getInt("id_diente");
                listaIdDientes.add(idDiente);
            }
        }

    } catch (SQLException ex) {
        ex.printStackTrace();
    }

    return listaIdDientes;
}
public void mostarCbCitasPac(jd_mod_consulta datos) throws SQLException {
	// TODO Auto-generated method stub
	conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
    statement = conect.createStatement();
    try {
        String sql = "SELECT Nombre, DNI_paciente FROM pacientes";
        ResultSet rs = statement.executeQuery(sql);

        // Extraer datos del result set
        while (rs.next()) {
            // Obtener el nombre y el DNI de la tabla
            String nombre = rs.getString("Nombre");
            String dni = rs.getString("DNI_paciente");
            
            // Crear una cadena con el nombre y el DNI y agregarla al combo
            String nombreYDNI = nombre + " con DNI: " + dni;
            datos.setCb_paciente(nombreYDNI);
        }
    } finally {
        if (statement != null) {
            statement.close();
        }
    }
}
public void mostarCbCitasDr(jd_mod_consulta datos) throws SQLException {
	// TODO Auto-generated method stub
	conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
    statement = conect.createStatement();
    try {
        String sql = "SELECT Nombre, DNI_doctor FROM doctores";
        ResultSet rs = statement.executeQuery(sql);

        // Extraer datos del result set
        while (rs.next()) {
            // Obtener el nombre de la tabla
        	String nombre = rs.getString("Nombre");
        	String dni = rs.getString("DNI_doctor");
            tablaNombre = nombre+" con DNI: "+dni;
            datos.setCb_doctor(tablaNombre);
        }
    } finally {
        if (statement != null) {
            statement.close();
        }
    }
}
public void mostarCbCitasEsp(jd_mod_consulta datos) throws SQLException {
	// TODO Auto-generated method stub
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

public void actualizarEstadoSolicitud(int idSolicitud, String nuevoEstado) {
    Connection conect = null;
    PreparedStatement preparedStatement = null;

    try {
        conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
        String query = "UPDATE solicitudes SET Estado = ? WHERE ID_solicitud = ?";
        preparedStatement = conect.prepareStatement(query);
        preparedStatement.setString(1, nuevoEstado);
        preparedStatement.setInt(2, idSolicitud);
        preparedStatement.executeUpdate();
    } catch (SQLException ex) {
        ex.printStackTrace();
    } finally {
        // Cerrar recursos
        try {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (conect != null) {
                conect.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
public List<Proveedores> obtenerProveedores() {
	   List<Proveedores> proveedores = new ArrayList<>();

       try {
           conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
           statement = conect.createStatement();
           String query = "SELECT ID_proveedor, Proveedor, Producto, Precio_producto FROM proveedores";
           ResultSet resultSet = statement.executeQuery(query);

           while (resultSet.next()) {
               int id = resultSet.getInt("ID_proveedor");
               String proveedor = resultSet.getString("Proveedor");
               String producto = resultSet.getString("Producto");
               int precio = resultSet.getInt("Precio_producto");

               Proveedores Proveedores = new Proveedores(id, proveedor, producto, precio);

               proveedores.add(Proveedores);
           }

       } catch (SQLException ex) {
           ex.printStackTrace();
	// TODO Auto-generated method stub
	return proveedores;
}
	return proveedores;

}
public void insertar_proveedor(String proveedor, String precio, String producto) throws SQLException {
	 conect = DriverManager.getConnection(URL, USUARIO, CLAVE);
     
    try {
        int precioParseado = Integer.parseInt(precio);
        // Crear la conexión y preparar la consulta
        String sql = "INSERT INTO proveedores (Proveedor, Precio_producto, Producto) VALUES (?, ?, ?)";
        try (PreparedStatement statement = conect.prepareStatement(sql)) {
            // Establecer los valores en la consulta
            statement.setString(1, proveedor);
            statement.setInt(2, precioParseado);
            statement.setString(3, producto);

            // Ejecutar la consulta
            statement.executeUpdate();
        }
    } catch (NumberFormatException e) {
        e.printStackTrace(); // Manejo de errores al parsear el precio
    } catch (SQLException e) {
        e.printStackTrace(); // Manejo de errores en la ejecución de la consulta SQL
    }
}


}

	
