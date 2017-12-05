package oop.project2.libevent;

/**
 * This is an input event used by the InputBuilder and EventBuilder
 * @author ddobbs
 */
public class InputEvent extends LibEvent{
    /**
     * @var1 char data The character input at certain time
     * @var2 long nanoTime The nano second value of the input time
     */
    private char data;
    private long nanoTime;
    
    /**
     * Default constructor basically, recives a char and builds an event using
     * the current system time.
     * @param data The char input 
     */
    public InputEvent(char data){
        super(0,"Input Event.");
        this.setData(data);
        this.setTime();
    }

    /**
     * A piecewise constructor, 
     * @param a Character to put into the data
     * @param nanoTime The time to set to
     */
    public InputEvent(char a, long nanoTime) {
        super(0,"Input Event");
        this.setData(a);
        this.setTime(nanoTime);
    }

    /**
     * Empty constructor
     * @param data The data to build this with.
     */
    public InputEvent(String data) {
        super(-1,data);
    }
    
    /**
     * Mutator
     * @param data 
     */
    private void setData(char data){
        this.data = data;
    }
    
    /**
     * Acessor
     * @return 
     */
    public char getData(){
        return this.data;
    }
    
    /**
     * Mutator, but sets to current system time
     */
    private void setTime(){
        this.nanoTime = System.nanoTime();
    }
    
    /**
     * Setter
     * @param nanoTime 
     */
    private void setTime(long nanoTime){
        this.nanoTime = nanoTime;
    }
    
    /**
     * Gets the string value of this event
     * @return Formatted string
     */
    public String getString(){
        return String.format("INPUT EVENT: %c, TIME: %d",this.data,this.nanoTime);
    }

    /**
     * Gets the info of the event
     * @return Formatted string for info
     */
    public String getInfo() {
        return super.getInfo();
    }

    /**
     * Gets the char data for this event
     * @return character from event
     */
    public char getChar() {
        return this.data;
    }

    /**
     * Gets the summary
     * @return Formatted summary string
     */
    @Override
    public String getSummary() {
        return String.format("INPUT EVENT: %c, TIME: %d",this.data,this.nanoTime);
    }
    
    /**
     * Gets the toString, or summary
     * @return Formatted summary string
     */
    @Override
    public String toString() {
    	return this.getSummary();
    }
}
