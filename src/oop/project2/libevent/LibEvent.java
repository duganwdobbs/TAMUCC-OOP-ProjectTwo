package oop.project2.libevent;

/**
 * Overall wrapper for all events that can occur in our program.
 * @author ddobbs
 */
public abstract class LibEvent implements LibParsable{
    /**
     * @var1 Int type for the type of event
     * @var2 String info pertaining to this event
     * @var3 String[] that pertains to tye type, and retuns a string pertaining
     * to it.
     */
    private int type;
    private String info;
    final private String statusText[] = {"Input",
                                         "Error",
                                         "Update",
                                         "Database",
                                         "",
                                         "",
                                         ""};
    
    /**
     * Constructor with type and info to set.
     * @param type
     * @param info 
     */
    public LibEvent(int type, String info){
        this.setType(type);
        this.setInfo(info);
    }
    
    /**
     * Setter
     * @param type 
     */
    protected void setType(int type){
        this.type = (type >= 0 && type <= 7) ? type : -1;
    }
    
    /**
     * Setter
     * @param info 
     */
    protected void setInfo(String info){
        this.info = info;
    }
    
    /**
     * Returns the status text of the event type
     * @return String from the private final array
     */
    public String getStatusText(){
        return this.statusText[this.type];
    }
    
    /**
     * Returns the info
     * @return String info
     */
    public String getInfo(){
        return this.info;
    }
    
    /**
     * Gets the int vlaue of the type
     * @return int type
     */
    public int getType()
    {
        return this.type;
    }
    
    /**
     * Returns the info of this object
     * @return String of the info.
     */
    public String getString(){
        return this.info;
    }
}
