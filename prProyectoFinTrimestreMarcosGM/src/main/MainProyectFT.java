package main;

import java.util.ArrayList;

import dao.BackroomDao;
import dao.EntityDao;
import pojo.Backroom;
import pojo.Entity;

public class MainProyectFT {

	public static void main(String[] args) {
		
		BackroomDao backroomDao = new BackroomDao();
		EntityDao entityDao = new EntityDao();
		
		//Para insertar una backroom en la base de datos.
		Backroom backroomNueva1 = new Backroom(1,"Backroom 1",1,"Facil");
		backroomDao.insertar(backroomNueva1);
		
		//Para insertar una backroom en la base de datos.
		Backroom backroomNueva2 = new Backroom(2,"Backroom 2",1,"Medio");
		backroomDao.insertar(backroomNueva2);
		
		//Para insertar una entity en la base de datos.
		Entity entityNueva1 = new Entity(1,"Slipper",backroomNueva1,"Neutro","Duerme mucho.");
		entityDao.insertar(entityNueva1);
		
		//Para insertar una entity en la base de datos.
		Entity entityNueva2 = new Entity(2,"Slipper v2",backroomNueva2,"Hostil","No duerme tanto.");
		entityDao.insertar(entityNueva2);
		
		//Para ver todas las backrooms de la base de datos.
		ArrayList<Backroom> backrooms = backroomDao.buscarTodos();
		for(Backroom backroomiAImprimir1 : backrooms) {
			System.out.println(backroomiAImprimir1);
		}
		
		//Para ver las backrooms por id de la base de datos.
		System.out.println(backroomDao.buscarPorId(1));
		
		//Para buscar una backroom por nombre.
		System.out.println(backroomDao.buscarPorNombre("Backroom 1"));
		
		//Para ver todas las entitys de la base de datos.
		ArrayList<Entity> entitys = entityDao.buscarTodos();
		for(Entity entitysiAImpirimir1 : entitys) {
			System.out.println(entitysiAImpirimir1);
		}
				
		//Para ver las entitys por id de la base de datos.
		System.out.println(entityDao.buscarPorId(2));
		
		//Para modificar una backroom ya creada.
		Backroom backroomAModificar = new Backroom(1,"Backroom 1 Mod",1,"Muy Facil");
		backroomDao.modificar(backroomAModificar);
		
		//Para modificar una entity ya creada.
		Entity entityAModificar= new Entity(1,"Slipper Mod",backroomAModificar,"Neutro Mod","Duerme mucho (o no).");
		entityDao.modificar(entityAModificar);
		
		//Para borrar una entity.
		Entity entity = new Entity(1,"Slipper Mod",backroomAModificar,"Neutro Mod","Duerme mucho (o no).");
		entityDao.borrar(entity);
		
		//Para borrar una entity.
		Entity entity2 = new Entity(2,"Slipper v2",backroomNueva2,"Hostil","No duerme tanto.");
		entityDao.borrar(entity2);
		
		//Para borrar una backroom.
		Backroom backroom = new Backroom(1,"Backroom 1 Mod",1,"Muy Facil");
		backroomDao.borrar(backroom);
		
		//Para borrar una backroom.
		Backroom backroom2 = new Backroom(2,"Backroom 2",1,"Medio");
		backroomDao.borrar(backroom2);

	}
}