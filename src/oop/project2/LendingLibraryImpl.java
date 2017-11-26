package oop.project2;

import java.awt.EventQueue;

public class LendingLibraryImpl {

	/**
	 * Launch the application.
	 */ 
	public static void main(String[] args) { 
            DBThread          DBs = new DBThread();
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
	}
}
