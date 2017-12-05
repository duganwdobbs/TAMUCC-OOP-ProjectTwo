package oop.project2.libevent;

/**
 * This is an error wrapper for when an invalid stream is thrown out.
 * @author ddobbs
 */
public class InvalidStreamError extends LibError{

    /**
     * Only default constructor for this class. It doesn't need any arguments.
     */
    public InvalidStreamError() {
        super(5, "Invalid Stream Error");
    }

    /**
     * Returns the summary of the error
     * @return Formatted summary string
     */
    @Override
    public String getSummary() {
        return "Invalid stream error.";
    }

    /**
     * Returns the string eval of the error
     * @return Formatted string
     */
    @Override
    public String toString() {
        return "Invalid stream error.";
    }
    
}
