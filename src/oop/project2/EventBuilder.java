package oop.project2;
import oop.project2.libevent.*;

import java.util.Vector;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author ddobbs
 */
public class EventBuilder implements LibRunnable{
    private ArrayBlockingQueue<ParseEvent> parse_queue;
    private Vector<LibEvent> event_vector;
    private char[] input_stream;
    private int input_size;
    
    private final int MAX_INPUT_SIZE = 24;
    
    private long lastTime;
    
    //References:
    private DBThread DBs;
    private InputBuilder Inp;
    
    public EventBuilder(){
        parse_queue = new ArrayBlockingQueue<ParseEvent>(20);
        event_vector = new Vector<LibEvent>(5); 
        for(LibEvent vec: event_vector){
            vec = new ResultEvent("Empty");
        }
        input_stream = new char[MAX_INPUT_SIZE];
        input_size = 0;
    }

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
    
    public Vector<LibEvent> getEvents(){
    	return this.event_vector;
    }
    
    private void step() throws InterruptedException{
        //Threshold for stream timeout.
        if(System.currentTimeMillis() - lastTime > 5000){
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
    
    private boolean checkFormat(){
        //return if current stream is proper format
        return this.input_size == 24;
    }
    
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
    
    private void addEvent(InputEvent next){
        if(Character.isDigit(next.getChar())){
            input_stream[input_size] = next.getChar();
            input_size++;
        }
    }
    
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
    
    public ParseEvent getNext() throws InterruptedException{
        if(parse_queue.peek()!= null){
            return parse_queue.take();
        }
        else{
            return new ParseEvent("Empty");
        }
    }

    public void associate(DBThread DBs, InputBuilder Inp, EventBuilder Evt) {
        this.DBs = DBs;
        this.Inp = Inp;
    }
}
