/*
 * Name: Wesley Gavitt
 * Date: 04/14/2026
 * Purpose: Interface used to require a displayInfo method.
 * This interface demonstrates abstraction by defining behavior
 * that multiple classes can implement in their own way.
 */

public interface Displayable {

    /**
     * Displays information about an object.
     * This method supports polymorphism because different classes
     * can provide their own version of how information is displayed.
     */
    void displayInfo();
}
