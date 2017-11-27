package oop.project2.DataObjects;

/**
 * @since 10/20/2017
 * @author jeremy
 */
public class Movie extends Item{

	public static int numVars = 10;
	
	private String genre;
	private String director;
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
	    		String director,
	    		int rating){

    	super(category, name, description, quantity, id, x, y);
        this.setGenre(genre);
        this.setDirector(director);
        this.setRating(rating);
    }
    
    /**
     * Dugan's array constructor
     * @param newItem String array of values from the time.
     */
    public Movie(String[] newItem){
        super(newItem);
        this.setGenre(newItem[7]);
        this.setDirector(newItem[8]);
        this.setRating(Integer.parseInt(newItem[9]));
    }
    
    /**
     * To CSV format
     * @return This item in string CSV format
     */
    public String toCSVFormat(){
        return super.toCSVFormat() + "," +
                this.getGenre() + "," +
                this.getDirector() + "," +
               this.getRating();
    }

    /**
     * For Debugging and showing info
     */
    public String toString(){
        return super.toString() + "," +
               this.getGenre() + "," +
               this.getDirector() + "," +
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
	
	public String getDirector() {
		return this.director;
	}
	
	public void setDirector(String director) {
		this.director = director;
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
	public String[] getMaker() {
		String[] return_value = {"Director",this.getDirector()};
		return return_value;
	}
}
