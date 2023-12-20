package infrastructure.persistence.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionBD {
	
	
	
	public static Connection getConnection() {
		Connection connection = null;
		String host = "localhost";
		String port = "3306";
		String username = "root";
		String password = "root";
		String namedb = "finalcac23565";
		
		// driver de conexion a la base de datos
		String driveClassName = "com.mysql.cj.jdbc.Driver";
		
		
		
		try {
			Class.forName(driveClassName);
			//url de conexion
			String url = "jdbc:mysql://" + host + ":" + port + "/" + namedb;
			
			connection = DriverManager.getConnection(url, username, password);
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
		return connection;
		
	}
	
	
	
	

}
