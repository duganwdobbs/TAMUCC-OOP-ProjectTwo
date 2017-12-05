package oop.project2;
import oop.project2.libevent.ResultEvent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import oop.project2.DataObjects.Item;
import oop.project2.libevent.LibError;
import oop.project2.libevent.ParseEvent;

/**
 * This class implements a runnable thread for the databases. It associates with
 * the EventBuilder and GUI in order to pass thread-safe variables. There is a 
 * very low chance for a data-race, as GUI has access to the items list, however
 * it is treated as immutable in the GUI context.
 * 
 * The purpose of this thread is to mange the user and item databases, checking
 * possabilites for checking in and checking out, passing back the resultant 
 * events to the EventBuilder so that it can build the most recent event vector.
 * @author ddobbs
 */
public class DBThread implements LibRunnable{
    /**
     * @var1 ItemDB The item DB
     * @var2 UserDB The user DB
     * @var3 ArrayBlockingQueue<ResultEvent> The event queue that this thread
     * stores result events.
     * @var4 EventBuilder This is the reference to the event builder object, so
     * that this thread can access the event queue it parses from inputs.
     */
    private ItemDB items;
    private UserDB users;
    
    private ArrayBlockingQueue<ResultEvent> db_queue;
    private EventBuilder Evt;
    
    /**
     * Standard default constructor, initiates the databases and the result 
     * event queue.
     */
    public DBThread(){
        items = new ItemDB();
        users = new UserDB();
        db_queue = new ArrayBlockingQueue<ResultEvent>(20);
    }
    
    /**
     * This method is started from Runnable, defines what to do when started in
     * a thread.
     */
    @Override
    public void run() {
        try {
            run_thread();
        } catch (InterruptedException ex) {
            Logger.getLogger(DBThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This event gets the next event. If there is no event, it returns an empty
     * one for error's sake.
     * @return ResultEvent Either "Empty" or has result event from check in.
     * @throws InterruptedException If the thread is broken, throws an error.
     */
    public ResultEvent getNext() throws InterruptedException {
        if(db_queue.peek()!= null){
            return db_queue.take();
        }
        else{
            return new ResultEvent("Empty");
        }
    }
    
    /**
     * The private thread function.
     * @throws InterruptedException 
     */
    private void run_thread() throws InterruptedException{
       //Todo: Change true to should stop condition
        while(true){
            step();
            Thread.sleep(50);
        }
    }
    
    /**
     * The function that defines one step in the thread. Pulls event from 
     * EventBuilder, and attemps to check in / out a book for a user.
     * @throws InterruptedException 
     */
    private void step() throws InterruptedException{
        //Check EventQ
        ParseEvent next_parse = Evt.getNext();
        if(!"Empty".equals(next_parse.getString())){
            checkout(next_parse);
        }
    }
    
    /**
     * Ohhh boy. This function receives a parse event from step, checks if the 
     * user and items exist, if the user has the book already checked out, or if
     * the user can check out another item. If any of those string of events is 
     * true, it processes this event, builds a result, and puts it in the 
     * ResultEvent queue.
     * @param next_event  Checkin / out event to check
     */
    private void checkout(ParseEvent next_event){
        try{
            //Tests if we're going to check out, and if we can check out.
            if(!users.exists(next_event.getUser(),next_event.getItem())){
                items.exists(next_event.getItem(),false);
                //Checkin
                db_queue.offer(checkin(next_event.getUser(),next_event.getItem()));
            }
            else{
                //Tests a checkout on the item.
                items.exists(next_event.getItem(),true);
                //Checkout
                db_queue.offer(checkout(next_event.getUser(),next_event.getItem()));
            }
            
        } catch (LibError e){
            db_queue.offer(new ResultEvent(e, next_event));
        }
    }
    
    /**
     * After the previous function passes all tests, it calls this or the next
     * function to check out or in the book. If it did pass all the tests, this
     * function always fires. We decided to not test for errors here, as we have
     * already done so, any any bugs would need to be hammered out by employees 
     * doing a manual inventory.
     * @param userID UserID to check in a book for
     * @param itemID ItemID to check in
     * @return ResultEvent for checking in an item
     */
    private ResultEvent checkin(String userID, String itemID){
        items.checkIn(userID, itemID);
        users.checkIn(userID, itemID);
        return new ResultEvent("Checkin",userID,itemID);
    }
    
    /**
     * This function is the same as the previous, except for the fact it checks
     * an item out.
     * @param userID UserID to check out a book for
     * @param itemID ItemID to check out
     * @return ResultEvent for checking out an item
     */
    private ResultEvent checkout(String userID, String itemID){
        items.checkOut(userID, itemID);
        users.checkOut(userID, itemID);
        return new ResultEvent("Checkout",userID,itemID);
    }

    /**
     * This function receives the other thread objects in order to associate 
     * with them. This object access the EventBuilder object in order to parse
     * checkin / out events.
     * 
     * The status of this function is implemented in LibRunable
     * @param DBs The Database thread (This one)
     * @param Inp The Input Builder
     * @param Evt The Event Builder
     */
    @Override
    public void associate(DBThread DBs, InputBuilder Inp, EventBuilder Evt) {
        this.Evt = Evt;
    }
    
    /**
     * This function returns the items for the GUI. If possible, we would prefer
     * to have this in an immutable format, however, as every non primative 
     * object in Java is passed by reference, this isn't really possible.
     * @return Item array of the items in the itemDB
     */
    public Item[] getItems(){
        return items.getItems();
    }
    
    /**
     * Debug function to display the contents of the databases.
     */
    public void display(){
        items.display();
        users.display();
    }
    
    
}
