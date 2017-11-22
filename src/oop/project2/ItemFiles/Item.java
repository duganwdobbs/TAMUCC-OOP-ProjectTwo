package uberstock;

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
public abstract class Item throws ItemNotInStockError{

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
    public abstract String toCSVFormat();

    /**
     * Dugan's array constructor
     * @param newItem String array of values from the time.
     */
    public abstract Item(String[] newItem);

    /**
     * By value constructor
     */
    public abstract Item();

    /**
     * For Debugging and output function update
     */
    public abstract void display();
}
