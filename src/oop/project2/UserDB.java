package uberstock;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileWriter;

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
                String[] newItem=str.split(",");
                if(Boolean.parseBoolean(newItem[3])){
                    data[currIndex] = new Admin(newItem);
                }
                else{
                		data[currIndex] = new Customer(newItem);
                }
                
            }
            
            in.close(); 
        } 
        catch (IOException e) {
            System.out.println("User File Read Error");
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
            for(int x=0;x<super.size;x++)
            {
                out.write("\n");
                out.write(data[x].toCSVFormat());
            }
            out.close();
        }
        catch (IOException e) {
            System.out.println("User File Write Error");
        }
    }
    
    /**
     * Returns aboolean value for correct login
     * Depreciated function.
     * @param toLogin The username to check
     * @param password The password to check
     * @return Boolean value of successful login.
     * 
     */
    public boolean checkLogin(User toLogin, String password){
        if(toLogin.getPassword() == password){
            return true;
        }
        return false;
    }

    /**
     * Debug display function.
     */
    public void display(){
        for(User user: this.data){
        	System.out.printf("\nUser Name: %s\n", user.getName());
        	System.out.printf("User ID: %s\n", user.getId());
        	System.out.printf("Admin?: %s\n", user.isAdmin()?"YES":"NO");
        	if(user instanceof Customer){
        		System.out.printf("User Email: %s\n", ((Customer)user).getEmail());
        		System.out.printf("User Address: %s\n", ((Customer)user).getAddress());
        		System.out.printf("Member?: %s\n",((Customer)user).isMember()?"YES":"NO");
        	}
        }
    }
    
    /**
     * Actual login function
     * @param username
     * @param password
     * @return The current user to login to session.
     */
    public User login(String username, String password) {
        User returnUser = new Admin("Invalid Login"," ",-3);
        for(int x=0;x<super.size;x++){
            if(data[x].getName().equals(username) && data[x].getPassword().equals(password)) {
                returnUser = data[x];
            } 
        }
        return returnUser;
    }
    
    /**
     * Logs out a current user, storing their data in the database.
     * @param currentUser
     */
    public void logout(User currentUser){
        int x = currentUser.getId();
        if(x > 0 && x < super.size) {
            data[x] = currentUser;
        }
    }
     
}
