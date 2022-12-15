package pojo;

import java.util.ArrayList;
/**
 * Clase del pojo Backroom.
 * @author Marcos Garcia Medina.
 */
public class Backroom {
	
	/**
	 * levelNumber: Numero de la backroom.
	 */
	private int levelNum;
	/**
	 * backroomName: Nombre de la backroom.
	 */
	private String backroomName;
	/**
	 * entitysNumber: Numero de entidades de la backrooom.
	 */
	private int entitysNum;
	/**
	 * difficulty: Dificultad de las backroom.
	 */
	private String difficulty;
	/**
	 * entitys: ArrayList de las entidades que tiene la backroom.
	 */
	private ArrayList<Entity> entitys;
	
	/**
	 * Constuctor del Objeto backroom.
	 * @param levelNumber Numero de la backroom.
	 * @param backroomName Nombre de la backroom.
	 * @param entitysNumber Numero de entidades de la backrooom.
	 * @param difficulty Dificultad de las backroom.
	 * @param entitys ArrayList de las entidades que tiene la backroom.
	 */
	public Backroom(int levelNum, String backroomName, int entitysNum, String difficulty, ArrayList<Entity> entitys) {
		super();
		this.levelNum = levelNum;
		this.backroomName = backroomName;
		this.entitysNum = entitysNum;
		this.difficulty = difficulty;
		this.entitys = entitys;
	}
	
	/**
	 * Constuctor del Objeto backroom.
	 * @param levelNumber Numero de la backroom.
	 * @param backroomName Nombre de la backroom.
	 * @param entitysNumber Numero de entidades de la backrooom.
	 * @param difficulty Dificultad de las backroom.
	 */
	public Backroom(int levelNum, String backroomName, int entitysNum, String difficulty) {
		super();
		this.levelNum = levelNum;
		this.backroomName = backroomName;
		this.entitysNum = entitysNum;
		this.difficulty = difficulty;
	}

	/**
	 * Funcion getLevelNum para obtener el levelNumber.
	 * @return Devuelve el levelNumber.
	 */
	public int getLevelNum() {
		return levelNum;
	}

	/**
	 * Funcion setLevelNum para poner un levelNumber.
	 * @param levelNumber El nuevo levelNumber.
	 */
	public void setLevelNum(int levelNum) {
		this.levelNum = levelNum;
	}

	/**
	 * Funcion getBackroomName para obtener el backroomName.
	 * @return Devuelve el backroomName.
	 */
	public String getBackroomName() {
		return backroomName;
	}

	/**
	 * Funcion setBackroomName para poner un backroomName.
	 * @param backroomName El nuevo backroomName.
	 */
	public void setBackroomName(String backroomName) {
		this.backroomName = backroomName;
	}

	/**
	 * Funcion getEntitysNumb para obtener el entitysNumber.
	 * @return Devuelve el entitysNumber.
	 */
	public int getEntitysNum() {
		return entitysNum;
	}

	/**
	 * Funcion setEntitysNum para poner un entitysNumber.
	 * @param entitysNumber El nuevo entitysNumber.
	 */
	public void setEntitysNum(int entitysNum) {
		this.entitysNum = entitysNum;
	}

	/**
	 * Funcion getDifficulty para obtener el difficulty.
	 * @return Devuelve el difficulty.
	 */
	public String getDifficulty() {
		return difficulty;
	}

	/**
	 * Funcion setDifficulty para poner un difficulty.
	 * @param difficulty El nuevo difficulty.
	 */
	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}

	/**
	 * Funcion getEntitys para obtener todas las entitys de la backroom.
	 * @return entitys El arraylist con las entitys.
	 */
	public ArrayList<Entity> getEntitys() {
		return entitys;
	}

	/**
	 * Funcion setEntitys para guardar las entidades de la backroom.
	 * @param entitys El arraylist que guardaremos.
	 */
	public void setEntitys(ArrayList<Entity> entitys) {
		this.entitys = entitys;
	}

	/**
	 * Funcion toString que imprime una Backroom.
	 */
	@Override
	public String toString() {
		return "Backroom [levelNum=" + levelNum + ", backroomName=" + backroomName + ", entitysNum=" + entitysNum
				+ ", difficulty=" + difficulty;
	}
}
