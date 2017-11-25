package oop.project2;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileWriter;
import java.util.LinkedList;

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
                data[currIndex] = new Item(newItem);              
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
             if(data[x].getCategory().equals(catSearch)){ //YOU CANNOT USE == OPERATOR WITH STRINGS
                 newList.add(data[x]);
             }
         }
         return newList;
     }
}