package oop.project2;
import libevent.*;

import java.util.concurrent.ArrayBlockingQueue;

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
        run_thread();
    }

    public ResultEvent getNext() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void run_thread(){
       //Todo: Change true to should stop condition
        while(true){
            //Check EventQ
            //
            //Do things with EventQ
            //
            //Parse result into ResultQ
            //
            //Check SearchQ
            //
            //Preform Search
            //
            //Parse result into SearchResultQ?
        }
    }

    @Override
    public void associate(LendingLibraryGUI GUI, DBThread DBs, InputBuilder Inp, EventBuilder Evt) {
        this.GUI = GUI;
        this.Evt = Evt;
    }
    
}
