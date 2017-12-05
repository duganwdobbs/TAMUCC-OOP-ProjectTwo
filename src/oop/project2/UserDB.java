package oop.project2;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileWriter;
import oop.project2.DataObjects.User;
import oop.project2.libevent.UserCheckoutError;
import oop.project2.libevent.UserNotFoundError;

/**
 * This is our User Database.
 * @author ddobbs
 */
public class UserDB extends Database{
	/**
	 * @var1 User[] data The user array
	 * @var2 static String File_Location; Technically the file itself. The Database holds the location.
	 */
    private User[] data;
    private static String File_Location = Database.File_Location + "UserDB.dat";
    
    /**
     * From file function. Overloaded from Database
     */
    @Override
    public void fromFile(){
        try {
            BufferedReader in = new BufferedReader(
                                   new FileReader(File_Location));
            String str;

            str=in.readLine();
            super.size = Integer.parseInt(str.trim());
            data = new User[super.size];
            
            for (int currIndex = 0; currIndex < super.size && (str = in.readLine())!= null; currIndex++) {
                String[] newUser=str.split(",");
                data[currIndex] = new User(newUser);
                
            }
            
            in.close(); 
        } 
        catch (IOException e) {
            System.out.println("User File Read Error");
        }

    }
    
    public void display(){
        for(User usr: data){
            usr.display();
        }
    }
        
    /**
     * Overridden toFile function from Database
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
            }
            out.close();
        }
        catch (IOException e) {
            System.out.println("User File Write Error");
        }
    }
    
    public boolean exists(String user_id, String item_id) throws UserNotFoundError, UserCheckoutError{
        for(User usr: data){
            if(usr.getID().equals(user_id)){
                return usr.tryCheckOut(item_id);
            }
        }
        throw new UserNotFoundError(user_id);
    }
    
    public void checkOut(String user_id, String item_id){
        for(User usr: data){
            if(usr.getID().equals(user_id)){
                usr.checkOut(item_id);
                break;
            }
        }
    }

    public void checkIn(String user_id, String item_id){
        for(User usr: data){
            if(usr.getID().equals(user_id)){
                usr.checkIn(item_id);
                break;
            }
        }
    }
     
}
