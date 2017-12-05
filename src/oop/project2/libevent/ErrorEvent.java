package oop.project2.libevent;

/**
 * This is a overall wrapper for LibErrors as events.
 * @author ddobbs
 */
public class ErrorEvent extends LibEvent{
    /**
     * @var1 error the LibError that this event wraps
     */
    LibError error;

    /**
     * Constructor with given error
     * @param err 
     */
    public ErrorEvent(LibError err){
        super(1,err.getSummary());
        this.error = err;
    }
    
    /**
     * @return Int value of the error's type
     */
    public int getErrorType(){
        return error.getType();
    }
    
    /**
     * @return Gets string value of error's text
     */
    public String getErrorText(){
        return error.getStatusText();
    }

    /**
     * @return String value for summary of the error, more verbose than this
     */
    @Override
    public String getSummary() {
        return error.getSummary();
    }

    /**
     * @return String value for the summary of the error.
     */
    @Override
    public String toString() {
        return error.getSummary();
    }
}
