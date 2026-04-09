/*
 * Name: Wesley Gavitt
 * Date: 04/09/2026
 * Purpose: Class used to store address information for an employee.
 * This file demonstrates composition because an Employee object
 * contains an Address object.
 */

public class Address {
    private String street;
    private String city;
    private String state;
    private String zipCode;

    public Address(String street, String city, String state, String zipCode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return street + ", " + city + ", " + state + " " + zipCode;
    }
}
