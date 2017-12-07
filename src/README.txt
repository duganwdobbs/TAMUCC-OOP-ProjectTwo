User Guide for the Library Interface

The main method is contained in LendingLibraryImpl.java

INPUT: The user can either type the bar code numbers by hand or use a scanner on the bar code. The program starts a 5 second buffer window by default for intput, so the user must scan his id and then the book within 5 seconds or the scan will be rejected. 

It is important to note that while the focus is on the search text box, the scan will not work. 

We can provide a scanner, but keyboard input will work as well.

To adjust the amount of time before the input stream is rejected, adjust the variable final long TIMEOUT_PERIOD in file EventBuilder.java
