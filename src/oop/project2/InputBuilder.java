package oop.project2;
import oop.project2.libevent.*;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This is an InputBuilder object. In an actual setup, this would need to 
 * interface with a scanner driver of some sort to build input. As our scanner
 * was a USB keyboard emulated interface, this wasn't necessary.
 * @author ddobbs
 */
public class InputBuilder implements LibRunnable{
    /**
     * @var1 ArrayBlockingQueue<InputEvent> The only item here, a queue that can
     * hold the recent InputEvents
     */
    private ArrayBlockingQueue<InputEvent> imp_queue;
    
    /**
     * Standard default constructor, initializes the Queue
     */
    public InputBuilder(){
        imp_queue = new ArrayBlockingQueue<InputEvent>(200);
    }

    /**
     * Inherited from Runnable, however, this thread just closes as it isn't 
     * necessary to run it. In a hardware interface scenario, this thread would
     * never sleep and its sole purpose would be to intercept inputs from that 
     * device and parse them into the queue.
     */
    @Override
    public void run() {
        while(true){
            try {
                // In a custom scenario, this would need to interface with special
                // drivers ect. In our particular scenario, this is not needed,
                // so this thread can instanly close, or wait indefinetly.
                // Here, we chose to close it with a simple break statement.
                 Thread.sleep(10);
                break;
            } catch (InterruptedException ex) {
                Logger.getLogger(InputBuilder.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    /**
     * Returns the next input if there is one
     * @return Next event, else Empty
     * @throws InterruptedException 
     */
    public InputEvent getNext() throws InterruptedException{
        if(imp_queue.peek()!= null){
            return imp_queue.take();
        }
        else{
            return new InputEvent("Empty");
        }
    }
    
    /**
     * Puts a character from input into the input queue.
     * @param a A char that is put in the queue.
     */
    @SuppressWarnings("empty-statement")
    public void PutEvent(char a){
        while(! imp_queue.offer(new InputEvent(a, System.currentTimeMillis())));
    }

    /**
     * This is a dead function, this object doesn't actually interface with any
     * other thread, but it extends LibRunnable, so this function must exist.
     * @param DBs
     * @param Inp
     * @param Evt 
     */
    @Override
    public void associate(DBThread DBs, InputBuilder Inp, EventBuilder Evt) {
        
    }
    
}
