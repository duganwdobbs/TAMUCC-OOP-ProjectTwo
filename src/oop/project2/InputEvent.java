package oop.project2;

/**
 *
 * @author ddobbs
 */
public class InputEvent extends LibEvent {
    private String data;
    
    public InputEvent(String data){
        super(0);
        this.setData(data);
    }
    
    private void setData(String data){
        this.data = data;
    }
    
    public String getData(){
        return this.data;
    }
}
