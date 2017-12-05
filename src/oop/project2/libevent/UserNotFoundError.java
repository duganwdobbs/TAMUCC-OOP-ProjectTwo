package oop.project2.libevent;

/**
 * This is the error that is thrown if the user ID is not found
 * @author ddobbs
 */
public class UserNotFoundError extends LibError{
    /**
     * @var1 The user ID that wasn't found
     */
    private String userID;
    
    /**
     * The constructor from the UserID, builds the super class with this 
     * information
     * @param userID 
     */
    public UserNotFoundError(String userID){
        super(1,"");
        this.userID = userID;
    }

    /**
     * Overridden summary function, returns a formatted summary string
     * @return 
     */
    @Override
    public String getSummary() {
        return "User " + userID + " not found.";
    }
}
