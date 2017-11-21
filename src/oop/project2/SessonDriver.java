package oop.project2;

import javax.swing.JFrame;

/**
 *
 * @author ddobbs
 */
public class SessonDriver extends JFrame{
    private DBThread sys_db;
    private InputBuilder build_inp;
    private EventBuilder build_evt;
    //private Gui thing here.
    
    
    public SessonDriver(){
        super("Library Window");
        //gui = new GUI();
        //add(gui);
        
        //Setup References...
        
        //InputEvent Queue -> EventBuilder
        build_evt.setInputBuilder(build_inp);
        //DBEvent    Queue -> EventBuilder
        build_evt.setDBThread(sys_db);
        //ParseEvent Queue -> Database
        sys_db.setEventBuilder(build_evt);
        //sys_db.setGUI(gui);
        //GUI <-> Database; Searching
        //gui.setDBThread(sys_db);
        //ResultVec  Vect  -> GUI
        //gui.setEventBuilder(build_evt);
    }
}
