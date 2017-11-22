package oop.project2;

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
    private DBThread db_thread;
    private InputBuilder build_inp;
    
    public EventBuilder(){
        parse_queue = new ArrayBlockingQueue<ParseEvent>(20);
        event_vector = new Vector<LibEvent>(5); 
        input_stream = new char[MAX_INPUT_SIZE];
        inputSize = 0;
    }
    
    public void setDBThread(DBThread db_thread){
        this.db_thread = db_thread;
    }
    
    public void setInputBuilder(InputBuilder build_inp){
        this.build_inp = build_inp;
    }

    @Override
    public void run() {
        if(System.currentTimeMillis() - lastTime > 5000){
            destroyStream();
            
        }
        InputEvent next = new InputEvent("Empty");
        try {
            next = build_inp.getNext();
        } catch (InterruptedException ex) {
            Logger.getLogger(EventBuilder.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(!"Empty".equals(next.getString())){
            addEvent(next);
        }
        
        ResultEvent db_next = db_thread.getNext();
        if(db_next.getInfo() != "Empty"){
            addVecEvent(db_next);
        }
        
        if(checkFormat()){
            parse_queue.add(new ParseEvent(input_stream,inputSize));
        }
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
}
