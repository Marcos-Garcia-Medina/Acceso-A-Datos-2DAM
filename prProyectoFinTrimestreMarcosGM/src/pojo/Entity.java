package pojo;

public class Entity {
	private int entityNum;
	private String entityName;
	private Backroom backroom;
	private String dangerousness;
	private String entityDesc;
	
	public Entity(int entityNum, String entityName, Backroom backroom, String dangerousness, String entityDesc) {
		super();
		this.entityNum = entityNum;
		this.entityName = entityName;
		this.backroom = backroom;
		this.dangerousness = dangerousness;
		this.entityDesc = entityDesc;
	}
	
	public Entity(int entityNum, Backroom backroom, String dangerousness, String entityDesc) {
		super();
		this.entityNum = entityNum;
		this.backroom = backroom;
		this.dangerousness = dangerousness;
		this.entityDesc = entityDesc;
	}
	
	public Entity(int entityNum, String entityName, String dangerousness, String entityDesc) {
		super();
		this.entityNum = entityNum;
		this.entityName = entityName;
		this.dangerousness = dangerousness;
		this.entityDesc = entityDesc;
	}
	
	public int getEntityNum() {
		return entityNum;
	}

	public void setEntityNum(int entityNum) {
		this.entityNum = entityNum;
	}

	public String getEntityName() {
		return entityName;
	}
	
	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}
	
	public Backroom getBackroom() {
		return backroom;
	}
	
	public void setBackroom(Backroom backroom) {
		this.backroom = backroom;
	}
	
	public String getDangerousness() {
		return dangerousness;
	}
	
	public void setDangerousness(String dangerousness) {
		this.dangerousness = dangerousness;
	}
	
	public String getEntityDesc() {
		return entityDesc;
	}
	
	public void setEntityDesc(String entityDesc) {
		this.entityDesc = entityDesc;
	}

	@Override
	public String toString() {
		return "Entity [entityNum=" + entityNum + ", entityName=" + entityName +
				 ", dangerousness=" + dangerousness + ", entityDesc=" + entityDesc + "]";
	}
}
