package oop.project2;
import oop.project2.libevent.*;

import java.util.Vector;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This is the EventBuilder class. It pulls events from the InputBuilder and
 * DBThread, and has a Vector of recent events for the GUI to display. Every
 * once and awhile we get our only concurrency bug, which theoretically 
 * shouldn't be possible, we have concurrent vector writes when this is the only
 * object that writes to it's vector. Beyond that, we have not seen any 
 * concurrency bugs, and we haven't been able to figure out what is causing this
 * @author ddobbs
 */
public class EventBuilder implements LibRunnable{
    //Adjust this variable in order to have longer time period to input items by
    //keyboard if necessary. This is provided as a convenience, the argubaly
    //should be hard coded in.
    private final long TIMEOUT_PERIOD = 5000;
    /**
     * @var1 ArrayBockingQueue<ParseEvent> This is the events parsed from the 
     * InputBuilder
     * @var2 Vector<LibEvent> All events are setup to be displayed as strings, 
     * as they should be, and this vector holds the last five events for output
     * in the GUI.
     * @var3 char[] This char array holds the current stream of information 
     * parsed from the InputBuilder
     * @var4 input_size This is the current size of the input
     * @var5 final int This int is the maximum size of two barcode scans. This
     * is the only pattern matching we are doing at this point.
     * @var6 long lastTime this variable holds the system time of the last scan.
     * If it goes too long without input, it rejects the current stream and 
     * starts over.
     * @var7 DBThread The DBthread, this object uses it to pull result events
     * from
     * @var8 InputBuilder This is the input builder, this object uses it to pull
     * recent inputs with time
     */
    private ArrayBlockingQueue<ParseEvent> parse_queue;
    private Vector<LibEvent> event_vector;
    private char[] input_stream;
    private int input_size;
    
    private final int MAX_INPUT_SIZE = 24;
    
    private long lastTime;
    
    //References:
    private DBThread DBs;
    private InputBuilder Inp;
    
    /**
     * Default constructor, initialzies all objects except for associative ones.
     */
    public EventBuilder(){
        parse_queue = new ArrayBlockingQueue<ParseEvent>(20);
        event_vector = new Vector<LibEvent>(5); 
        for(LibEvent vec: event_vector){
            vec = new ResultEvent("Empty");
        }
        input_stream = new char[MAX_INPUT_SIZE];
        input_size = 0;
    }

    /**
     * Inherited from Runnable, dictates what happens when this object starts as
     * a thread.
     */
    @Override
    public void run() {
        while(true){
            try {
                step();
            } catch (InterruptedException ex) {
                Logger.getLogger(EventBuilder.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    /**
     * This is a psudo associative object, it returns the recent events vector
     * so that it can be used by the GUI
     * @return EventQueue
     */
    public Vector<LibEvent> getEvents(){
    	return this.event_vector;
    }
    
    /**
     * Defines what happens during one step of the thread
     * @throws InterruptedException 
     */
    private void step() throws InterruptedException{
        //Threshold for stream timeout.
        if(System.currentTimeMillis() - lastTime > TIMEOUT_PERIOD){
            try {
                destroyStream();
            } catch (InvalidStreamError ex) {
                addVecEvent(new ErrorEvent(ex));
            }
        }
        InputEvent next = Inp.getNext();
        
        if(!"Empty".equals(next.getInfo())){
            addEvent(next);
        
            if(checkFormat()){
                String stream = parseStream();
                ParseEvent currentStream = new ParseEvent(stream,MAX_INPUT_SIZE);
                parse_queue.add(currentStream);
            }
        }
        
        ResultEvent db_next = DBs.getNext();
        if(!"Empty".equals(db_next.getInfo())){
            addVecEvent(db_next);
        }
    }
    
    /**
     * When the stream is full, it sends it here where it parses the stream into
     * a parseEvent. Please not it never actually parses a destroy stream event
     * here, as this is only called if the length is 24, which is where
     * destoryStream actually doesn't throw an error.
     * @return String representation of the current stream
     */
    private String parseStream(){
        String return_value = "";
        if(checkFormat()){
            for(char a : input_stream){
                return_value = return_value + a;
            }
            StringBuilder mod_str = new StringBuilder(return_value);
            // Replace 12 with length of either book or user ID.
            // TODO: Pattern match Book and User
            mod_str.insert(12,',');
            return_value = mod_str.toString();
            try {
                destroyStream();
            } catch (InvalidStreamError ex) {
                addVecEvent(new ErrorEvent(ex));
            }
        }
        return return_value;
    }
    
    /**
     * This is where pattern matching would be, however, we don't have it atm,
     * just checking length
     * @return boolean if the length is what we're looking for
     */
    private boolean checkFormat(){
        //return if current stream is proper format
        return this.input_size == 24;
    }
    
    /**
     * Moves vector events around, removes the oldest, and pushes everything
     * else up.
     * @param db_next The event to push onto the vector
     */
    private void addVecEvent(LibEvent db_next){
        if(event_vector.size() == event_vector.capacity()){
            event_vector.remove(0);
        }
        event_vector.add(db_next);
        for(LibEvent evt: event_vector){
            System.out.println(evt.toString());
        }
        System.out.println();
    }
    
    /**
     * This recieves an input event, and tosses it onto the current stream.
     * @param next 
     */
    private void addEvent(InputEvent next){
        if(Character.isDigit(next.getChar())){
            input_stream[input_size] = next.getChar();
            input_size++;
        }
    }
    
    /**
     * Destroys the current stream and throws an InvalidStreamError if the 
     * pattern wasn't matched.
     * @throws InvalidStreamError 
     */
    private void destroyStream() throws InvalidStreamError{
        if(this.input_size > 0){
            for(char e : input_stream){
                e = ' ';
            }
            if(this.input_size != 24){
                input_size = 0;
                throw new InvalidStreamError();
            }
            input_size = 0;
        }
        lastTime = System.currentTimeMillis();
    }
    
    /**
     * Gets the next ParseEvent if there is one, else Empty
     * @return the next ParseEvent
     * @throws InterruptedException 
     */
    public ParseEvent getNext() throws InterruptedException{
        if(parse_queue.peek()!= null){
            return parse_queue.take();
        }
        else{
            return new ParseEvent("Empty");
        }
    }

    /**
     * Receives other thread objects in order to associate.
     * @param DBs
     * @param Inp
     * @param Evt 
     */
    public void associate(DBThread DBs, InputBuilder Inp, EventBuilder Evt) {
        this.DBs = DBs;
        this.Inp = Inp;
    }
}
