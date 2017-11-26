package oop.project2;

import java.awt.EventQueue;

public class LendingLibraryImpl {
    LendingLibraryGUI GUI;
    DBThread          DBs;
    InputBuilder      Inp;
    EventBuilder      Evt;

	/**
	 * Launch the application.
	 */ 
	public static void main(String[] args) { 
            LendingLibraryImpl session = new LendingLibraryImpl();
            session.init();
            session.start();
	}
        
        public LendingLibraryImpl(){
            DBs = new DBThread();
            Inp = new InputBuilder();
            Evt = new EventBuilder();
            EventQueue.invokeLater(new Runnable() {
 			public void run() {
 				try {
 					GUI = new LendingLibraryGUI(DBs,Inp,Evt);
 					GUI.setVisible(true);
 				} catch (Exception e) {
 					e.printStackTrace();
 				}
 			}
 		});
        }
        
        public void init(){
            DBs.associate(DBs,Inp,Evt);
            Evt.associate(DBs,Inp,Evt);
        }
        
        public void start(){
            
            EventQueue.invokeLater(DBs);
            EventQueue.invokeLater(Inp);
            EventQueue.invokeLater(Evt);
        }
}
