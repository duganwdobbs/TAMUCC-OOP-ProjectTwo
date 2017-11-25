package libevent;

/**
 *
 * @author ddobbs
 */
public class ResultEvent extends LibEvent{

    public ResultEvent(String status) {
        super(3, status);
    }

    @Override
    public String getSummary() {
        return super.getInfo();
    }
    
}
