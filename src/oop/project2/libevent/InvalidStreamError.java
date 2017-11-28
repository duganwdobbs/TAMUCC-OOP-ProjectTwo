package oop.project2.libevent;

/**
 *
 * @author ddobbs
 */
public class InvalidStreamError extends LibError{

    public InvalidStreamError() {
        super(5, "");
    }

    @Override
    public String getSummary() {
        return "Invalid stream error.";
    }
    
}
