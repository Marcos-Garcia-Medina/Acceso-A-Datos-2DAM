package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pojo.Backroom;
import pojo.Entity;

/**
 * Clase EntityDao, con todas las funciones a usar sobre las entitys.
 * @author Marcos Garcia Medina.
 */
public class EntityDao extends ObjetoDao implements InterfazDao<Entity>{

	/**
	 * connection: Objeto connecion que nos servira para conectarnos a la base de datos.
	 */
	private static Connection connection;
	
	/**
	 * Funcion buscarTodos que nos imprime todas las entitys de la base de datos.
	 */
	@Override
	public ArrayList<Entity> buscarTodos() {
		ArrayList<Entity> entitys = new ArrayList<>();
		
		connection = openConnection();
		
		String query = "select * from entitys";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Entity entity = new Entity(rs.getInt("entityNum"),
						rs.getString("entityName"),
						null,
						rs.getString("dangerousness"),
						rs.getString("entityDesc"));
				
				 String query_backroom = "select * from backrooms where levelNum = ?";
	             PreparedStatement ps_backrooms = connection.prepareStatement(query_backroom);
	             ps_backrooms.setInt(1, rs.getInt("backroomNum")); 
	             ResultSet rs_backroom = ps_backrooms.executeQuery();
	             
	             while(rs_backroom.next()) {
	            	 
	            	Backroom backroom = new Backroom(rs_backroom.getInt("levelNum"),
	            			rs_backroom.getString("backroomName"),
	            			rs_backroom.getInt("entitysNum"),
	            			rs_backroom.getString("difficulty"));
	 						
	            	 if(rs_backroom.getInt("levelNum") == rs.getInt("backroomNum")) {
	            		 entity.setBackroom(backroom);
	            	 }
	             }
	             
	             entitys.add(entity);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return entitys;		
	}

	/**
	 * Funcion buscarPorId que nos imprime la entity que tenga el id/entityNum que le decimos por
	 * parametros.
	 * @param i El entityNum/id de la entity a buscar.
	 */
	@Override
	public Entity buscarPorId(int i) {
		Entity entity = null;
		
		connection = openConnection();
		
		String query = "select * from entitys where entityNum = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, i); 
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				entity = new Entity(rs.getInt("entityNum"),
						rs.getString("entityName"),
						null,
						rs.getString("dangerousness"),
						rs.getString("entityDesc"));
			
				String query_backroom = "select * from backrooms where levelNum = ?";
		        PreparedStatement ps_backrooms = connection.prepareStatement(query_backroom);
		        ps_backrooms.setInt(1, rs.getInt("backroomNum")); 
		        ResultSet rs_backroom = ps_backrooms.executeQuery();
		             
		        while(rs_backroom.next()) { 
		        	Backroom backroom = new Backroom(rs_backroom.getInt("levelNum"),
		        			rs_backroom.getString("backroomName"),
		            		rs_backroom.getInt("entitysNum"),
		            		rs_backroom.getString("difficulty"));
		 						
		            if(rs_backroom.getInt("levelNum") == rs.getInt("backroomNum")) {
		            	entity.setBackroom(backroom);
		            }
		        }	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return entity;		
	}

	/**
	 * Funcion que nos inserta una entity en la base de datos.
	 * @param t Objeto entity del cual insertaremos los datos en la base de datos.
	 */
	@Override
	public void insertar(Entity t) {
		connection = openConnection();

        String query = "insert into entitys(entityNum, entityName, backroomNum, dangerousness, entityDesc) values (?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, t.getEntityNum());
            ps.setString(2, t.getEntityName());
            ps.setInt(3, t.getBackroom().getLevelNum());
            ps.setString(4, t.getDangerousness());
            ps.setString(5, t.getEntityDesc());
            ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}

	/**
	 * Funcion modificar que nos modifica la entity que le pasemos por parametros.
	 * @param t Objeto entity a modificar.
	 */
	@Override
	public void modificar(Entity t) {
		connection = openConnection();

        String query = "update entitys set entityNum = ?, entityName = ?, backroomNum = ?, dangerousness = ?, entityDesc = ? where entityNum = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, t.getEntityNum());
            ps.setString(2, t.getEntityName());
            ps.setInt(3, t.getBackroom().getLevelNum());
            ps.setString(4, t.getDangerousness());
            ps.setString(5, t.getEntityDesc());
            ps.setInt(6, t.getEntityNum());
            ps.executeUpdate();
		}catch (SQLException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	}

	/**
	 * Funcion borrar que nos borra la entity que queramos.
	 * @param t Entity a borrar.
	 */
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
	
	/**
	 * Funcion borrarPorBackroom que borra todas las entitys de una backroom.
	 * @param levelNum El id/levelNum de la backroom de la cual borraremos las entidades.
	 */
	public void borrarPorBackroom (int levelNum) {
		connection = openConnection();
		
		String query = "delete from entitys where backroomNum = ?";
		
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
