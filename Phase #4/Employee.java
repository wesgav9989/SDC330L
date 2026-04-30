/*
 * Name: Wesley Gavitt
 * Course: SDC330L
 * Date: 04/29/2026
 * Purpose: Abstract parent class for all employee types.
 * This class demonstrates abstraction, inheritance, constructors, and access specifiers.
 */

public abstract class Employee implements Displayable {

    // Private fields demonstrate encapsulation
    private int employeeId;
    private String firstName;
    private String lastName;
    private Address address;

    /*
     * Default constructor creates an employee with placeholder values.
     */
    public Employee() {
        employeeId = 0;
        firstName = "Unknown";
        lastName = "Unknown";
        address = new Address();
    }

    /*
     * Overloaded constructor creates an employee with realistic values.
     */
    public Employee(int employeeId, String firstName, String lastName, Address address) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    // Getter methods provide public read access to private fields
    public int getEmployeeId() {
        return employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Address getAddress() {
        return address;
    }

    /*
     * Combines first and last name into one full name.
     */
    public String getFullName() {
        return firstName + " " + lastName;
    }

    // Setter methods allow controlled updates
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /*
     * Abstract method forces each child class to calculate pay differently.
     */
    public abstract double calculatePay();

    /*
     * Shared display method used by all employee types.
     */
    @Override
    public void displayInfo() {
        System.out.println("ID: " + employeeId);
        System.out.println("Name: " + getFullName());
        System.out.println("Address: " + address);
        System.out.println("Type: " + getClass().getSimpleName());
        System.out.printf("Calculated Pay: $%.2f%n", calculatePay());
    }
}