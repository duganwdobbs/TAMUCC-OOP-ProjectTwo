package oop.project2;

/**
 *
 * @author ddobbs
 */
public class GUIThread implements LibRunnable{
    //Associatiave Objects

    private EventBuilder Evt;
    private DBThread DBs;
    private LendingLibraryGUI GUI;
    
    public GUIThread(){
    }
    @Override
    public void run() {
        try {
            GUI = new LendingLibraryGUI();
            GUI.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void associate(GUIThread GUI, DBThread DBs, InputBuilder Inp, EventBuilder Evt) {
        this.Evt = Evt;
        this.DBs = DBs;
    }
}
