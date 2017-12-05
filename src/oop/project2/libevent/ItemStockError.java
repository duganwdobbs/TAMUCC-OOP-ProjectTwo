package oop.project2.libevent;

/**
 * Error wrapper for Item Stock Error
 * @author ddobbs
 */
public class ItemStockError extends LibError{
    /**
     * @var1 Item ID not found
     */
    private String itemID;
    
    /**
     * Constructor that receives an item ID and builds the error
     * @param itemID 
     */
    public ItemStockError(String itemID){
        super(2,"");
        this.itemID = itemID;
    }

    /**
     * Returns the formatted summary String
     * @return the formatted summary String
     */
    @Override
    public String getSummary() {
        return "Item" + itemID + " Not in stock";
    }
}