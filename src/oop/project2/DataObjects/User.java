package oop.project2.DataObjects;

import java.util.ArrayList;
import oop.project2.libevent.UserCheckoutError;

public class User {
    /**
     * 
     */
    private String name;
    private String id;
    private int checkedOut;
    public final static int MAX_CHECKOUT = 3;
    private ArrayList<String> checkedBookIDs;
        
    public User(String[] arr){
        this.setName(arr[0]);
        this.setID(arr[1]);
        this.setCheckedOut(Integer.parseInt(arr[2]));
        this.checkedBookIDs = new ArrayList<String>();
        for(int x = 0;x<checkedOut;x++){
            checkedBookIDs.add(arr[x+2]);
        }
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
    
    public void checkOut(String itemID){
        checkedBookIDs.add(itemID);
    }
    
    public void checkIn(String itemID){
        checkedBookIDs.remove(itemID);
    }
    
    public void display(){
        System.out.println(toCSVFormat());
    }
    
    public String toCSVFormat(){
        String returnVal = name + "," + id + "," + checkedOut;
        for(String s:checkedBookIDs){
            returnVal = returnVal + "," + s;
        }
        return returnVal + "\n";
    }
    
    public boolean tryCheckOut(String itemID) throws UserCheckoutError{
        if(checkedBookIDs.contains(itemID)){
            return false;
        }
        else if(checkedOut < MAX_CHECKOUT){
            return true;
        }
        throw new UserCheckoutError(this.id);
    }
}