package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pojo.Backroom;

public class BackroomDao extends ObjetoDao implements InterfazDao<Backroom>{

	private static Connection connection;
	
	public BackroomDao() {
		
	}
	
	@Override
	public ArrayList<Backroom> buscarTodos() {
		ArrayList<Backroom> backrooms = new ArrayList<>();
		
		connection = openConnection();
		
		String query = "select * from backrooms";
	
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Backroom backroom = new Backroom(rs.getInt("levelNum"),
										   rs.getString("backroomName"),
										   rs.getInt("entitysNum"),
										   rs.getString("difficulty"),
										   null
									);
				backrooms.add(backroom);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return backrooms;
	}

	@Override
	public Backroom buscarPorId(int i) {
		connection = openConnection();
		
		String query = "select * from backrooms where levelNum = ?";
		Backroom backroom = null;
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(query);
			ps.setInt(1, i);
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
	public void borrar(Backroom t) {
		int levelNum = t.getLevelNum();

        BackroomDao backroomDao = new BackroomDao();
        EntityDao entityDao = new EntityDao();
        entityDao.buscarPorId(levelNum);

        connection = openConnection();

        String query = "delete from backrooms where levelNum = ?";
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

}
