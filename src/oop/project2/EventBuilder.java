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
    
    private final int MAX_INPUT_SIZE = 50;
    
    private long lastTime;
    
    //References:
    private DBThread DBs;
    private InputBuilder Inp;
    
    public EventBuilder(){
        parse_queue = new ArrayBlockingQueue<ParseEvent>(20);
        event_vector = new Vector<LibEvent>(5); 
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
    
    private void step() throws InterruptedException{
        //Threshold for stream timeout.
        if(System.currentTimeMillis() - lastTime > 5000){
            destroyStream();
        }
        InputEvent next = Inp.getNext();
        
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
            destroyStream();
        }
        return return_value;
    }
    
    private boolean checkFormat(){
        //return if current stream is proper format
        return this.input_size == 26;
    }
    
    private void addVecEvent(ResultEvent db_next){
        for(int x=0;x<4;x++){
            event_vector.set(x+1,event_vector.get(x));
        }
        event_vector.set(4, db_next);
    }
    
    private void addEvent(InputEvent next){
        input_stream[input_size] = next.getChar();
        input_size++;
    }
    
    private void destroyStream(){
        for(char e : input_stream){
            e = ' ';
        }
        lastTime = System.currentTimeMillis();
        input_size = 0;
    }
    
    public ParseEvent getNext() throws InterruptedException{
        if(parse_queue.peek()!= null){
            return parse_queue.take();
        }
        else{
            return new ParseEvent("Empty");
        }
    }

    public void associate(GUIThread GUI, DBThread DBs, InputBuilder Inp, EventBuilder Evt) {
        this.DBs = DBs;
        this.Inp = Inp;
    }
}
