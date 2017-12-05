package oop.project2.libevent;

/**
 * This is the error that is thrown if a user has too many items already checked
 * out.
 * @author ddobbs
 */
public class UserCheckoutError extends LibError{
    /**
     * @var1 String for the userID that failed to check out
     */
    private String userID;
    
    /**
     * Constructor from userID that sets builds the super error
     * @param userID 
     */
    public UserCheckoutError(String userID){
        super(3,"");
        this.userID = userID;
    }

    /**
     * Returns the formatted summary of the object
     * @return 
     */
    @Override
    public String getSummary() {
        return "User " + userID + " has max number of books checked out.";
    }
}
