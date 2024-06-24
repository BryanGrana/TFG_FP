package tfg.bryan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	private static Connection conexion;

	private static String ip;

	public static int conectar(String url, String puerto, String usuario, String bd, String clave) {

		ip = url;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			System.out.println("jdbc:mysql://" + url + ":" + puerto + "/" + bd + "?serverTimezone=UTC");
			conexion = DriverManager.getConnection(
					"jdbc:mysql://" + url + ":" + puerto + "/" + bd + "?serverTimezone=UTC", usuario, clave);

			return 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return -2;
		}
	}

	public static String getIp() {
		return ip;
	}

	public static Connection getConexion() {
		return conexion;
	}

	public static int cerrarConexion() {
		if (conexion != null) {
			try {
				conexion.close();
				return 1;
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Error al cerrar la conexión.");
				return -1;
			}
		} else {
			System.out.println("No hay conexión abierta para cerrar.");
			return -2;
		}
	}

}
