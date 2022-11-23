package main;

import java.util.ArrayList;

import dao.BackroomDao;
import dao.EntityDao;
import pojo.Backroom;
import pojo.Entity;

public class MainProyectFT {

	public static void main(String[] args) {
		//Para insertar una backroom en la base de datos.
		/*Backroom backroom = new Backroom(1,"a",1,"a");
		BackroomDao backroomDao = new BackroomDao();
		backroomDao.insertar(backroom);*/
		
		//Para ver todas las backrooms de la base de datos.
		/*BackroomDao backroomDao = new BackroomDao();
		ArrayList<Backroom> backrooms = backroomDao.buscarTodos();
		for(Backroom backroom : backrooms) {
			System.out.println(backroom);
		}*/
		
		//Para ver las backrooms por id de la base de datos.
		/*BackroomDao backroomDao = new BackroomDao();
		Backroom backroom = backroomDao.buscarPorId(1);
		System.out.println(backroom);*/
		
		//Para modificar una backroom ya creada.
		/*Backroom backroom = new Backroom(1,"Backroom 1 Mod",2,"Muy Facil");
		BackroomDao backroomDao = new BackroomDao();
		backroomDao.modificar(backroom);*/
		
		//NO SE BORRA LA ENTIDAD PERO SI LA BACKROOM--------------------------------------------
		//Para borrar una backroom.
		/*Backroom backroom = new Backroom(1,"a",1,"a");
		BackroomDao backroomDao = new BackroomDao();
		backroomDao.borrar(backroom);*/
		
		//Para insertar una entity en la base de datos.
		/*Backroom backroom = new Backroom(1,"a",1,"a");
		Entity entity = new Entity("z",backroom,"z","z");
		EntityDao entityDao = new EntityDao();
		entityDao.insertar(entity);*/

		//PENDIENTE PARA REVISAR----------------------------------------------------------------
		//Para ver todas las entitys de la base de datos.
		/*EntityDao entityDao = new EntityDao();
		ArrayList<Entity> entitys = entityDao.buscarTodos();
		for(Entity entity : entitys) {
			System.out.println(entity);
		}*/
		
		//PENDIENTE PARA HACER------------------------------------------------------------------
		//Para ver las entitys por nombre de la base de datos.
		/*EntityDao entityDao = new EntityDao();
		ArrayList<Entity> entitys = entityDao.buscarPorId(1);
		for(Entity entity : entitys) {
			System.out.println(entity);
		}*/
		
		//Para modificar una entity ya creada.
		/*Backroom backroom = new Backroom(1,"a",1,"a");
		Entity entity = new Entity("z",backroom,"se ha modificado","se ha modificado");
		EntityDao entityDao = new EntityDao();
		entityDao.modificar(entity);*/

		//Para borrar una entity.
		/*Backroom backroom = new Backroom(1,"a",1,"a");
		Entity entity = new Entity("z",backroom,"z","z");
		EntityDao entityDao = new EntityDao();
		entityDao.borrar(entity);*/
	}
}