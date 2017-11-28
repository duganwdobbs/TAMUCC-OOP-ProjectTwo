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
        super(3,success);
        if(success.equals("Checkin")){
            super.setInfo("User "+ userID + " checked in item " + itemID);
        }
        else if(success.equals("Checkout")){
            super.setInfo("User "+ userID + " checked out item " + itemID);
        }
    }

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

    @Override
    public String getSummary() {
        return super.getInfo();
    }

    @Override
    public String toString() {
        return super.getInfo();
    }
    
}
