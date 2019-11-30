package aed.javafx.consultas;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

//Victor Bethencourt Barrera

public class Logica {

	public static void visualizarSanciones(String impor, Connection con) {

		try {

			PreparedStatement visualiza = con.prepareStatement("select * from sanciones where importe > " + impor + "");

			ResultSet resultado = visualiza.executeQuery();

			while (resultado.next()) {

				String id = resultado.getString(1);
				String importe = resultado.getString(2);
				String matricula = resultado.getString(3);
				String pago = resultado.getString(4);
				String sancion = resultado.getString(5);
				String tipo = resultado.getString(6);

				System.out.println(id + "," + importe + "," + matricula + "," + pago + "," + sancion + "," + tipo);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void modificarImporte(Connection con, int importeNew, Integer id) throws SQLException {

		PreparedStatement existeS = con.prepareStatement("select importe from sanciones where id = " + id + "");
		ResultSet result = existeS.executeQuery();

		PreparedStatement modificar = con.prepareStatement("update sanciones set importe = ? where id = ?");

		if (!result.next()) {
			System.out.println("Sancion inexistente");
		} else if (Integer.parseInt(result.getString(1)) < importeNew) {
			System.out.println("Aumento de importe");
			modificar.setInt(1, importeNew);
			modificar.setInt(2, id);
		} else if (Integer.parseInt(result.getString(1)) > importeNew) {
			System.out.println("Disminucion de importe");
			modificar.setInt(1, importeNew);
			modificar.setInt(2, id);
		} else if (Integer.parseInt(result.getString(1)) == importeNew) {
			System.out.println("Importe no realizado");

		}

		con.close();

	}

	public static void visualizarCantidadSanciones(String matricula, Connection con) throws SQLException {

		CallableStatement funcion = con.prepareCall("{?=Call f_sancionesporvehiculo(?)}");

		funcion.registerOutParameter(1, Types.INTEGER);
		funcion.setString(2, matricula);

		funcion.execute();

		System.out.println("Sanciones del vehiculo: " + funcion.getInt(1));
		con.close();
	}
}
