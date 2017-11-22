package uberstock;

/**
 * @since 10/20/2017
 * @author jeremy
 */
public class Periodical extends Item throws ItemNotInStockError{

    /**
     * @var1 Static int to hold the number of variables this class has
     * @var2 Private string name
     * @var3 Private string description
     * @var4 Private int quantity to hold the number of items in stock, or in order
     * @var5 Private int The ID of the item
     * @var6 Private double The price of the item
     * @var7 Private string to hold the category
     */


    /**
     * To CSV format
     * @return This item in string CSV format
     */
    public String toCSVFormat(){
        return  this.getName().replace(",","")        + "," +
                this.getDescription().replace(",","") + "," +
                this.getQuantity()    + "," +
                this.getId()          + "," +
                this.getPrice()       + "," +
                this.getCategory().replace(",","");
    }

    /**
     * Dugan's array constructor
     * @param newItem String array of values from the time.
     */
    public Item(String[] newItem){
        this.setName(newItem[0]);
        this.setDescription(newItem[1]);
        this.setQuantity(Integer.parseInt(newItem[2]));
        this.setId(Integer.parseInt(newItem[3]));
        this.setPrice(Float.parseFloat(newItem[4]));
        //This should work Dugan *THANKS!*
        this.setCategory(newItem[5]);
    }

    /**
     * By value constructor
     * @param name
     * @param description
     * @param quantity
     * @param id
     * @param category
     */
    public Item(int numVars, String category, String name, String description, int quantity, int id, int x, int y){

        this.setNumVars(numVars);

        this.setCategory(category);

        this.setName(name);
        this.setDescription(description);
        this.setQuantity(quantity);
        this.setId(id);
        this.setX(x);
        this.setY(y);
    }

    /**
     * Debugging and output function update
     */
    public void display(){
        System.out.println(
                            this.getCategory().replace(",","") + "," +
                            this.getName().replace(",","") + "," +
                            this.getDescription().replace(",","") + "," +
                            this.getQuantity() + "," +
                            this.getId() + "," +
                            this.getX() + "," +
                            this.getY() + ","
        );
    }
}
