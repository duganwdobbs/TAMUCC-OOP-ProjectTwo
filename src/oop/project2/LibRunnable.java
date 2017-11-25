package oop.project2;

/**
 *
 * @author ddobbs
 */
interface LibRunnable extends Runnable{
    public abstract void associate(LendingLibraryGUI GUI, DBThread DBs, InputBuilder Inp, EventBuilder Evt);
}
