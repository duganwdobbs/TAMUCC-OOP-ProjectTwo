package oop.project2;
import oop.project2.DataObjects.*;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileWriter;
import java.util.LinkedList;
import oop.project2.libevent.ItemNotFoundError;
import oop.project2.libevent.ItemStockError;
import oop.project2.libevent.ReferenceCheckoutError;

/**
 * ItemDB class is for reading/saving/managing ItemDB.dat 
 * @since 10/20/2017 
 * @author ddobbs
 */
public class ItemDB extends Database {
    private Item[] data;
    
    private static String File_Location = Database.File_Location + "ItemDB.dat";
    
    /**
     * @var1 Item[] Data This is The database for items
     */
    
    /**
     * Reads in a new database from a file
     */
    @Override
    public void fromFile(){
        try {
            BufferedReader in = new BufferedReader(
                                   new FileReader(File_Location));
            String str;
            
            str=in.readLine();
            super.size = Integer.parseInt(str);
            data = new Item[super.size];
            for (int currIndex = 0; currIndex < super.size && (str = in.readLine())!= null; currIndex++) {
                String[] newItem=str.split(",");
                if(newItem[0].equals("Audio")) {
                	data[currIndex] = new Audio(newItem);
                }
                else if(newItem[0].equals("Book")) {
                	data[currIndex] = new LibraryBook(newItem);
                }
                else if(newItem[0].equals("Magazine")) {
                	data[currIndex] = new Magazine(newItem);
                }
                else if(newItem[0].equals("Movie")) {
                	data[currIndex] = new Movie(newItem);
                }
                else if(newItem[0].equals("Newspaper")) {
                	data[currIndex] = new Newspaper(newItem);
                }
                else if(newItem[0].equals("Periodical")) {
                	data[currIndex] = new Periodical(newItem);
                }
                else if(newItem[0].equals("Reference")) {
                	data[currIndex] = new Reference(newItem);
                }
            }
            
            in.close(); 
        } 
        catch (IOException e) {
            System.out.println("Item File Read Error");
        }

    }
    
    /**
     * Outputs the database to a file
     */
    @Override
    protected void toFile(){
        try {
            FileWriter out = new FileWriter(File_Location);
            out.write(Integer.toString(super.size));
            out.write("\n");
            for(int x=0;x<super.size;x++)
            {
                out.write(data[x].toCSVFormat());
                out.write("\n");
            }
            out.close();
        }
        catch (IOException e) {
            System.out.println("Item File Write Error");
        }
    }
    
    public void display(){
        for(int x=0;x<size;x++){
            data[x].display();
        }
    }
    
    /*
     * Returns a copy of the item database
     * Dugan comment: whyyyyyyyyyyyyyyyy. In the future, we really need to communicate and say what we need instead of
     * breaking data encapsulation.
     */
    /**
     * Returns the database for use outside, used in very limited circumstances (Dugan doesn't want it used at all!)
     * @return
     */
     public Item[] getItems(){
    	 return this.data;
     }
     
     /**
      * Category search
      * @param catSearch String to search for
      * @return A linked list of the items that match the category
      */
     public LinkedList<Item> ofCategory(String catSearch){
         LinkedList<Item> newList = new LinkedList<Item>();
         for(int x=0;x<super.size;x++){
             if(data[x].getCategory().equals(catSearch)){ 
                 newList.add(data[x]);
             }
         }
         return newList;
     }
     
    /**
     * Checks if an item exists and if we're checking out. 
     * @param id Item to look for
     * @param checkingout boolean value if we're checking out
     * @throws ItemNotFoundError If the item isn't found
     * @throws ItemStockError If we're trying to check out and the item is out
     * of stock
     * @throws ReferenceCheckoutError If we're trying to checkout and the item 
     * is a reference.
     */
    public void exists(String id, boolean checkingout) 
            throws ItemNotFoundError, ItemStockError, ReferenceCheckoutError{
        boolean notFound = true;
        for(Item itm : data){
            if(itm.getID().equals(id)){
                notFound = false;
                if(checkingout){
                    itm.tryCheckOut();
                }
            }
        }
        if(notFound){
            throw new ItemNotFoundError(id);
        }
    }
    
    /**
     * Checking out an item for a user
     * @param userID
     * @param itemID 
     */
    public void checkOut(String userID, String itemID){
        for(Item itm : data){
            if(itm.getID().equals(itemID)){
                itm.checkOut();
            }
        }
    }
    
    /**
     * Checking in an item for a user
     * @param userID
     * @param itemID 
     */
    public void checkIn(String userID, String itemID){
        for(Item itm : data){
            if(itm.getID().equals(itemID)){
                itm.checkIn();
            }
        }
    }
}