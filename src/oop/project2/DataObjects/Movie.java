package oop.project2.DataObjects;

/**
 * @since 10/20/2017
 * @author jeremy
 */
public class Movie extends Item{

	public static int numVars = 9;
	
	private String genre;
    private int rating;

    /**
     * By value constructor
     * @param attributes for initialization
     */
    public Movie(String category,
	    		String name,
	    		String description,
	    		int quantity,
	    		String id,
	    		int x,
	    		int y,
	    		String genre,
	    		int rating){

    	super(category, name, description, quantity, id, x, y);
        this.setGenre(genre);
        this.setRating(rating);
    }
    
    /**
     * Dugan's array constructor
     * @param newItem String array of values from the time.
     */
    public Movie(String[] newItem){
        super(newItem);
        this.setGenre(newItem[7]);
        this.setRating(Integer.parseInt(newItem[8]));
    }
    
    /**
     * To CSV format
     * @return This item in string CSV format
     */
    public String toCSVFormat(){
        return super.toCSVFormat() + "," +
               this.getGenre() + "," +
               this.getRating();
    }

    /**
     * For Debugging and showing info
     */
    public String toString(){
        return super.toString() + "," +
               this.getGenre() + "," +
               this.getRating();
    }

    // Getters and Setters ***************************************************

	/**
	 * @return the genre
	 */
	public String getGenre() {
		return genre;
	}

	/**
	 * @param genre the genre to set
	 */
	public void setGenre(String genre) {
		this.genre = genre;
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
}
