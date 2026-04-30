/*
 * Name: Wesley Gavitt
 * Course: SDC330L
 * Date: 04/29/2026
 * Purpose: Stores address information for an employee.
 * This class demonstrates composition because an Employee has an Address object.
 */

public class Address {

    // Private fields protect address data from direct outside access
    private String street;
    private String city;
    private String state;
    private String zipCode;

    /*
     * Default constructor creates an Address with placeholder values.
     */
    public Address() {
        street = "Unknown";
        city = "Unknown";
        state = "NA";
        zipCode = "00000";
    }

    /*
     * Overloaded constructor creates an Address using specific values.
     */
    public Address(String street, String city, String state, String zipCode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    // Getter methods allow controlled access to private fields
    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }

    /*
     * Returns the address in a readable format.
     */
    @Override
    public String toString() {
        return street + ", " + city + ", " + state + " " + zipCode;
    }
}
