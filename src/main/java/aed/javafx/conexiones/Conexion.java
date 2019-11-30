package aed.javafx.conexiones;

import java.sql.Connection;

public class Conexion {

	public static Connection con;

	public Conexion(String db) {

		switch (db) {
		case "SQLServer":
			SQLconect.ConectaSQL();
			break;
		case "Mysql":
			MysqlConect.conectarMySQL();
			break;
		default:
			break;
		}

	}
	
	
	public String getdb() {

		String db = "";
		db = "MySql";

		return db;
	}

}
