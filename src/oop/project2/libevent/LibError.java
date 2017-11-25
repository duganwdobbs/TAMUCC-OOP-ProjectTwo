package oop.project2.libevent;

/**
 *
 * @author ddobbs
 */
public abstract class LibError extends Exception implements LibParsable{

    private int type;
    private String info;
    final private String statusText[] = {"ItemNotFound",      //0
                                         "UserNotFound",      //1
                                         "ItemStock",         //2
                                         "UserCheckout",      //3 
                                         "ReferenceCheckout", //4
                                         "InvalidStream",     //5
                                         ""};
    
    public LibError(int type, String info){
        this.setType(type);
        this.setInfo(info);
    }
    
    private void setType(int type){
        this.type = (type >= 0 && type <= 7) ? type : -1;
    }
    
    private void setInfo(String info){
        this.info = info;
    }
    
    public String getStatusText(){
        return this.statusText[this.type];
    }
    
    public String getInfo(){
        return this.info;
    }
    
    public int getType()
    {
        return this.type;
    }
    
}
