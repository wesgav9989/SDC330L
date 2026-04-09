/*
 * Name: Wesley Gavitt
 * Date: 04/09/2026
 * Purpose: Abstract base class for all employees.
 * This file demonstrates abstraction because Employee is not meant
 * to be created directly. It also works with inheritance because
 * child classes extend this class.
 */

public abstract class Employee implements Displayable {
    private int employeeId;
    private String firstName;
    private String lastName;

    // Composition: each Employee has an Address object
    private Address address;

    public Employee(int employeeId, String firstName, String lastName, Address address) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public abstract double calculatePay();

    @Override
    public void displayInfo() {
        System.out.println("ID: " + employeeId);
        System.out.println("Name: " + getFullName());
        System.out.println("Address: " + address);
        System.out.println("Employee Type: " + getClass().getSimpleName());
        System.out.printf("Calculated Pay: $%.2f%n", calculatePay());
    }
}
