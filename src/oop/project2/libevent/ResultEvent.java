package oop.project2.libevent;

/**
 *
 * @author ddobbs
 */
public class ResultEvent extends LibEvent{

    public ResultEvent(String status) {
        super(3, status);
    }

    public ResultEvent(String success, String userID, String itemID) {
        super(3,"User " + userID + " checked out " + itemID);
    }

    public ResultEvent(LibError e, ParseEvent next_event) {
        super(3,"Error checking out item " + next_event.getItem() + " with user " + next_event.getUser());
    }

    @Override
    public String getSummary() {
        return super.getInfo();
    }
    
}
