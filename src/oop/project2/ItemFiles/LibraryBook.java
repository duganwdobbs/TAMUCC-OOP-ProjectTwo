package oop.project2;

/**
 * @since 10/20/2017
 * @author jeremy
 */
public class LibraryBook extends Item{
	
	public static int numVars = 9;
	
    private String author;
    private int rating;

    /**
     * By value constructor
     * @param attributes for initialization
     */
    public LibraryBook(String category,
    				   String name,
    				   String description,
    				   int quantity,
    				   int id,
    				   int x,
    				   int y,
    				   String author,
    				   int rating){

        super(category, name, description, quantity, id, x, y);
        this.setAuthor(author);
        this.setRating(rating);
    }
    
    /**
     * Dugan's array constructor
     * @param newItem String array of values from the time.
     */
    public LibraryBook(String[] newItem){
        super(newItem);
        this.setAuthor(newItem[7]);
        this.setRating(Integer.parseInt(newItem[8]));
    }
    
    /**
     * To CSV format
     * @return This item in string CSV format
     */
    public String toCSVFormat(){
        return super.toCSVFormat() + "," +
               this.getAuthor() + "," +
               this.getRating();
    }

    /**
     * For Debugging and showing info
     */
    public String toString(){
        return super.toString() + "," +
               this.getAuthor() + "," +
               this.getRating();
    }
    
    // Getters and Setters ***************************************************

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
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
