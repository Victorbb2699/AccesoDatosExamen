package aed.javafx.conexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Victor Bethencourt Barrera
public class SQLconect {
	
	static Connection con;
	static String url = "jdbc:sqlserver://VICTOR-PC\\SQLEXPRESS; databasename=Direcciondetrafico";
	static String username = "sa_cliente1";
	static String password = "pass";
	
	public static Connection ConectaSQL() {
		
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(url, username, password);

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error");
		}
		return con;
	}
	public String getName() {
		String conexion="SQLServer";
		return conexion;
	}

}
