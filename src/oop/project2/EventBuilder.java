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
public class EventBuilder implements Runnable{
    private ArrayBlockingQueue<ParseEvent> parse_queue;
    private Vector<LibEvent> event_vector;
    private char[] input_stream;
    private int inputSize;
    
    private final int MAX_INPUT_SIZE = 50;
    
    private long lastTime;
    
    //References:
    private DBThread DBs;
    private InputBuilder Inp;
    
    public EventBuilder(){
        parse_queue = new ArrayBlockingQueue<ParseEvent>(20);
        event_vector = new Vector<LibEvent>(5); 
        input_stream = new char[MAX_INPUT_SIZE];
        inputSize = 0;
    }

    @Override
    public void run() {
        if(System.currentTimeMillis() - lastTime > 5000){
            destroyStream();
            
        }
        InputEvent next = new InputEvent("Empty");
        try {
            next = Inp.getNext();
        } catch (InterruptedException ex) {
            Logger.getLogger(EventBuilder.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(!"Empty".equals(next.getString())){
            addEvent(next);
        }
        
        ResultEvent db_next = DBs.getNext();
        if(!"Empty".equals(db_next.getInfo())){
            addVecEvent(db_next);
        }
        
        if(checkFormat()){
            parse_queue.add(new ParseEvent(parseStream()));
        }
    }
    
    private String parseStream(){
        // TODO: Implement Pattern Formatting?
        // TODO: Construct String from current stream
        // TODO: Put ',' after length of user ID
        return "";
    }
    
    private boolean checkFormat(){
        //return if current stream is proper format
        return false;
    }
    
    private void addVecEvent(ResultEvent db_next){
        for(int x=0;x<4;x++){
            event_vector.set(x+1,event_vector.get(x));
        }
        event_vector.set(4, db_next);
    }
    
    private void addEvent(InputEvent next){
        input_stream[inputSize] = next.getChar();
        inputSize++;
    }
    
    private void destroyStream(){
        for(char e : input_stream){
            e = ' ';
        }
        lastTime = System.currentTimeMillis();
        inputSize = 0;
    }
    
    public ParseEvent getNext() throws InterruptedException{
        if(parse_queue.peek()!= null){
            return parse_queue.take();
        }
        else{
            return new ParseEvent("Empty");
        }
    }

    void associate(LendingLibraryGUI GUI, DBThread DBs, InputBuilder Inp, EventBuilder Evt) {
        this.DBs = DBs;
        this.Inp = Inp;
    }
}
