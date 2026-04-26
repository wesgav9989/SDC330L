/*
 * Name: Wesley Gavitt
 * Date: 04/26/2026
 * Purpose: Class used to store address information for an employee.
 * This file demonstrates composition because an Employee object
 * contains an Address object.
 */
public class Address {

    // Private fields for encapsulation
    private String street;
    private String city;
    private String state;
    private String zipCode;

    // Default constructor
    public Address() {
        street = "Unknown";
        city = "Unknown";
        state = "NA";
        zipCode = "00000";
    }

    // Overloaded constructor
    public Address(String street, String city,
                   String state, String zipCode) {

        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    // Returns full formatted address
    public String toString() {
        return street + ", " + city + ", "
                + state + " " + zipCode;
    }
}