package main;

import java.util.ArrayList;

import dao.BackroomDao;
import dao.EntityDao;
import pojo.Backroom;
import pojo.Entity;

public class MainProyectFT {

	public static void main(String[] args) {
		//Para insertar una backroom en la base de datos.
		/*Backroom backroom = new Backroom(2,"Backroom 2",10,"Muy Facil");
		BackroomDao backroomDao = new BackroomDao();
		backroomDao.insertar(backroom);*/
		
		//Para ver todas las backrooms de la base de datos.
		/*BackroomDao backroomDao = new BackroomDao();
		ArrayList<Backroom> backrooms = backroomDao.buscarTodos();
		for(Backroom backroom : backrooms) {
			System.out.println(backroom);
		}*/
		
		//PREGUNTAR PORQUE DA ERROR------------------------------------------------------------
		//Para ver las backrooms por id de la base de datos.
		/*BackroomDao backroomDao = new BackroomDao();
		ArrayList<Backroom> backrooms = backroomDao.buscarPorId(1);
		for(Backroom backroom : backrooms) {
			System.out.println(backroom);
		}*/
		
		//Para modificar una backroom ya creada.
		/*Backroom backroom = new Backroom(1,"Backroom 1 Mod",2,"Muy Facil");
		BackroomDao backroomDao = new BackroomDao();
		backroomDao.modificar(backroom);*/
		
		//PENDIENTE POR PROBAR------------------------------------------------------------------
		//Para borrar una backroom.
		/*
		 * 
		 */
		
		//Para insertar una entity en la base de datos.
		/*Backroom backroom = new Backroom(1,"Backroom 1 Mod",2,"Muy Facil");
		Entity entity = new Entity("Smiler",backroom,"Nada Peligroso","Un bicho que sonrie.");
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
		
		//PENDIENTE POR REVISAR, NO FUNCIONA. --------------------------------------------------
		//Para modificar una entity ya creada.
		/*Backroom backroom = new Backroom(1,"Backroom 1 Mod",2,"Muy Facil");
		Entity entity = new Entity("Smiler Mod",backroom,"Peligroso","Un bicho que sonrie.");
		EntityDao entityDao = new EntityDao();
		entityDao.modificar(entity);*/
		
		//PENDIENTE POR PROBAR------------------------------------------------------------------
		//Para borrar una backroom.
		/*Backroom backroom = new Backroom(1,"Backroom 1 Mod",2,"Muy Facil");
		Entity entity = new Entity("Smiler",backroom,"Nada Peligroso","Un bicho que sonrie.");
		EntityDao entityDao = new EntityDao();
		entityDao.borrar(entity);*/
	}

}