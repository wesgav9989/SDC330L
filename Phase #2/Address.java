/*
 * Name: Wesley Gavitt
 * Date: 04/14/2026
 * Purpose: Class used to store address information for an employee.
 * This file demonstrates composition because an Employee object
 * contains an Address object.
 */

public class Address {
    private String street;
    private String city;
    private String state;
    private String zipCode;

    /**
     * Creates an Address object with the employee's street, city, state, and zip code.
     *
     * @param street the street address
     * @param city the city
     * @param state the state
     * @param zipCode the zip code
     */
    public Address(String street, String city, String state, String zipCode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    /**
     * Returns the full address as a formatted string.
     *
     * @return the complete address
     */
    @Override
    public String toString() {
        return street + ", " + city + ", " + state + " " + zipCode;
    }
}
