package oop.project2.DataObjects;

//TODO: implement ReferenceCheckoutError

/**
 * @since 10/20/2017
 * @author jeremy
 */
public class Reference extends Item{

	public static int numVars = 7;
	
	/**
     * By value constructor
     * @param attributes for initialization
     */
    public Reference(String category,
    				 String name,
    				 String description,
    				 int quantity,
    				 int id,
    				 int x,
    				 int y){

    	super(category, name, description, quantity, id, x, y);
    }
    
    /**
     * Dugan's array constructor
     * @param newItem String array of values from the time.
     */
    public Reference(String[] newItem){
        super(newItem);
    }
    
    /**
     * To CSV format
     * @return This item in string CSV format
     */
    public String toCSVFormat(){
        return super.toCSVFormat();
    }    

    /**
     * Debugging and and showing info
     */
    public String toString(){
        return super.toString();
    }
    
    // Getters and Setters ***************************************************
    // none
}
