package pojo;

public class Entity {
	private String entityName;
	private Backroom backroom;
	private String dangerousness;
	private String entityDesc;
	
	public Entity(String entityName, Backroom backroom, String dangerousness, String entityDesc) {
		super();
		this.entityName = entityName;
		this.backroom = backroom;
		this.dangerousness = dangerousness;
		this.entityDesc = entityDesc;
	}
	
	public Entity(Backroom backroom, String dangerousness, String entityDesc) {
		super();
		this.backroom = backroom;
		this.dangerousness = dangerousness;
		this.entityDesc = entityDesc;
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
		return "Entity [entityName=" + entityName + ", Backroom=" + backroom + ", dangerousness=" + dangerousness
				+ ", entityDesc=" + entityDesc + "]";
	}
}
