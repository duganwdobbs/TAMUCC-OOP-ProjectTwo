package oop.project2.DataObjects;

//TODO: implement ReferenceCheckoutError

import oop.project2.libevent.ReferenceCheckoutError;


/**
 * @since 10/20/2017
 * @author jeremy
 */
public class Reference extends Item{

	public static int numVars = 8;
	private String publisher;
	
	/**
     * By value constructor
     * @param attributes for initialization
     */
    public Reference(String category,
    				 String name,
    				 String description,
    				 int quantity,
    				 String id,
    				 int x,
    				 int y,
    				 String publisher){

    	super(category, name, description, quantity, id, x, y);
    	this.setPublisher(publisher);
    }
    
    /**
     * Dugan's array constructor
     * @param newItem String array of values from the time.
     */
    public Reference(String[] newItem){
        super(newItem);
        publisher = newItem[7];
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
    
    public void setPublisher(String publisher) {
    	this.publisher = publisher;
    }
    
    public String getPublisher() {
    	return this.publisher;
    }
    
    // Getters and Setters ***************************************************
    // none
    
    @Override
    public void tryCheckOut() throws ReferenceCheckoutError{
        throw new ReferenceCheckoutError(this.getID());
    }
    
    @Override
    public String getMaker() {
    	return this.getPublisher();
    }
}
