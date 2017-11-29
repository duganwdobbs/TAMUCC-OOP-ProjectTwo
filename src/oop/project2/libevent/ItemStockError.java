package oop.project2.libevent;

/**
 *
 * @author ddobbs
 */
public class ItemStockError extends LibError{
    private String itemID;
    
    public ItemStockError(String itemID){
        super(2,"");
        this.itemID = itemID;
    }

    @Override
    public String getSummary() {
        return "Item" + itemID + " Not in stock";
    }
}