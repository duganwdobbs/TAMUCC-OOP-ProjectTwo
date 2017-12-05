package oop.project2.libevent;

/**
 * This is the event that the DBThread builds and sends back to the EventBuilder
 * @author ddobbs
 */
public class ResultEvent extends LibEvent{

    /**
     * Builds the super event with the status it is sent
     * @param status 
     */
    public ResultEvent(String status) {
        super(3, status);
    }

    /**
     * Builds the super event with the userId and itemID
     * @param success
     * @param userID
     * @param itemID 
     */
    public ResultEvent(String success, String userID, String itemID) {
        super(3,success);
        if(success.equals("Checkin")){
            super.setInfo("User "+ userID + " checked in item " + itemID);
        }
        else if(success.equals("Checkout")){
            super.setInfo("User "+ userID + " checked out item " + itemID);
        }
    }

    /**
     * Builds the super event fom an error
     * @param e
     * @param next_event 
     */
    public ResultEvent(LibError e, ParseEvent next_event) {
        super(3,"Error checking out item " + next_event.getItem() + " with user " + next_event.getUser());
        switch (e.getType()){
            case 0: super.setInfo("Item: " + next_event.getItem()+ " not found.");
                break;
            case 1: super.setInfo("User: " + next_event.getUser()+ " not found.");
                break;
            case 2: super.setInfo("Item: " + next_event.getItem()+ " not in stock.");
                break; 
            case 3: super.setInfo("User: " + next_event.getUser()+ " has max checked out items.");
                break;
            case 4: super.setInfo("Item: " + next_event.getItem()+ " is reference material and cannot be checked out.");
                break;
            case 5: super.setInfo("Invalid stream, discarded, please try again!");
                break;
                
        }
    }

    /**
     * Returns the summary of the super
     * @return 
     */
    @Override
    public String getSummary() {
        return super.getInfo();
    }

    /**
     * Returns the summary of the super
     * @return 
     */
    @Override
    public String toString() {
        return super.getInfo();
    }
    
}
