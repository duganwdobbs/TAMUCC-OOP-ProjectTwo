package oop.project2.libevent;

/**
 * This is the item not found error
 * @author ddobbs
 */
public class ItemNotFoundError extends LibError{
    /**
     * @var1 The item Id that was not found
     */
    private String itemID;
    
    /**
     * Constructor, takes an ItemId and builds an error
     * @param itemID Item ID that wasn't found
     */
    public ItemNotFoundError(String itemID){
        super(0,"");
        this.itemID = itemID;
    }

    /**
     * Returns formatted summary string
     * @return Formateed summary string
     */
    @Override
    public String getSummary() {
        return "Item" + itemID + " Not Found";
    }
}
