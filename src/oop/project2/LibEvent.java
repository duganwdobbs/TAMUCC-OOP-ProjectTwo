package oop.project2;

import java.lang.IllegalArgumentException;

/**
 *
 * @author ddobbs
 */
public abstract class LibEvent {
    private int type;
    final private String statusText[] = {"Input",
                                         "Error",
                                         "Update",
                                         "Database",
                                         "",
                                         "",
                                         ""};
    
    public LibEvent(int type){
        this.setType(type);
    }
    
    private void setType(int type) throws IllegalArgumentException{
        this.type = (type >= 0 && type <= 7) ? type : -1;
        //if (this.type == -1) {
        //    throw
        //}
    }
    
    public String getStatusText(){
        return this.statusText[this.type];
    }
    
    public int getType()
    {
        return this.type;
    }
    
}
