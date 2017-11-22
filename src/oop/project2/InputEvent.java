package oop.project2;

/**
 *
 * @author ddobbs
 */
public class InputEvent extends LibEvent{
    private char data;
    private long nanoTime;
    
    public InputEvent(char data){
        super(0,"Input Event.");
        this.setData(data);
    }

    /**
     *
     * @param a
     * @param nanoTime
     */
    public InputEvent(char a, long nanoTime) {
        super(0,"Input Event");
        this.setData(a);
        this.setTime(nanoTime);
    }

    /**
     *
     * @param a
     */
    public InputEvent(char a) {
        super(0,"Input Event");
        this.setData(a);
        this.setTime();
    }

    /**
     *
     * @param a
     */
    public InputEvent(String data) {
        super(-1,data);
    }
    
    private void setData(char data){
        this.data = data;
    }
    
    public char getData(){
        return this.data;
    }
    
    private void setTime(){
        this.nanoTime = System.nanoTime();
    }
    
    private void setTime(long nanoTime){
        this.nanoTime = nanoTime;
    }

    String getString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    char getChar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSummary() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
