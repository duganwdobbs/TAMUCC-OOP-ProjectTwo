package oop.project2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ddobbs
 */
public class DBThread implements Runnable{
    private ItemDB items;
    private UserDB users;
    
    private ArrayBlockingQueue<DBEvent> db_queue;
    private EventBuilder build_evt;
    
    public DBThread(){
        items = new ItemDB();
        users = new UserDB();
        db_queue = new ArrayBlockingQueue<DBEvent>(20);
    }
    
    @Override
    public void run() {
        ParseEvent next = new ParseEvent("Empty");
        try {
            next = build_evt.getNext();
        } catch (InterruptedException ex) {
            Logger.getLogger(DBThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(!"Empty".equals(next.getString())){
            try {
                //
            }
        }
    }

    public void setEventBuilder(EventBuilder build_evt) {
        this.build_evt = build_evt;
    }

    public DBEvent getNext() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
