User Guide for the Library Interface

The main method is contained in LendingLibraryImpl.java

INPUT: The user can either type the bar code numbers by hand or use a scanner on the bar code.
The event listens for input for 5 seconds, so the user must scan his id and the book within 5 seconds
or the event will not register. It is important to note that while the focus is on the search text box, 
the scan will not work. 

We can provide a scanner, but keyboard input will work as well.

To adjust the amount of time the listener listens for, adjust the variable final long TIMEOUT_PERIOD
in file EventBuilder.java
