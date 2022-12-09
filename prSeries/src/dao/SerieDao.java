package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import UtilsDB.DatabaseConnection;
import pojo.Serie;
import pojo.Temporada;

public class SerieDao extends ObjetoDao implements InterfazDao<Serie>{

	private static Connection connection;
	
	public SerieDao() {
		
	}
	
	@Override
    public ArrayList<Serie> buscarTodos() {

        connection = openConnection();

        ArrayList<Serie> series = new ArrayList<Serie>();
        String query = "select * from series";
        Serie serie = null;

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                //Hacemos consulta para coger todas las temporadas de la serie que creamos después:
                ArrayList<Temporada> temporadas = new ArrayList<Temporada>();

                serie = new Serie(rs.getInt("id"), rs.getString("titulo"), rs.getInt("edad"),
                        rs.getString("plataforma"), temporadas);

                String query_temporada = "select * from temporadas where serie_id = ?";
                PreparedStatement ps_temporadas = connection.prepareStatement(query_temporada);
                ps_temporadas.setInt(1, rs.getInt("id")); 
                ResultSet rs_temporadas = ps_temporadas.executeQuery();

                while(rs_temporadas.next()) {
                    Temporada temporada = new Temporada(rs_temporadas.getInt("id"), rs_temporadas.getInt("num_temporada"), rs_temporadas.getString("titulo"));
                    temporadas.add(temporada);
                }

                serie.setTemporadas(temporadas); 
                //En este punto, la serie está completa.
                series.add(serie);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        closeConnection();

        return series;
    }

	@Override
	public Serie buscarPorId(int id) {
		connection = openConnection();

        String query_series = "select * from series where id = ?";
        Serie serie = null;

        try {
        	PreparedStatement ps_series = connection.prepareStatement(query_series);
        	ps_series.setInt(1, id); 
            ResultSet rs_series = ps_series.executeQuery();

            while (rs_series.next()) {
                
                ArrayList<Temporada> temporadas = new ArrayList<Temporada>();

                serie = new Serie(rs_series.getInt("id"), rs_series.getString("titulo"), rs_series.getInt("edad"),
                		rs_series.getString("plataforma"), temporadas);

                String query_temporada = "select * from temporadas where serie_id = ?";
                PreparedStatement ps_temporadas = connection.prepareStatement(query_temporada);
                ps_temporadas.setInt(1, rs_series.getInt("id")); 
                ResultSet rs_temporadas = ps_temporadas.executeQuery();

                while(rs_temporadas.next()) {
                    Temporada temporada = new Temporada(rs_temporadas.getInt("id"), rs_temporadas.getInt("num_temporada"), rs_temporadas.getString("titulo"));
                    temporadas.add(temporada);
                }

                serie.setTemporadas(temporadas); 
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        closeConnection();

        return serie;
	}

	@Override
	public void insertar(Serie serie) {
		connection = openConnection();

        String query = "insert into series(titulo, edad, plataforma) values (?,?,?)";
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
	public void modificar(Serie serie) {
		connection = openConnection();

        String query = "update series set titulo = ?, edad = ?, plataforma = ? where id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, serie.getTitulo());
            ps.setInt(2, serie.getEdad());
            ps.setString(3, serie.getPlataforma());
            ps.setInt(4, serie.getId());
            ps.executeUpdate();
		}catch (SQLException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	}

	public ArrayList<Temporada> obtenerTemporadas(Serie serie){
		
		ArrayList<Temporada> temporadas = new ArrayList<>();
	
		connection = openConnection();
		
		String query = "select * from temporadas where serie_id = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, serie.getId());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Temporada temporada = new Temporada(rs.getInt("id"),
											rs.getInt("num_temporada"),
											rs.getString("titulo"),
											serie);
				temporadas.add(temporada);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		closeConnection();
		
		return temporadas;
	}
	
	@Override
    public void borrar(Serie serie) {
        int serie_id = serie.getId();

        SerieDao serieDao = new SerieDao();
        TemporadaDao temporadaDao = new TemporadaDao();
        temporadaDao.buscarPorId(serie_id);

        connection = openConnection();

        String query = "delete from series where id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, serie_id);
            ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        closeConnection();
    }
}
