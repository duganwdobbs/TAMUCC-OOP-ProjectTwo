package oop.project2;

/**
 *
 * @author ddobbs
 */
interface LibRunnable extends Runnable{
    public abstract void associate(DBThread DBs, InputBuilder Inp, EventBuilder Evt);
}
