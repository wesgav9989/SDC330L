/*
 * Name: Wesley Gavitt
 * Date: 04/14/2026
 * Purpose: Abstract base class for all employees.
 * This file demonstrates abstraction because Employee is not meant
 * to be created directly. It also works with inheritance because
 * child classes extend this class and share common employee data.
 */

public abstract class Employee implements Displayable {
    private int employeeId;
    private String firstName;
    private String lastName;

    // Composition: each Employee has an Address object
    private Address address;

    /**
     * Creates an Employee object with shared employee information.
     *
     * @param employeeId the employee ID number
     * @param firstName the employee's first name
     * @param lastName the employee's last name
     * @param address the employee's address
     */
    public Employee(int employeeId, String firstName, String lastName, Address address) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    /**
     * Returns the employee ID.
     *
     * @return the employee ID
     */
    public int getEmployeeId() {
        return employeeId;
    }

    /**
     * Returns the employee's first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Updates the employee's first name.
     *
     * @param firstName the new first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns the employee's last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Updates the employee's last name.
     *
     * @param lastName the new last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Returns the employee's address object.
     *
     * @return the address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Combines the employee's first and last name into one full name.
     *
     * @return the employee's full name
     */
    public String getFullName() {
        return firstName + " " + lastName;
    }

    /**
     * Abstract method that must be defined by each child class.
     * This demonstrates polymorphism because each employee type
     * calculates pay differently.
     *
     * @return the calculated pay amount
     */
    public abstract double calculatePay();

    /**
     * Displays the shared employee information.
     * Child classes extend this method to add their own details.
     */
    @Override
    public void displayInfo() {
        System.out.println("ID: " + employeeId);
        System.out.println("Name: " + getFullName());
        System.out.println("Address: " + address);
        System.out.println("Employee Type: " + getClass().getSimpleName());
        System.out.printf("Calculated Pay: $%.2f%n", calculatePay());
    }
}