package oop.project2.DataObjects;

//TODO: implement ItemNotInStockError

import oop.project2.libevent.ReferenceCheckoutError;



/**
 * @since 10/20/2017
 * @author Jeremy
 * Item (String category,
 * │     String name,
 * │     String description,
 * │     int quantity,
 * │     int id,
 * │     int x,
 * │     int y)
 * ├───LibraryBook (...String author, int rating)
 * ├───Movie (...String genre, int rating)
 * ├───Audio (...String narrator, int rating)
 * ├───Periodical (...String subject)
 * │   ├──Magazine (...int issue)
 * │   └──Newspaper (...String leaning)
 * └───Reference Material(...)
 */
public class Item{

    public static int numVars = 7;

    private String category;

    private String name;
    private String description;
    private int quantity;
    private String id;
    private int x;
    private int y;
    
    /**
     * By value constructor
     * @param attributes for initialization
     */
    public Item(String category,
                String name,
                String description,
                int quantity,
                String id,
                int x,
                int y){
        
    	this.setCategory(category);
        this.setName(name);
        this.setDescription(description);
        this.setQuantity(quantity);
        this.setId(id);
        this.setX(x);
        this.setY(y);
    }
    
    /**
     * Dugan's array constructor
     * @param newItem String array of values from the time.
     */
    public Item(String[] newItem){
        this.setCategory(newItem[0]);
        this.setName(newItem[1]);
        this.setDescription(newItem[2]);
        this.setQuantity(Integer.parseInt(newItem[3]));
        this.setId(newItem[4]);
        this.setX(Integer.parseInt(newItem[5]));
        this.setY(Integer.parseInt(newItem[6]));
    }


    /**
     * To CSV format
     * @return This item in string CSV format
     */
    public String toCSVFormat(){
        return 
            this.getCategory().replace(",","") + "," +
            this.getName().replace(",","") + "," +
            this.getDescription().replace(",","") + "," +
            this.getQuantity() + "," +
            this.getId() + "," +
            this.getX() + "," +
            this.getY();
    }

    /**
     * For Debugging and showing info
     * @return This item in string format
     */
    public String toString(){
        return
            this.getCategory().replace(",","") + "," +
            this.getName().replace(",","") + "," +
            this.getDescription().replace(",","") + "," +
            this.getQuantity() + "," +
            this.getId() + "," +
            this.getX() + "," +
            this.getY();
    }
    
    // Getters and Setters ***************************************************

	/**
	 * @return the numVars
	 */
	public static int getNumVars() {
		return numVars;
	}

	/**
	 * @param numVars the numVars to set
	 */
	public static void setNumVars(int numVars) {
		Item.numVars = numVars;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

    public void display() {
        System.out.println(toCSVFormat());
    }
    
    public String getID(){
        return this.id;
    }
    
    public void tryCheckOut() throws ReferenceCheckoutError{
        if(this.quantity < 1){
            throw new ReferenceCheckoutError(this.getID());
        }
    }
    
    public void checkOut(){
        this.quantity--;
    }
}
