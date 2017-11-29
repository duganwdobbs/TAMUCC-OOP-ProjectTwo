package oop.project2;
import oop.project2.libevent.*;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ddobbs
 */
public class InputBuilder implements LibRunnable{
    private ArrayBlockingQueue<InputEvent> imp_queue;
    
    public InputBuilder(){
        imp_queue = new ArrayBlockingQueue<InputEvent>(200);
    }

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
    
    public InputEvent getNext() throws InterruptedException{
        if(imp_queue.peek()!= null){
            return imp_queue.take();
        }
        else{
            return new InputEvent("Empty");
        }
    }
    
    @SuppressWarnings("empty-statement")
    public void PutEvent(char a){
        while(! imp_queue.offer(new InputEvent(a, System.currentTimeMillis())));
    }

    @Override
    public void associate(DBThread DBs, InputBuilder Inp, EventBuilder Evt) {
        
    }
    
}
