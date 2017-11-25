package oop.project2.libevent;

/**
 *
 * @author ddobbs
 */
public class UserNotFoundError extends LibError{
    private String userID;
    
    public UserNotFoundError(String userID){
        super(1,"");
        this.userID = userID;
    }

    @Override
    public String getSummary() {
        return "User " + userID + " not found.";
    }
}
