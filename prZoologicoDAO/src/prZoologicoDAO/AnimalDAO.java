package prZoologicoDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
	
	//Borrar todos los animales.
	public static void deleteAllAnimales() {
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
	
	public static void deleteAnimalByNombre(String nombre) {
		connection = openConnection();
		String query = "delete from animales where nombre=?";
		
		PreparedStatement statement;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, nombre);
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		closeConnection();
	}
	
	public static Animal findById(int id) {
		connection = openConnection();
		
		String query = "select * from animales where id = ?";
		Animal animal = null;
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet  rs = ps.executeQuery();
			
			while(rs.next()) {
				animal = new Animal(rs.getInt("id"),
										   rs.getString("nombre"),
										   rs.getDouble("peso_aproximado"),
										   rs.getString("habitat")
									);	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		closeConnection();
		
		return animal;
	}
	
	public static ArrayList<Animal> findAllAnimales(){
		connection = openConnection();
		
		ArrayList<Animal> animales = new ArrayList<>();
		
		String query = "select * from animales";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			Animal animal;
			while(rs.next()) {
				animal = new Animal(rs.getInt("id"),
						   rs.getString("nombre"),
						   rs.getDouble("peso_aproximado"),
						   rs.getString("habitat")
					);
				animales.add(animal);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		closeConnection();
		return animales;
		
	}
	
	public static void updateAnimal(Animal animal){
		connection = openConnection();
		
		String query = "update animales set nombre = ?, peso_aproximado = ?, habitat = ? where id = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setString(1, animal.getNombre());
			ps.setDouble(2, animal.getPeso_aproximado());
			ps.setString(3, animal.getHabitat());
			ps.setInt(4, animal.getId());	
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		closeConnection();
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
