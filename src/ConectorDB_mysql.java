import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


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
                //valor_rol = resultSet.getString("Rol");
                
            } else {
                // Acceso denegado
                System.out.println("No se ha encontrado nada");
            }
			
			
		}
		catch(SQLException ex) {
			
		}
		return dni;
		
	}
	
}