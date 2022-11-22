package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pojo.Backroom;
import pojo.Entity;

public class EntityDao extends ObjetoDao implements InterfazDao<Entity>{

	private static Connection connection;
	
	@Override
	public ArrayList<Entity> buscarTodos() {
		return null;
		/*ArrayList<Entity> entitys = new ArrayList<>();
		
		connection = openConnection();
		
		String query = "select * from entitys";
	
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Entity entity = new Entity(rs.getString("entityName"),
										   rs.getInt("backroomNum"),
										   rs.getString("dangerousness"),
										   rs.getString("entityDesc")
									);
				entitys.add(entity);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return entitys;*/
	}

	@Override
	public Entity buscarPorId(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertar(Entity t) {
		connection = openConnection();

        String query = "insert into entitys(entityName, backroomNum, dangerousness, entityDesc) values (?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, t.getEntityName());
            ps.setInt(2, t.getBackroom().getLevelNum());
            ps.setString(3, t.getDangerousness());
            ps.setString(4, t.getEntityDesc());
            ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}

	@Override
	public void modificar(Entity t) {
		connection = openConnection();

        String query = "update entitys set backroomNum = ?, dangerousness = ?, entityDesc = ? where entityName = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, t.getBackroom().getLevelNum());
            ps.setString(2, t.getDangerousness());
            ps.setString(3, t.getEntityDesc());
            ps.setString(4, t.getEntityName());
            ps.executeUpdate();
		}catch (SQLException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	}

	@Override
	public void borrar(Entity t) {
		connection = openConnection();

        String query = "delete from entitys where entityName = ?";
        
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, t.getEntityName());
            ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        closeConnection();
		
	}

}
