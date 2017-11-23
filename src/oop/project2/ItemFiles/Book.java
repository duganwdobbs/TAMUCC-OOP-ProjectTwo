package oop.project2;

/**
 * @since 10/20/2017
 * @author jeremy
 */
public class Book extends Item throws ItemNotInStockError{

    /**
     * @var1 Static int to hold the number of variables this class has
     * @var2 Private string name
     * @var3 Private string description
     * @var4 Private int quantity to hold the number of items in stock, or in order
     * @var5 Private int The ID of the item
     * @var6 Private double The price of the item
     * @var7 Private string to hold the category
     */

    private String Author;
    private int rating;


    /**
     * To CSV format
     * @return This item in string CSV format
     */
    public String toCSVFormat(){
        return super.toCSVFormat() + "," +
               this.getAuthor + "," +
               this.getRating();
    }

    /**
     * Dugan's array constructor
     * @param newItem String array of values from the time.
     */
    public Book(String[] newItem){
        super(newItem);
        this.setAuthor(newItem[7]);
        this.setRating(Integer.parseInt(newItem[8]));
    }

    /**
     * By value constructor
     * @param name
     * @param description
     * @param quantity
     * @param id
     * @param category
     */
    public Book(String category, String name, String description, int quantity, int id, int x, int y, String author, int rating){

        super(category, name, description, quantity, id, x, y);
        this.setAuthor(author);
        this.setRating(rating);
    }

    /**
     * Debugging and output function update
     */
    public void toString(){
        return super.toString() + "," +
               this.getAuthor() + "," +
               this.getRating();
    }
}
