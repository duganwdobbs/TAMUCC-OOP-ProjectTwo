package oop.project2;

import java.awt.EventQueue;

/**
 * 
 * This class launches the GUI and runs
 * the threads listening for input.
 * @authors ddobbs jshaak
 */ 
public class LendingLibraryImpl {

	public static void main(String[] args) { 
            // Initialize runnable objects
            DBThread          DBs = new DBThread();
            InputBuilder      Inp = new InputBuilder();
            EventBuilder      Evt = new EventBuilder();
            
            // Thread the runnable objects
            Thread DB = new Thread(DBs);
            Thread In = new Thread(Inp);
            Thread Ev = new Thread(Evt);
            // Put them in an array
            Thread[] threads = {DB,In,Ev};
            
            // Invoke the GUI
            EventQueue.invokeLater(new Runnable() {
 			public void run() {
 				try {
 					LendingLibraryGUI GUI = new LendingLibraryGUI(DBs,Inp,Evt);
 					GUI.setVisible(true);
 				} catch (Exception e) {
 					e.printStackTrace();
 				}
 			}
 		});
            
            // Associate the objects
            DBs.associate(DBs,Inp,Evt);
            Evt.associate(DBs,Inp,Evt);
            
            // Start the threads
            for(Thread t: threads){
                t.start();
            }
            
            // Show the GUI
            DBs.display();
            
            //Wait for everything to close.
	}
}
