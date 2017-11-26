package oop.project2.DataObjects;

import oop.project2.libevent.UserCheckoutError;

public class User {
    /**
     * 
     */
    private String name;
    private String id;
    private int checkedOut;
    public final static int MAX_CHECKOUT = 3;
        
    public User(String[] arr){
        this.setName(arr[0]);
        this.setID(arr[1]);
        this.setCheckedOut(Integer.parseInt(arr[2]));
    }
    
    private void setName(String name){
        this.name = name;
    }
    
    public String getID(){
        return this.id;
    }
    
    private void setID(String id){
        this.id = id;
    }
    
    private void setCheckedOut(int checkedOut){
        this.checkedOut = checkedOut;
    }
    
    private void checkOut(String userID, String itemID) throws UserCheckoutError{
        if(checkedOut < MAX_CHECKOUT){
            checkedOut++;
        }
        else{
            throw new UserCheckoutError(this.name);
        }
    }
    
    public void display(){
        System.out.println(toCSVFormat());
    }
    
    public String toCSVFormat(){
        return "" + name + "," + id + "," + checkedOut + "\n";
    }
    
    public void tryCheckOut() throws UserCheckoutError{
        if(checkedOut < MAX_CHECKOUT){
            checkedOut++;
        }
        else{
            throw new UserCheckoutError(this.id);
        }
    }
}