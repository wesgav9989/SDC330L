/*
 * Name: Wesley Gavitt
 * Date: 04/09/2026
 * Purpose: Child class of Employee for hourly employees.
 * This file demonstrates inheritance by extending Employee.
 * It also demonstrates polymorphism by overriding calculatePay.
 */

public class HourlyEmployee extends Employee {
    private double hourlyRate;
    private double hoursWorked;

    public HourlyEmployee(int employeeId, String firstName, String lastName, Address address,
                          double hourlyRate, double hoursWorked) {
        super(employeeId, firstName, lastName, address);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    @Override
    public double calculatePay() {
        return hourlyRate * hoursWorked;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.printf("Hourly Rate: $%.2f%n", hourlyRate);
        System.out.printf("Hours Worked: %.2f%n", hoursWorked);
        System.out.println("----------------------------------------");
    }
}
