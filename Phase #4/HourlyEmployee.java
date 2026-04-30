/*
 * Name: Wesley Gavitt
 * Course: SDC330L
 * Date: 04/29/2026
 * Purpose: Child class for hourly employees.
 * This class demonstrates inheritance and polymorphism.
 */

public class HourlyEmployee extends Employee {

    // Private fields protect hourly pay data
    private double hourlyRate;
    private double hoursWorked;

    /*
     * Default constructor creates an hourly employee with default values.
     */
    public HourlyEmployee() {
        super();
        hourlyRate = 0;
        hoursWorked = 0;
    }

    /*
     * Overloaded constructor creates an hourly employee with specific values.
     */
    public HourlyEmployee(int id, String first, String last, Address address,
                          double hourlyRate, double hoursWorked) {
        super(id, first, last, address);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    /*
     * Getter methods used by DatabaseManager when saving hourly employee data.
     */
    public double getHourlyRate() {
        return hourlyRate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    /*
     * Calculates pay by multiplying hourly rate by hours worked.
     */
    @Override
    public double calculatePay() {
        return hourlyRate * hoursWorked;
    }

    /*
     * Displays hourly employee information.
     */
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.printf("Hourly Rate: $%.2f%n", hourlyRate);
        System.out.printf("Hours Worked: %.2f%n", hoursWorked);
        System.out.println("----------------------------------------");
    }
}