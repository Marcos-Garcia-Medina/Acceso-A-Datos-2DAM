package dao;

import java.sql.Connection;
import java.sql.SQLException;

import UtilsDB.DatabaseConnection;
/**
 * Clase que realiza y cierra la conexion con la base de datos.
 * @author Marcos Garcia Medina.
 *
 */
public class ObjetoDao {
	/**
	 * connection: El objeto con la informacion de la base de datos con la que
	 * interactuaremos.
	 */
	private static Connection connection;
	
	/**
	 * Funcion que abre la conexion con la base de datos.
	 * @return El objeto connection.
	 */
	protected static Connection openConnection() {
		DatabaseConnection dbConnection = new DatabaseConnection();
		connection = dbConnection.getConnection();
		return connection;
	}
	
	/**
	 * Funcion que cierra la conexion con la base de datos.
	 */
	protected static void closeConnection() {
		try {
			connection.close();
			connection = null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
