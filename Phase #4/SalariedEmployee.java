/*
 * Name: Wesley Gavitt
 * Course: SDC330L
 * Date: 04/29/2026
 * Purpose: Child class for salaried employees.
 * This class demonstrates inheritance and polymorphism.
 */

public class SalariedEmployee extends Employee {

    // Private field protects salary data
    private double annualSalary;

    /*
     * Default constructor creates a salaried employee with default values.
     */
    public SalariedEmployee() {
        super();
        annualSalary = 0;
    }

    /*
     * Overloaded constructor creates a salaried employee with specific values.
     */
    public SalariedEmployee(int id, String first, String last, Address address, double annualSalary) {
        super(id, first, last, address);
        this.annualSalary = annualSalary;
    }

    /*
     * Getter used by DatabaseManager when saving salaried employee data.
     */
    public double getAnnualSalary() {
        return annualSalary;
    }

    /*
     * Calculates monthly pay by dividing yearly salary by 12.
     */
    @Override
    public double calculatePay() {
        return annualSalary / 12;
    }

    /*
     * Displays salaried employee information.
     */
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.printf("Annual Salary: $%.2f%n", annualSalary);
        System.out.println("----------------------------------------");
    }
}