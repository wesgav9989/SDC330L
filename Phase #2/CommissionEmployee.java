/*
 * Name: Wesley Gavitt
 * Date: 04/14/2026
 * Purpose: Child class of Employee for commission employees.
 * This file demonstrates inheritance by extending Employee.
 * It also demonstrates polymorphism by overriding calculatePay
 * and displayInfo.
 */

public class CommissionEmployee extends Employee {
    private double salesAmount;
    private double commissionRate;

    /**
     * Creates a CommissionEmployee object with sales and commission information.
     *
     * @param employeeId the employee ID
     * @param firstName the employee's first name
     * @param lastName the employee's last name
     * @param address the employee's address
     * @param salesAmount the total sales amount
     * @param commissionRate the commission rate
     */
    public CommissionEmployee(int employeeId, String firstName, String lastName, Address address,
                              double salesAmount, double commissionRate) {
        super(employeeId, firstName, lastName, address);
        this.salesAmount = salesAmount;
        this.commissionRate = commissionRate;
    }

    /**
     * Returns the sales amount.
     *
     * @return the sales amount
     */
    public double getSalesAmount() {
        return salesAmount;
    }

    /**
     * Returns the commission rate.
     *
     * @return the commission rate
     */
    public double getCommissionRate() {
        return commissionRate;
    }

    /**
     * Calculates pay for a commission employee.
     * Pay is based on the total sales multiplied by the commission rate.
     *
     * @return the calculated pay amount
     */
    @Override
    public double calculatePay() {
        return salesAmount * commissionRate;
    }

    /**
     * Displays the commission employee's information.
     * This method extends the shared displayInfo method from Employee.
     */
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.printf("Sales Amount: $%.2f%n", salesAmount);
        System.out.printf("Commission Rate: %.2f%n", commissionRate);
        System.out.println("----------------------------------------");
    }
}