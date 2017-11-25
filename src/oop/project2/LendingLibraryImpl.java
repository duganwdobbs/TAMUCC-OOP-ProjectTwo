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
	public static void main() {
            LendingLibraryImpl session = new LendingLibraryImpl();
            session.init();
            session.start();
	}
        
        public LendingLibraryImpl(){
            GUI = new LendingLibraryGUI();
            DBs = new DBThread();
            Inp = new InputBuilder();
            Evt = new EventBuilder();
        }
        
        public void init(){
            GUI.associate(GUI,DBs,Inp,Evt);
            DBs.associate(GUI,DBs,Inp,Evt);
            Evt.associate(GUI,DBs,Inp,Evt);
        }
        
        public void start(){
            EventQueue.invokeLater(GUI);
            EventQueue.invokeLater(DBs);
            EventQueue.invokeLater(Inp);
            EventQueue.invokeLater(Evt);
        }
}
