package oop.project2.DataObjects;

/**
 * @since 10/20/2017
 * @author jeremy
 */
public class Audio extends Item{

	public static int numVars = 9;
	
	private String narrator;
    private int rating;

    /**
     * By value constructor
     * @param attributes for initialization
     */
    public Audio(String category,
    		     String name,
    		     String description,
    		     int quantity,
    		     String id,
    		     int x,
    		     int y,
    		     String narrator,
    		     int rating){

        super(category, name, description, quantity, id, x, y);
        this.setNarrator(narrator);
        this.setRating(rating);
    }
    
    /**
     * Dugan's array constructor
     * @param newItem String array of values from the time.
     */
    public Audio(String[] newItem){
        super(newItem);
        this.setNarrator(newItem[7]);
        this.setRating(Integer.parseInt(newItem[8]));
    }
    
    /**
     * To CSV format
     * @return This item in string CSV format
     */
    public String toCSVFormat(){
        return super.toCSVFormat() + "," +
               this.getNarrator() + "," +
               this.getRating();
    }
    
    /**
     * Debugging and and showing info
     */
    public String toString(){
        return super.toString() + "," +
               this.getNarrator() + "," +
               this.getRating();
    }

    // Getters and Setters ***************************************************

	/**
	 * @return the narrator
	 */
	public String getNarrator() {
		return narrator;
	}

	/**
	 * @param narrator the narrator to set
	 */
	public void setNarrator(String narrator) {
		this.narrator = narrator;
	}

	/**
	 * @return the rating
	 */
	public int getRating() {
		return rating;
	}

	/**
	 * @param rating the rating to set
	 */
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	@Override
	public String getMaker() {
		return this.getNarrator();
	}
}
