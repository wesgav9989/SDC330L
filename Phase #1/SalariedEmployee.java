/*
 * Name: Wesley Gavitt
 * Date: 04/09/2026
 * Purpose: Child class of Employee for salaried employees.
 * This file demonstrates inheritance by extending Employee.
 * It also demonstrates polymorphism by overriding calculatePay.
 */

public class SalariedEmployee extends Employee {
    private double annualSalary;

    public SalariedEmployee(int employeeId, String firstName, String lastName, Address address, double annualSalary) {
        super(employeeId, firstName, lastName, address);
        this.annualSalary = annualSalary;
    }

    public double getAnnualSalary() {
        return annualSalary;
    }

    @Override
    public double calculatePay() {
        return annualSalary / 12.0;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.printf("Annual Salary: $%.2f%n", annualSalary);
        System.out.println("----------------------------------------");
    }
}
