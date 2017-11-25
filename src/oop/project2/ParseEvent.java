package oop.project2;

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

    ParseEvent(String empty) {
        super(-1,"Empty");
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

    @Override
    public String getSummary() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object getString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    static boolean patternCheck(){
        return false;
    }
}
