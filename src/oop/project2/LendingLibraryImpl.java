package oop.project2;

import java.awt.EventQueue;

/**
 * This class launches the GUI and runs
 * the threads listening for input. 
 */ 
public class LendingLibraryImpl {

	public static void main(String[] args) { 
            DBThread          DBs = new DBThread();
            // This is a comment
            InputBuilder      Inp = new InputBuilder();
            EventBuilder      Evt = new EventBuilder();
            
            Thread DB = new Thread(DBs);
            Thread In = new Thread(Inp);
            Thread Ev = new Thread(Evt);
            Thread[] threads = {DB,In,Ev};
            
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
            
            DBs.associate(DBs,Inp,Evt);
            Evt.associate(DBs,Inp,Evt);
            
            for(Thread t: threads){
                t.start();
            }
            
            DBs.display();
	}
}
