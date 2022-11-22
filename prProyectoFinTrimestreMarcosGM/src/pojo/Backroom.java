package pojo;

import java.util.ArrayList;

public class Backroom {
	
	private int levelNum;
	private String backroomName;
	private int entitysNum;
	private String difficulty;
	private ArrayList<Entity> entitys;
	
	public Backroom(int levelNum, String backroomName, int entitysNum, String difficulty, ArrayList<Entity> entitys) {
		super();
		this.levelNum = levelNum;
		this.backroomName = backroomName;
		this.entitysNum = entitysNum;
		this.difficulty = difficulty;
		this.entitys = entitys;
	}
	
	public Backroom(int levelNum, String backroomName, int entitysNum, String difficulty) {
		super();
		this.levelNum = levelNum;
		this.backroomName = backroomName;
		this.entitysNum = entitysNum;
		this.difficulty = difficulty;
	}

	public int getLevelNum() {
		return levelNum;
	}

	public void setLevelNum(int levelNum) {
		this.levelNum = levelNum;
	}

	public String getBackroomName() {
		return backroomName;
	}

	public void setBackroomName(String backroomName) {
		this.backroomName = backroomName;
	}

	public int getEntitysNum() {
		return entitysNum;
	}

	public void setEntitysNum(int entitysNum) {
		this.entitysNum = entitysNum;
	}

	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}

	public ArrayList<Entity> getEntitys() {
		return entitys;
	}

	public void setEntitys(ArrayList<Entity> entitys) {
		this.entitys = entitys;
	}

	@Override
	public String toString() {
		return "Backroom [levelNum=" + levelNum + ", backroomName=" + backroomName + ", entitysNum=" + entitysNum
				+ ", difficulty=" + difficulty + ", entitys=" + entitys + "]";
	}
}
