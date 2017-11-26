package oop.project2;

/**
 * The database parent class. Abstract
 * @author ddobbs
 */
public abstract class Database {
    protected static String File_Location = "./src/";
    /**
     * @var1 Int to hold the size. Useful by Database's children classes
     */
    protected int size;
    
    /**
     * Default constructor. Calls overloaded fromFile() method
     */
    public Database(){
        this.size = 0;
        fromFile();
    }
    
    /**
     * Size getter
     * @return int size
     */
    public int getSize(){
        return size;
    }
    
    /**
     * Closer function. Calls overloaded toFile method
     */
    public void close() {
        toFile();
    }
    
    /**
     * To file overloaded method
     */
    protected abstract void toFile();
    
    /**
     * fromFile method to be overloaded
     */
    protected abstract void fromFile();
    
}
