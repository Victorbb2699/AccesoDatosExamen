package aed.javafx.conexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Victor Bethencourt Barrera

public class MysqlConect {

	public static String driver = "com.mysql.jdbc.Driver";
	public static String database = "direcciondetrafico";
	public static String hostname = "localhost";
	public static String port = "3306";
	public static Connection conmysql;
	public static Connection con;
	
	// Ruta de nuestra base de datos (desactivamos el uso de SSL con
	// "?useSSL=false")
	public static String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?useSSL=false";

	// Nombre de usuario
	public static String username = "root";

	// Clave de usuario
	public static String password = "";

	public static Connection conectarMySQL() {
		try {
			Class.forName(driver);
			conmysql = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return conmysql;
	}
	public static Connection getCon() {
		Connection a = conectarMySQL();
		return a;
	}
	public static void MySqlClose() {
		try {
			if(!getCon().isClosed()) {
				con.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getName() {
		String conexion="MySql";
		return conexion;
	}
	

}
