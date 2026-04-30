/*
 * Name: Wesley Gavitt
 * Course: SDC330L
 * Date: 04/29/2026
 * Purpose: Child class for commission employees.
 * This class demonstrates inheritance and polymorphism.
 */

public class CommissionEmployee extends Employee {

    // Private fields protect commission pay data
    private double salesAmount;
    private double commissionRate;

    /*
     * Default constructor creates a commission employee with default values.
     */
    public CommissionEmployee() {
        super();
        salesAmount = 0;
        commissionRate = 0;
    }

    /*
     * Overloaded constructor creates a commission employee with specific values.
     */
    public CommissionEmployee(int id, String first, String last, Address address,
                              double salesAmount, double commissionRate) {
        super(id, first, last, address);
        this.salesAmount = salesAmount;
        this.commissionRate = commissionRate;
    }

    /*
     * Getter methods used by DatabaseManager when saving commission employee data.
     */
    public double getSalesAmount() {
        return salesAmount;
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    /*
     * Calculates pay by multiplying sales amount by commission rate.
     */
    @Override
    public double calculatePay() {
        return salesAmount * commissionRate;
    }

    /*
     * Displays commission employee information.
     */
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.printf("Sales Amount: $%.2f%n", salesAmount);
        System.out.printf("Commission Rate: %.2f%n", commissionRate);
        System.out.println("----------------------------------------");
    }
}