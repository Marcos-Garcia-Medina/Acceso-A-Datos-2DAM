package pojo;

/**
 * Clase del pojo Entity.
 * @author Marcos Garcia Medina.
 */
public class Entity {
	/**
	 * entityNum: Numero de la entity. (id)
	 */
	private int entityNum;
	/**
	 * entityName: Nombre de la entity.
	 */
	private String entityName;
	/**
	 * backroom: Backroom a la que pertenece la entity.
	 */
	private Backroom backroom;
	/**
	 * dangerousness: Peligrosidad de la entity.
	 */
	private String dangerousness;
	/**
	 * entityDesc: Descripcion de la entity.
	 */
	private String entityDesc;
	
	/**
	 * Constructor de Entity.
	 * @param entityNum Numero de la entity. (id)
	 * @param entityName Nombre de la entity.
	 * @param backroom Backroom a la que pertenece la entity.
	 * @param dangerousness Peligrosidad de la entity.
	 * @param entityDesc  Descripcion de la entity.
	 */
	public Entity(int entityNum, String entityName, Backroom backroom, String dangerousness, String entityDesc) {
		super();
		this.entityNum = entityNum;
		this.entityName = entityName;
		this.backroom = backroom;
		this.dangerousness = dangerousness;
		this.entityDesc = entityDesc;
	}
	
	/**
	 * Constructor de Entity.
	 * @param entityNum Numero de la entity. (id)
	 * @param backroom Backroom a la que pertenece la entity.
	 * @param dangerousness Peligrosidad de la entity.
	 * @param entityDesc  Descripcion de la entity.
	 */
	public Entity(int entityNum, Backroom backroom, String dangerousness, String entityDesc) {
		super();
		this.entityNum = entityNum;
		this.backroom = backroom;
		this.dangerousness = dangerousness;
		this.entityDesc = entityDesc;
	}
	
	/**
	 * Constructor de Entity.
	 * @param entityNum Numero de la entity. (id)
	 * @param entityName Nombre de la entity.
	 * @param dangerousness Peligrosidad de la entity.
	 * @param entityDesc  Descripcion de la entity.
	 */
	public Entity(int entityNum, String entityName, String dangerousness, String entityDesc) {
		super();
		this.entityNum = entityNum;
		this.entityName = entityName;
		this.dangerousness = dangerousness;
		this.entityDesc = entityDesc;
	}
	
	/**
	 * Funcion getEntityNum que obtiene el entityNum de la entity.
	 * @return Devuelve el entityNum de la entity.
	 */
	public int getEntityNum() {
		return entityNum;
	}

	/**
	 * Funcion setEntityNum que pone un entityNum a la entity.
	 * @param entityNum El entityNum.
	 */
	public void setEntityNum(int entityNum) {
		this.entityNum = entityNum;
	}

	/**
	 * Funcion getEntityName que obtiene el entityName de la entity.
	 * @return Devuelve el entityName de la entity.
	 */
	public String getEntityName() {
		return entityName;
	}
	
	/**
	 * Funcion setEntityName que pone un entityName a la entity.
	 * @param entityName El entityName.
	 */
	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}
	
	/**
	 * Funcion getBackroom que obtiene la backroom en la que esta la entity.
	 * @return Devuelve la backroom en la que esta la entity.
	 */
	public Backroom getBackroom() {
		return backroom;
	}
	
	/**
	 * Funcion setBackroom que pone una backroom a la entity.
	 * @param backroom La backroom de la entity.
	 */
	public void setBackroom(Backroom backroom) {
		this.backroom = backroom;
	}
	
	/**
	 * Funcion getDangerousness que obtiene dangerousness de la entity.
	 * @return Devuelve dangerousness de la entity. 
	 */
	public String getDangerousness() {
		return dangerousness;
	}
	
	/**
	 * Funcion setDangerousness que pone dangerousness a la backroom
	 * @param dangerousness La dangerousness de la entity.
	 */
	public void setDangerousness(String dangerousness) {
		this.dangerousness = dangerousness;
	}
	
	/**
	 * Funcion getEntityDesc que obtiene la descripcion de la entity.
	 * @return Devuelve la entityDesc de la entity.  
	 */
	public String getEntityDesc() {
		return entityDesc;
	}
	
	/**
	 * Funcion setEntityDesc que pone entityDesc a la entity.
	 * @param entityDesc La entityDesc.
	 */
	public void setEntityDesc(String entityDesc) {
		this.entityDesc = entityDesc;
	}

	/**
	 * Funcion toString que imprime una entity.
	 */
	@Override
	public String toString() {
		return "Entity [entityNum=" + entityNum + ", entityName=" + entityName +
				 ", dangerousness=" + dangerousness + ", entityDesc=" + entityDesc + "]";
	}
}
