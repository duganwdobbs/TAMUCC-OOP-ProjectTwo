package oop.project2;

/**
 *
 * @author ddobbs
 */
interface LibRunnable extends Runnable{
    public abstract void associate(GUIThread GUI, DBThread DBs, InputBuilder Inp, EventBuilder Evt);
}
