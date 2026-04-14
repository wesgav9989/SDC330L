/*
 * Name: Wesley Gavitt
 * Date: 04/14/2026
 * Purpose: Child class of Employee for hourly employees.
 * This file demonstrates inheritance by extending Employee.
 * It also demonstrates polymorphism by overriding calculatePay
 * and displayInfo.
 */

public class HourlyEmployee extends Employee {
    private double hourlyRate;
    private double hoursWorked;

    /**
     * Creates an HourlyEmployee object with hourly pay information.
     *
     * @param employeeId the employee ID
     * @param firstName the employee's first name
     * @param lastName the employee's last name
     * @param address the employee's address
     * @param hourlyRate the hourly rate of pay
     * @param hoursWorked the number of hours worked
     */
    public HourlyEmployee(int employeeId, String firstName, String lastName, Address address,
                          double hourlyRate, double hoursWorked) {
        super(employeeId, firstName, lastName, address);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    /**
     * Returns the hourly rate.
     *
     * @return the hourly rate
     */
    public double getHourlyRate() {
        return hourlyRate;
    }

    /**
     * Returns the total hours worked.
     *
     * @return the hours worked
     */
    public double getHoursWorked() {
        return hoursWorked;
    }

    /**
     * Calculates pay for an hourly employee.
     * Pay is based on the hourly rate multiplied by hours worked.
     *
     * @return the calculated pay amount
     */
    @Override
    public double calculatePay() {
        return hourlyRate * hoursWorked;
    }

    /**
     * Displays the hourly employee's information.
     * This method extends the shared displayInfo method from Employee.
     */
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.printf("Hourly Rate: $%.2f%n", hourlyRate);
        System.out.printf("Hours Worked: %.2f%n", hoursWorked);
        System.out.println("----------------------------------------");
    }
}