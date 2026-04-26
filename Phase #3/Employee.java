/*
 * Name: Wesley Gavitt
 * Date: 04/26/2026
 * Purpose: Abstract base class for all employees.
 * This file demonstrates abstraction because Employee is not meant
 * to be created directly. It also works with inheritance because
 * child classes extend this class and share common employee data.
 */
public abstract class Employee implements Displayable {

    // Private fields for encapsulation
    private int employeeId;
    private String firstName;
    private String lastName;
    private Address address;

    // Default constructor
    public Employee() {
        employeeId = 0;
        firstName = "Unknown";
        lastName = "Unknown";
        address = new Address();
    }

    // Overloaded constructor
    public Employee(int employeeId, String firstName,
                    String lastName, Address address) {

        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    // Getter method
    public int getEmployeeId() {
        return employeeId;
    }

    // Combines first and last name
    public String getFullName() {
        return firstName + " " + lastName;
    }

    // Setter methods
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Abstract method must be overridden
    public abstract double calculatePay();

    // Shared display method
    public void displayInfo() {
        System.out.println("ID: " + employeeId);
        System.out.println("Name: " + getFullName());
        System.out.println("Address: " + address);
        System.out.println("Type: "
                + getClass().getSimpleName());
        System.out.printf("Pay: $%.2f%n",
                calculatePay());
    }
}