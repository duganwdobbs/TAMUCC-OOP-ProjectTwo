package oop.project2.libevent;

/**
 * This is an event built by EventBuilder that is handeled by the DBThread.
 * @author ddobbs
 */
public class ParseEvent extends LibEvent {
    /**
     * @var1 String for the user ID
     * @var2 String for the item ID
     */
    private String userID;
    private String itemID;
    
    /**
     * Constructor that receives the user and item id, builds the parent event,
     * and sets the values
     * @param userID
     * @param itemID 
     */
    public ParseEvent(String userID, String itemID){
        super(3,"Parse Event.");
        this.setUser(userID);
        this.setItem(itemID);
    }

    /**
     * An empty event, used when the queue is empty
     * @param empty 
     */
    public ParseEvent(String empty) {
        super(-1,"Empty");
    }

    /**
     * An overloaded function that receives a garbage variable size and string,
     * it splits the string and assigns them into the User and Item ID
     * @param parseEvent
     * @param size 
     */
    public ParseEvent(String parseEvent, int size) {
        super(3,"Parse Event.");
        String[] split = parseEvent.split(",");
        this.setUser(split[0]);
        this.setItem(split[1]);
    }
    
    /**
     * This returns the string information of this object
     * @return Formateed string
     */
    @Override
    public String toString(){
        String ret = "USER: " + userID + " ITEM: " + itemID;
        return ret;
    }
    
    /**
     * setter
     * @param userID 
     */
    private void setUser(String userID){
        this.userID = userID;
    }
    
    /**
     * Setter
     * @param itemID 
     */
    private void setItem(String itemID){
        this.itemID = itemID;
    }
    
    /**
     * Getter
     * @return 
     */
    public String getUser(){
        return this.userID;
    }
    
    /**
     * Getter
     * @return 
     */
    public String getItem(){
        return this.itemID;
    }
    
    /**
     * A placeholder function to pattern check. This wasn't implemented in this
     * spot.
     * @return 
     */
    static boolean patternCheck(){
        return false;
    }

    /**
     * Gets the summary of this class.
     * @return Formatted information string from the superclass.
     */
    @Override
    public String getSummary() {
        return super.getInfo();
    }
}
