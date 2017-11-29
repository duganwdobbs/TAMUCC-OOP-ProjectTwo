package oop.project2.libevent;

/**
 *
 * @author ddobbs
 */
public class ItemNotFoundError extends LibError{
    private String itemID;
    
    public ItemNotFoundError(String itemID){
        super(0,"");
        this.itemID = itemID;
    }

    @Override
    public String getSummary() {
        return "Item" + itemID + " Not Found";
    }
}
