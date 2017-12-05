package oop.project2;

/**
 * This interface extends Runnable, so we can make threadable objects, however,
 * it also provides an associate method so that the classes can associate with
 * each other.
 * @author ddobbs
 */
interface LibRunnable extends Runnable{
    public abstract void associate(DBThread DBs, InputBuilder Inp, EventBuilder Evt);
}
