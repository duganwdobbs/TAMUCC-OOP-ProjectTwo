package oop.project2;

/**
 * @since 10/20/2017
 * @author jeremy
 * Super: Item
 *     (Have things shared among all items, has search function, can throw
 *     ItemNotInStock errors)
 *      Book              ()
 *      Movie             ()
 *      Audio             ()
 *      Periodiocal       (Magazine, newspaper, ect)
 *      Reference Material(Cannot be checked out, but viewed in lib
 *          throws ReferenceCheckout error)
 */
public class Item throws ItemNotInStockError{

    public static int numVars;

    private String category;

    private String name;
    private String description;
    private int quantity;
    private int id;
    private int x;
    private int y;


    /**
     * To CSV format
     * @return This item in string CSV format
     */
    public String toCSVFormat(){
        return this.getCategory() + "," +
                this.getName() + "," +
                this.getDescription() + "," +
                this.getQuantity() + "," +
                this.getId() + "," +
                this.getX() + "," +
                this.getY();
    }

    /**
     * Dugan's array constructor
     * @param newItem String array of values from the time.
     */
    public Item(String[] newItem){
        this.setCategory(newItem[0])
        this.setName(newItem[1]);
        this.setDescription(newItem[2]);
        this.setQuantity(Integer.parseInt(newItem[3]));
        this.setId(Integer.parseInt(newItem[4]));
        this.setX(Float.parseFloat(newItem[5]));
        this.setY(newItem[6]);
    }

    /**
     * By value constructor
     */
    public Item(String Category,
                String name,
                String description,
                int quantity,
                int id,
                int x,
                int y){
        this.category = category;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.id = id;
        this.x = x;
        this.y = y;
    }

    /**
     * For Debugging and output function update
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
}
