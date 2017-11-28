package oop.project2.libevent;

/**
 *
 * @author ddobbs
 */
public class ErrorEvent extends LibEvent{
    LibError error;

    public ErrorEvent(LibError err){
        super(1,err.getSummary());
        this.error = err;
    }
    
    public int getErrorType(){
        return error.getType();
    }
    
    public String getErrorText(){
        return error.getStatusText();
    }

    @Override
    public String getSummary() {
        return error.getSummary();
    }

    @Override
    public String toString() {
        return error.getSummary();
    }
}
