package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import pojo.Backroom;
import pojo.Entity;

/**
 * Clase BackroomDao, con todas las funciones a usar sobre las backrooms.
 * @author Marcos Garcia Medina.
 */
public class BackroomDao extends ObjetoDao implements InterfazDao<Backroom>{

	/**
	 * connection: Objeto connecion que nos servira para conectarnos a la base de datos.
	 */
	private static Connection connection;
	
	/**
	 * Constructor vacio de BackroomDao.
	 */
	public BackroomDao() {
		
	}

	/**
	 * Funcion buscarTodos que nos imprime todas las backroom de la base de datos.
	 */
	public ArrayList<Backroom> buscarTodos() {
        connection = openConnection();

        ArrayList<Backroom> backrooms = new ArrayList<Backroom>();
        String query = "select * from backrooms";
        Backroom backroom = null;

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                ArrayList<Entity> entitys = new ArrayList<Entity>();

                backroom = new Backroom(
                		rs.getInt("levelNum"),
						rs.getString("backroomName"),
						rs.getInt("entitysNum"),
						rs.getString("difficulty"),
						null);	

                String query_entity = "select * from entitys where backroomNum = ?";
                PreparedStatement ps_entitys = connection.prepareStatement(query_entity);
                ps_entitys.setInt(1, rs.getInt("levelNum")); 
                ResultSet rs_entitys = ps_entitys.executeQuery();

                while(rs_entitys.next()) {
                	Entity entity = new Entity(
                			rs_entitys.getInt("entityNum"),
                			rs_entitys.getString("entityName"),
							rs_entitys.getString("dangerousness"),
							rs_entitys.getString("entityDesc"));
                    entitys.add(entity);
                }

                backroom.setEntitys(entitys); 
                
                backrooms.add(backroom);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        closeConnection();

        return backrooms;
    }
	
	/**
	 * Funcion buscarPorId que nos imprime la backroom que tenga el id/levelNum que le decimos por
	 * parametros.
	 * @param i El levelNum/id de la backroom a buscar.
	 */
	@Override
	public Backroom buscarPorId(int i) {
		connection = openConnection();

        String query_backrooms = "select * from backrooms where levelNum = ?";
        Backroom backroom = null;

        try {
        	PreparedStatement ps_backrooms = connection.prepareStatement(query_backrooms);
        	ps_backrooms.setInt(1, i); 
            ResultSet rs_backrooms = ps_backrooms.executeQuery();

            while (rs_backrooms.next()) {
                
                ArrayList<Entity> entitys = new ArrayList<Entity>();

                backroom = new Backroom(
                		rs_backrooms.getInt("levelNum"), 
                		rs_backrooms.getString("backroomName"), 
                		rs_backrooms.getInt("entitysNum"),
                		rs_backrooms.getString("difficulty"), 
                		entitys);

                String query_entitys = "select * from entitys where backroomNum = ?";
                PreparedStatement ps_entitys = connection.prepareStatement(query_entitys);
                ps_entitys.setInt(1, rs_backrooms.getInt("levelNum")); 
                ResultSet rs_entitys = ps_entitys.executeQuery();

                while(rs_entitys.next()) {
                    Entity entity = new Entity(rs_entitys.getInt("entityNum"),rs_entitys.getString("entityName"), rs_entitys.getString("dangerousness"), rs_entitys.getString("entityDesc"));
                    entitys.add(entity);
                }

                backroom.setEntitys(entitys); 
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        closeConnection();

        return backroom;
	}

	/**
	 * Funcion que nos inserta una backroom en la base de datos.
	 * @param t Objeto backroom del cual insertaremos los datos en la base de datos.
	 */
	@Override
	public void insertar(Backroom t) {
		connection = openConnection();

        String query = "insert into backrooms(levelNum, backroomName, entitysNum, difficulty) values (?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, t.getLevelNum());
            ps.setString(2, t.getBackroomName());
            ps.setInt(3, t.getEntitysNum());
            ps.setString(4, t.getDifficulty());
            ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        closeConnection();
	}

	/**
	 * Funcion modificar que nos modifica la backroom que le pasemos por parametros.
	 * @param t Objeto backroom a modificar.
	 */
	@Override
	public void modificar(Backroom t) {
		connection = openConnection();

        String query = "update backrooms set backroomName = ?, entitysNum = ?, difficulty = ? where levelNum = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, t.getBackroomName());
            ps.setInt(2, t.getEntitysNum());
            ps.setString(3, t.getDifficulty());
            ps.setInt(4, t.getLevelNum());
            ps.executeUpdate();
		}catch (SQLException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	}

	/**
	 * Funcion borrar que nos borra la backroom que le digamos por parametros.
	 * Si esta tiene entitys, se borraran antes.
	 * @param backroom La backroom a borrar.
	 */
	@Override
	public void borrar(Backroom backroom) {
		int levelNum = backroom.getLevelNum();
		
		EntityDao entityDao = new EntityDao();
		entityDao.borrarPorBackroom(levelNum); 
		
		connection = openConnection();
		
		String query = "delete from backrooms WHERE levelNum = ?";
		
		try {
			entityDao.borrarPorBackroom(backroom.getLevelNum());
			
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, levelNum); 
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Funcion buscarPorNombre que nos busca la backroom que queramos por nombre.
	 * @param i El nombre de la backroom que buscaremos.
	 * @return El objeto backroom que queriamos.
	 */
	public Backroom buscarPorNombre(String i) {
		connection = openConnection();
		
		String query = "select * from backrooms where backroomName = ?";
		Backroom backroom = null;
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(query);
			ps.setString(1, i);
			ResultSet  rs = ps.executeQuery();
			
			while(rs.next()) {
				backroom = new Backroom(rs.getInt("levelNum"),
									rs.getString("backroomName"),
									rs.getInt("entitysNum"),
									rs.getString("difficulty"),
									null);	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		closeConnection();
		
		return backroom;
	}
	
	

}
