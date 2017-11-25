package oop.project2.DataObjects;

/**
 * @since 10/20/2017
 * @author jeremy
 */
public class Newspaper extends Periodical{

	public static int numVars = 9;
	
	private String leaning;//(left, right, middle)

	/**
     * By value constructor
     * @param attributes for initialization
     */
	public Newspaper(String category,
					 String name,
					 String description,
					 int quantity,
					 int id,
					 int x,
					 int y,
					 String subject,
					 String leaning){

        super(category, name, description, quantity, id, x, y, subject);
        this.setLeaning(leaning);
    }
	
	/**
     * Dugan's array constructor
     * @param newItem String array of values from the time.
     */
	public Newspaper(String[] newItem){
    	super(newItem);
        this.setLeaning(newItem[8]);
    }
	
	/**
     * To CSV format
     * @return This item in string CSV format
     */
	public String toCSVFormat(){
    	return super.toCSVFormat() + "," +
                this.getLeaning();
    }

    /**
     * Debugging and showing info
     */
	public String toString(){
        return super.toString() + "," +
               this.getLeaning();
    }
	
    // Getters and Setters ***************************************************

	/**
	 * @return the leaning
	 */
	public String getLeaning() {
		return leaning;
	}

	/**
	 * @param leaning the leaning to set
	 */
	public void setLeaning(String leaning) {
		this.leaning = leaning;
	}
}
