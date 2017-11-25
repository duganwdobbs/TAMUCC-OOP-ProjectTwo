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
        this.setTime();
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
        return String.format("INPUT EVENT: %c, TIME: %d",this.data,this.nanoTime);
    }

    char getChar() {
        return this.data;
    }

    @Override
    public String getSummary() {
        return String.format("INPUT EVENT: %c, TIME: %d",this.data,this.nanoTime);
    }
}
