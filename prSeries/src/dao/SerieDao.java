package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import UtilsDB.DatabaseConnection;
import pojo.Serie;

public class SerieDao implements Dao<Serie>{

	private static Connection connection;
	
	public SerieDao() {
		
	}
	
	@Override
	public ArrayList<Serie> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Serie buscarPorId(int id) {
		connection = openConnection();
		
		String query = "select * from series where id = ?";
		Serie serie = null;
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet  rs = ps.executeQuery();
			
			while(rs.next()) {
				serie = new Serie(rs.getInt("id"),
										   rs.getString("titulo"),
										   rs.getInt("edad"),
										   rs.getString("plataforma"),
										   null
									);	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		closeConnection();
		
		return serie;
	}

	@Override
	public void insertar(Serie serie) {
		connection = openConnection();

        String query = "insert into series(titulo, edad, platadorma) values (?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, serie.getTitulo());
            ps.setInt(2, serie.getEdad());
            ps.setString(3, serie.getPlataforma());
            ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        closeConnection();
	}

	@Override
	public void modificar(Serie t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void borrar(Serie t) {
		// TODO Auto-generated method stub
		
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
