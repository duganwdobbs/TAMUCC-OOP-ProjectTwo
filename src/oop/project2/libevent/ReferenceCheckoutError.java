package oop.project2.libevent;

/**
 *
 * @author ddobbs
 */
public class ReferenceCheckoutError extends LibError{
    
    public ReferenceCheckoutError(String itemID){
        super(4,itemID);
    }

    @Override
    public String getSummary() {
        return "Reference items cannot be check out. Item: " + super.getInfo();
    }
    
    
}
