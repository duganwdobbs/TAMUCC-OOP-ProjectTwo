package oop.project2;

/**
 *
 * @author ddobbs
 */
public class ErrorEvent extends LibEvent{
    private int errorType;
    final private String errorText[] = {"Book not found.",
                                        "No books in stock.",
                                        "User not found.",
                                        "User has max books checked out.",
                                        "Invalid input stream.",
                                        "",
                                        "",
                                        "",
                                        "",
                                        "",
                                        ""};
    final private int numStatus = 5;
    

    public ErrorEvent(int errorType){
        super(1);
        this.setErrorType(errorType);
    }
    
    private void setErrorType(int errorType){
        this.errorType = (errorType <=0 || errorType >= numStatus) ? errorType : -3;
    }
    
    public int getErrorType(){
        return this.errorType;
    }
    
    public String getErrorText(){
        return this.errorText[this.errorType];
    }
}
