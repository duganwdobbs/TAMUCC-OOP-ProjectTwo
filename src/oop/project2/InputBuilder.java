package oop.project2;

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
                //Check Input Queue
                Thread.sleep(10);
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
    public void associate(LendingLibraryGUI GUI, DBThread DBs, InputBuilder Inp, EventBuilder Evt) {
        
    }
    
}
