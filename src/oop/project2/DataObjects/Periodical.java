package oop.project2.DataObjects;

/**
 * @since 10/20/2017
 * @author jeremy
 */
public class Periodical extends Item{

	public static int numVars = 8;
	
	private String subject;
	
	/**
     * By value constructor
     * @param attributes for initialization
     */
    public Periodical(String category,
    				  String name,
    				  String description,
    				  int quantity,
    				  String id,
    				  int x,
    				  int y,
    				  String subject){

        super(category, name, description, quantity, id, x, y);
        this.setSubject(subject);
    }
    
    /**
     * Dugan's array constructor
     * @param newItem String array of values from the time.
     */
    public Periodical(String[] newItem){
    	super(newItem);
        this.setSubject(newItem[7]);
    }
    
    /**
     * To CSV format
     * @return This item in string CSV format
     */
    public String toCSVFormat(){
    	return super.toCSVFormat() + "," +
                this.getSubject();
    }
    
    /**
     * Debugging and showing info
     */
    public String toString(){
        return super.toString() + "," +
               this.getSubject();
    }
    
    // Getters and Setters ***************************************************

	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	@Override
	public String[] getMaker() {
		String[] return_value = {"Publisher",this.getName()};
		return return_value;
	}
}
