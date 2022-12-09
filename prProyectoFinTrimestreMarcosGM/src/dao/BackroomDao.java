package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import pojo.Backroom;
import pojo.Entity;

public class BackroomDao extends ObjetoDao implements InterfazDao<Backroom>{

	private static Connection connection;
	
	public BackroomDao() {
		
	}

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

	@Override
	public void borrar(Backroom backroom) {
		int levelNum = backroom.getLevelNum();
		
		EntityDao entityDao = new EntityDao();
		entityDao.borrarPorBackroom(levelNum); 
		
		connection = openConnection();
		
		String query = "delete from backrooms WHERE levelNum = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, levelNum); 
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
	}

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
