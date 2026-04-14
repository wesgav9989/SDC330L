/*
 * Name: Wesley Gavitt
 * Date: 04/14/2026
 * Purpose: Child class of Employee for salaried employees.
 * This file demonstrates inheritance by extending Employee.
 * It also demonstrates polymorphism by overriding calculatePay
 * and displayInfo.
 */

public class SalariedEmployee extends Employee {
    private double annualSalary;

    /**
     * Creates a SalariedEmployee object with salary information.
     *
     * @param employeeId the employee ID
     * @param firstName the employee's first name
     * @param lastName the employee's last name
     * @param address the employee's address
     * @param annualSalary the employee's yearly salary
     */
    public SalariedEmployee(int employeeId, String firstName, String lastName, Address address, double annualSalary) {
        super(employeeId, firstName, lastName, address);
        this.annualSalary = annualSalary;
    }

    /**
     * Returns the employee's annual salary.
     *
     * @return the annual salary
     */
    public double getAnnualSalary() {
        return annualSalary;
    }

    /**
     * Calculates monthly pay for a salaried employee.
     * The annual salary is divided by 12 months.
     *
     * @return the monthly pay amount
     */
    @Override
    public double calculatePay() {
        return annualSalary / 12.0;
    }

    /**
     * Displays the salaried employee's information.
     * This method extends the shared displayInfo method from Employee.
     */
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.printf("Annual Salary: $%.2f%n", annualSalary);
        System.out.println("----------------------------------------");
    }
}