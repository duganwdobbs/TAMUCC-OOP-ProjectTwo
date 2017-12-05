package oop.project2.libevent;

/**
 * A basic implementation that says all of our Event and Error objects need to
 * be parsable, aka have a getSummary function. This could be emulated by a
 * toString(), but in some situations we wanted to provide different information
 * @author ddobbs
 */
public interface LibParsable {
    public abstract String getSummary();
}
