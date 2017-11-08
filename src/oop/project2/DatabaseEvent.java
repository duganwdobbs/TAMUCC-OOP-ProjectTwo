package oop.project2;

/**
 *
 * @author ddobbs
 */
public class DatabaseEvent extends LibEvent {
    private String userID;
    private String itemID;
    
    public DatabaseEvent(String userID, String itemID){
        super(3);
        this.setUser(userID);
        this.setItem(itemID);
    }
    
    private void setUser(String userID){
        this.userID = userID;
    }
    
    private void setItem(String itemID){
        this.itemID = itemID;
    }
    
    public String getUser(){
        return this.userID;
    }
    
    public String getItem(){
        return this.itemID;
    }
}
