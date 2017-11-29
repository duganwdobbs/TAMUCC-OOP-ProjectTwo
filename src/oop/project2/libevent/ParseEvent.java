package oop.project2.libevent;

/**
 *
 * @author ddobbs
 */
public class ParseEvent extends LibEvent {
    private String userID;
    private String itemID;
    
    public ParseEvent(String userID, String itemID){
        super(3,"Parse Event.");
        this.setUser(userID);
        this.setItem(itemID);
    }

    public ParseEvent(String empty) {
        super(-1,"Empty");
    }

    public ParseEvent(String parseEvent, int size) {
        super(3,"Parse Event.");
        String[] split = parseEvent.split(",");
        this.setUser(split[0]);
        this.setItem(split[1]);
    }
    
    @Override
    public String toString(){
        String ret = "USER: " + userID + " ITEM: " + itemID;
        return ret;
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
    
    static boolean patternCheck(){
        return false;
    }

    @Override
    public String getSummary() {
        return super.getInfo();
    }
}
