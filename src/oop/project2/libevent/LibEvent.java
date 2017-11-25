package oop.project2.libevent;

/**
 *
 * @author ddobbs
 */
public abstract class LibEvent implements LibParsable{
    private int type;
    private String info;
    final private String statusText[] = {"Input",
                                         "Error",
                                         "Update",
                                         "Database",
                                         "",
                                         "",
                                         ""};
    
    public LibEvent(int type, String info){
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
