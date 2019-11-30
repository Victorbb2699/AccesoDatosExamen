package aed.javafx.menu;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import aed.javafx.conexiones.MysqlConect;
import aed.javafx.conexiones.SQLconect;
import aed.javafx.consultas.Logica;

//Victor Bethencourt Barrera

public class Main {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		Connection con = null;

		new MysqlConect();
		con = MysqlConect.conectarMySQL();

		Scanner entrada = new Scanner(System.in);
		int aux = 0;

		while (aux != 5) {
			System.out.println("1.Cambiar base de datos");
			System.out.println("2.Visualizar sanciones");
			System.out.println("3.Modificar importe");
			System.out.println("4.Visualizar cantidad sanciones");
			System.out.println("5.Salir");
			System.out.println("Introduce una opción:");

			aux = entrada.nextInt();

			switch (aux) {
			case 1:
				System.out.println("1.MySQL");
				System.out.println("2.SQLServer");
				aux = entrada.nextInt();
				if (aux == 1) {
					con = MysqlConect.conectarMySQL();
					System.out.println("Conectado en MySql");
				}
				if (aux == 2) {
					con = SQLconect.ConectaSQL();
					System.out.println("Conectado en SQLServer");
				}

				break;
			case 2:
				System.out.println("Introduce importe");
				Logica.visualizarSanciones(entrada.next(), con);
				break;
			case 3:
				System.out.println("Introduce Importe, id");
				int importeNew = entrada.nextInt();
				int id = entrada.nextInt();
				Logica.modificarImporte(con, importeNew, id);
				break;
			case 4:
				System.out.println("Introduce matricula");
				Logica.visualizarCantidadSanciones(entrada.next(), con);
				break;
			case 5:
				System.out.println("Saliendo");
				break;

			default:
				System.out.println("Opción no válida");
				break;
			}
		}
		entrada.close();
	}

}
