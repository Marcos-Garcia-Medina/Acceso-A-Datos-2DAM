package main;

import java.util.ArrayList;


import dao.BackroomDao;
import dao.EntityDao;
import pojo.Backroom;
import pojo.Entity;
/**
 *  Clase main para ejecutar el programa.
 * @author Marcos Garcia Medina.
 */
public class MainProyectFT {
	
	/**
	 * Funcion main que ejecutara todas las funciones de una vez, para que se haga en la BBDD
	 * lo propuesto.
	 * @param Los argumentos.
	 */
	public static void main(String[] args) {
		BackroomDao backroomDao = new BackroomDao();
		EntityDao entityDao = new EntityDao();
		
		Backroom backroomNueva1 = new Backroom(1,"Backroom 1",1,"Facil");
		backroomDao.insertar(backroomNueva1);
		System.out.println("Backroom 1 creada.");
		
		Backroom backroomNueva2 = new Backroom(2,"Backroom 2",1,"Medio");
		backroomDao.insertar(backroomNueva2);
		System.out.println("Backroom 2 creada.");

		Entity entityNueva1 = new Entity(1,"Slipper",backroomNueva1,"Neutro","Duerme mucho.");
		entityDao.insertar(entityNueva1);
		System.out.println("Entity 1 creada.");
		
		Entity entityNueva2 = new Entity(2,"Slipper v2",backroomNueva2,"Hostil","No duerme tanto.");
		entityDao.insertar(entityNueva2);
		System.out.println("Entity 2 creada.");
		
		System.out.println("---------------------------------------------------------");
		System.out.println("TODAS LAS BACKROOMS:");
		ArrayList<Backroom> backrooms = backroomDao.buscarTodos();
		for(Backroom backroomiAImprimir1 : backrooms) {
			System.out.println(backroomiAImprimir1);
		}
		System.out.println("---------------------------------------------------------");
		
		System.out.println("BACKROOM POR ID/levelNum. (1, en este caso)");
		System.out.println(backroomDao.buscarPorId(1));
		System.out.println("---------------------------------------------------------");
		
		System.out.println("BACKROOM POR NOMBRE/backroomName. (Backroom 1, en este caso)");
		System.out.println(backroomDao.buscarPorNombre("Backroom 1"));
		System.out.println("---------------------------------------------------------");
		
		System.out.println("TODAS LAS ENTITYS:");
		ArrayList<Entity> entitys = entityDao.buscarTodos();
		for(Entity entitysiAImpirimir1 : entitys) {
			System.out.println(entitysiAImpirimir1);
		}
		System.out.println("---------------------------------------------------------");
				
		System.out.println("ENTITYS POR ID/entityNum. (2, en este caso)");
		System.out.println(entityDao.buscarPorId(2));
		System.out.println("---------------------------------------------------------");
		
		System.out.println("MODIFICAR BACKROOM. (Modificaremos la backroom 1, por ejemplo.)");
		Backroom backroomAModificar = new Backroom(1,"Backroom 1 Mod",1,"Muy Facil");
		System.out.println("Backroom Ahora: "+ backroomDao.buscarPorId(1));
		backroomDao.modificar(backroomAModificar);
		System.out.println("Backroom Tras Modificar: " + backroomAModificar);
		System.out.println("---------------------------------------------------------");
		
		System.out.println("MODIFICAR ENTITY. (Modificaremos la entity 1, por ejemplo.)");
		Entity entityAModificar= new Entity(1,"Slipper Mod",backroomAModificar,"Neutro Mod","Duerme mucho (o no).");
		System.out.println("Entity Ahora: "+ entityDao.buscarPorId(1));
		entityDao.modificar(entityAModificar);
		System.out.println("Entity Tras Modificar: " + entityAModificar);
		System.out.println("---------------------------------------------------------");

		System.out.println("Borramos la Entity 1.");
		Entity entityABorrar1 = new Entity(1,"Slipper Mod",backroomAModificar,"Neutro Mod","Duerme mucho (o no).");
		entityDao.borrar(entityABorrar1);

		System.out.println("Borramos la Backroom 1 y sus entidades, si es que tiene.");
		Backroom backroomABorrar1 = new Backroom(1,"Backroom 1 Mod",1,"Muy Facil");
		backroomDao.borrar(backroomABorrar1);

		System.out.println("Borramos la Backroom 2 y sus entidades, si es que tiene.");
		Backroom backroomABorrar2 = new Backroom(2,"Backroom 2",1,"Medio");
		backroomDao.borrar(backroomABorrar2);

	}
}