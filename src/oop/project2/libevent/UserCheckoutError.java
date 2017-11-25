package oop.project2.libevent;

/**
 *
 * @author ddobbs
 */
public class UserCheckoutError extends LibError{
    private String userID;
    
    public UserCheckoutError(String userID){
        super(3,"");
        this.userID = userID;
    }

    @Override
    public String getSummary() {
        return "User " + userID + " has max number of books checked out.";
    }
}
