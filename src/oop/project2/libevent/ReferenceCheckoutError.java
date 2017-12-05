package oop.project2.libevent;

/**
 * This is the error that is thrown when a user tries to checkout a reference
 * item
 * @author ddobbs
 */
public class ReferenceCheckoutError extends LibError{
    
    /**
     * A default constructor from the itemID that builds the superclass and
     * assigns the value.
     * @param itemID 
     */
    public ReferenceCheckoutError(String itemID){
        super(4,itemID);
    }

    /**
     * Returns a formatted summary string.
     * @return Formatted summary string.
     */
    @Override
    public String getSummary() {
        return "Reference items cannot be check out. Item: " + super.getInfo();
    }
    
    
}
