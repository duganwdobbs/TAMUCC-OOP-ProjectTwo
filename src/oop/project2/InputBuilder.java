package oop.project2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ddobbs
 */
public class InputBuilder implements Runnable{
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
            return InputEvent("Empty");
        }
    }
    
    public void PutEvent(char a){
        while(! imp_queue.offer(new InputEvent(a, System.nanoTime())));
    }

    private InputEvent InputEvent(String empty) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
