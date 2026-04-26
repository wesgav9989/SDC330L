/*
 * Name: Wesley Gavitt
 * Date: 04/26/2026
 * Purpose: Child class of Employee for commission employees.
 * This file demonstrates inheritance by extending Employee.
 * It also demonstrates polymorphism by overriding calculatePay
 * and displayInfo.
 */
public class CommissionEmployee extends Employee {

    private double salesAmount;
    private double commissionRate;

    public CommissionEmployee() {
        super();
        salesAmount = 0;
        commissionRate = 0;
    }

    public CommissionEmployee(int id, String first,
            String last, Address address,
            double salesAmount,
            double commissionRate) {

        super(id, first, last, address);
        this.salesAmount = salesAmount;
        this.commissionRate = commissionRate;
    }

    public double calculatePay() {
        return salesAmount * commissionRate;
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.printf("Sales Amount: $%.2f%n",
                salesAmount);
        System.out.printf("Commission Rate: %.2f%n",
                commissionRate);
        System.out.println("----------------------");
    }
}