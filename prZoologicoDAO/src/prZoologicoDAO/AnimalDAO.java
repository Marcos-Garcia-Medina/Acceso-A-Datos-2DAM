package prZoologicoDAO;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class AnimalDAO{
	
	private static Connection connection;
	
	public static void insertAnimal(Animal animal) {
		try {
			connection = openConnection();
			String query = "insert into animales (nombre,peso_aproximado,habitat) values(?, ?, ?)";
			
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, animal.getNombre());
			preparedStatement.setDouble(2, animal.getPeso_aproximado());
			preparedStatement.setString(3, animal.getHabitat());
			
			preparedStatement.execute();
			
			closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void deleteAnimal() {
		connection = openConnection();
		String query = "delete from animales";
		
		try {
			Statement statement = (Statement) connection.createStatement();
			statement.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static Connection openConnection() {
		DatabaseConnection dbConnection = new DatabaseConnection();
		connection = dbConnection.getConnection();
		return connection;
	}
	
	private static void closeConnection() {
		try {
			connection.close();
			connection = null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
