package oop.project2.libevent;

/**
 *
 * @author ddobbs
 */
public class InvalidStreamError extends LibError{

    public InvalidStreamError() {
        super(5, "Invalid Stream Error");
    }

    @Override
    public String getSummary() {
        return "Invalid stream error.";
    }

    @Override
    public String toString() {
        return "Invalid stream error.";
    }
    
}
