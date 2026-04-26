/*
 * Name: Wesley Gavitt
 * Date: 04/26/2026
 * Purpose: Child class of Employee for hourly employees.
 * This file demonstrates inheritance by extending Employee.
 * It also demonstrates polymorphism by overriding calculatePay
 * and displayInfo.
 */
public class HourlyEmployee extends Employee {

    private double hourlyRate;
    private double hoursWorked;

    public HourlyEmployee() {
        super();
        hourlyRate = 0;
        hoursWorked = 0;
    }

    public HourlyEmployee(int id, String first,
            String last, Address address,
            double hourlyRate,
            double hoursWorked) {

        super(id, first, last, address);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    public double calculatePay() {
        return hourlyRate * hoursWorked;
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.printf("Hourly Rate: $%.2f%n",
                hourlyRate);
        System.out.printf("Hours Worked: %.2f%n",
                hoursWorked);
        System.out.println("----------------------");
    }
}