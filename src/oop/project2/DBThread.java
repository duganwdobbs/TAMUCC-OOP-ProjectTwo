package oop.project2;
import oop.project2.libevent.ResultEvent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import oop.project2.libevent.LibError;
import oop.project2.libevent.ParseEvent;

/**
 *
 * @author ddobbs
 */
public class DBThread implements LibRunnable{
    private ItemDB items;
    private UserDB users;
    
    private ArrayBlockingQueue<ResultEvent> db_queue;
    private EventBuilder Evt;
    private LendingLibraryGUI GUI;
    
    public DBThread(){
        items = new ItemDB();
        users = new UserDB();
        db_queue = new ArrayBlockingQueue<ResultEvent>(20);
    }
    
    @Override
    public void run() {
        try {
            run_thread();
        } catch (InterruptedException ex) {
            Logger.getLogger(DBThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResultEvent getNext() throws InterruptedException {
        if(db_queue.peek()!= null){
            return db_queue.take();
        }
        else{
            return new ResultEvent("Empty");
        }
    }
    
    public void run_thread() throws InterruptedException{
       //Todo: Change true to should stop condition
        while(true){
            step();
            Thread.sleep(50);
        }
    }
    
    private void step() throws InterruptedException{
        //Check EventQ
        ParseEvent next_parse = Evt.getNext();
        if(!"Empty".equals(next_parse.getString())){
            checkout(next_parse);
        }
        
        //Check SearchQ
        //
        //Preform Search
        //
        //Parse result into SearchResultQ?
    }
    
    private void checkout(ParseEvent next_event){
        try{
            //Tests a checkout on the user.
            users.exists(next_event.getUser());

            //Tests a checkout on the item.
            items.exists(next_event.getItem());
            
            //Checkout
            db_queue.offer(checkout(next_event.getUser(),next_event.getItem()));
        } catch (LibError e){
            db_queue.offer(new ResultEvent(e, next_event));
        }
    }
    
    private ResultEvent checkout(String userID, String itemID){
        items.checkOut(userID, itemID);
        users.checkOut(userID, itemID);
        return new ResultEvent("Success",userID,itemID);
    }

    @Override
    public void associate(LendingLibraryGUI GUI, DBThread DBs, InputBuilder Inp, EventBuilder Evt) {
        this.GUI = GUI;
        this.Evt = Evt;
    }
}
