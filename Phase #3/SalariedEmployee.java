/*
 * Name: Wesley Gavitt
 * Date: 04/26/2026
 * Purpose: Child class of Employee for salaried employees.
 * This file demonstrates inheritance by extending Employee.
 * It also demonstrates polymorphism by overriding calculatePay
 * and displayInfo.
 */
public class SalariedEmployee extends Employee {

    private double annualSalary;

    // Default constructor
    public SalariedEmployee() {
        super();
        annualSalary = 0;
    }

    // Overloaded constructor
    public SalariedEmployee(int id, String first,
            String last, Address address,
            double annualSalary) {

        super(id, first, last, address);
        this.annualSalary = annualSalary;
    }

    // Monthly pay calculation
    public double calculatePay() {
        return annualSalary / 12;
    }

    // Overrides parent method
    public void displayInfo() {
        super.displayInfo();
        System.out.printf("Annual Salary: $%.2f%n",
                annualSalary);
        System.out.println("----------------------");
    }
}