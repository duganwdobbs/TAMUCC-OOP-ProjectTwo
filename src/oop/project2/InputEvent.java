package oop.project2;

/**
 *
 * @author ddobbs
 */
public class InputEvent extends LibEvent implements LibParsable {
    private String data;
    
    public InputEvent(String data){
        super(0);
        this.setData(data);
    }

    InputEvent(char a, long nanoTime) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private InputEvent InputEvent(String empty) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void setData(String data){
        this.data = data;
    }
    
    public String getData(){
        return this.data;
    }
}
