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
        
        //ParseEvent Queue -> Database
        
        //DBEvent    Queue -> EventBuilder
        
        //ResultVec  Vect  -> GUI
        
        //GUI <-> Database; Searching
    }
}
