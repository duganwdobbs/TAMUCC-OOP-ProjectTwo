package oop.project2.libevent;

/**
 * Overall wrapper for all errors that can occur in our program
 * @author ddobbs
 */
public abstract class LibError extends Exception implements LibParsable{
    /**
     * @var1 Int for the type of error
     * @var2 String that has info about the error
     * @var3 String[] that has string versions of each type of error
     */

    private int type;
    private String info;
    final private String statusText[] = {"ItemNotFound",      //0
                                         "UserNotFound",      //1
                                         "ItemStock",         //2
                                         "UserCheckout",      //3 
                                         "ReferenceCheckout", //4
                                         "InvalidStream",     //5
                                         ""};
    
    /**
     * Constructor that receives a type and info to put in
     * @param type
     * @param info 
     */
    public LibError(int type, String info){
        this.setType(type);
        this.setInfo(info);
    }
    
    /**
     * Setter
     * @param type 
     */
    private void setType(int type){
        this.type = (type >= 0 && type <= 7) ? type : -1;
    }
    
    /**
     * Setter
     * @param info 
     */
    private void setInfo(String info){
        this.info = info;
    }
    
    /**
     * @return Formatted string of the status
     */
    public String getStatusText(){
        return this.statusText[this.type];
    }
    
    /**
     * 
     * @return The info of this error
     */
    public String getInfo(){
        return this.info;
    }
    
    /**
     * 
     * @return The int value of this error's type
     */
    public int getType()
    {
        return this.type;
    }
    
}
