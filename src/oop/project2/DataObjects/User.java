package oop.project2.DataObjects;

public class User {
    /**
     * 
     */
    private String name;
    private int id;
    private int checkedOut;
    public final static int MAX_CHECKOUT = 3;
        
    public User(String[] arr){
        this.setName(arr[0]);
        this.setID(Integer.parseInt(arr[1]));
        this.setCheckedOut(Integer.parseInt(arr[2]));
    }
    
    private void setName(String name){
        this.name = name;
    }
    
    private void setID(int id){
        this.id = id;
    }
    
    private void setCheckedOut(int checkedOut){
        this.checkedOut = checkedOut;
    }
    
    public String toCSVFormat(){
        return "" + name + "," + id + "," + checkedOut + "\n";
    }
}