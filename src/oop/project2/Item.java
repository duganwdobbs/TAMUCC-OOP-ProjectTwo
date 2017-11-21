package uberstock;

/**
 * Item class holds item information
 *      name, description, quantity, id, price, category
 * @since 10/20/2017
 * @author jeremy
 */
public class Item {
    
    /**
     * @var1 Static int to hold the number of variables this class has
     * @var2 Private string name
     * @var3 Private string description
     * @var4 Private int quantity to hold the number of items in stock, or in order
     * @var5 Private int The ID of the item
     * @var6 Private double The price of the item
     * @var7 Private string to hold the category
     */
    
    public static int numVars = 7;
    
    private String name;
    private String description;
    private int quantity;
    private int id;
    private double price;
    private String category;
    
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
     * @param price
     * @param category 
     */
    public Item(String name, String description, int quantity,
                int id, double price, String category){
        this.setName(name);
        this.setDescription(description);
        this.setQuantity(quantity);
        this.setId(id);
        this.setPrice(price);
        this.setCategory(category);
    }
    
    /**
     * String name getter
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * String name setter
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * String description getter
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * String description mutator
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * int quantity getter
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * int quantity setter
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * int id getter
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * int id setter
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * double price getter
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * double price setter
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * String category getter
     * @return the category
     */
    public String getCategory() {
        return category;
    }
    
    /**
     * String category setter
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }
    
    /**
     * Debugging and output function update
     */
    public void display(){
        System.out.println(
                            this.getName().replace(",","") + "," +
                            this.getDescription().replace(",","") + "," +
                            this.getQuantity() + "," +
                            this.getId() + "," +
                            this.getPrice() + "," +
                            this.getCategory().replace(",","")
        );
    }
}
