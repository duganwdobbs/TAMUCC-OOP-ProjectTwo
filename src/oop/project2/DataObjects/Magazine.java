package oop.project2.DataObjects;

/**
 * @since 10/20/2017
 * @author jeremy
 */
public class Magazine extends Periodical{

    public static int numVars = 9;

    private int issue;

    /**
     * By value constructor
     * @param attributes for initialization
     */
    public Magazine(String category,
            String name,
            String description,
            int quantity,
            String id,
            int x,
            int y,
            String subject,
            int issue){

        super(category, name, description, quantity, id, x, y, subject);
        this.setIssue(issue);
    }

    /**
     * Dugan's array constructor
     * @param newItem String array of values from the time.
     */
    public Magazine(String[] newItem){
        super(newItem);
        this.setIssue(Integer.parseInt(newItem[8]));
    }

    /**
     * To CSV format
     * @return This item in string CSV format
     */
    public String toCSVFormat(){
        return super.toCSVFormat() + "," +
                this.getIssue();
    }

    /**
     * Debugging and showing info
     */
    public String toString(){
        return super.toString() + "," +
                this.getIssue();
    }

    // Getters and Setters ***************************************************

    /**
     * @return the issue
     */
    public int getIssue() {
        return issue;
    }

    /**
     * @param edition the edition to set
     */
    public void setIssue(int issue) {
        this.issue = issue;
    }
}
