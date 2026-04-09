/*
 * Name: Wesley Gavitt
 * Date: 04/09/2026
 * Purpose: Child class of Employee for commission employees.
 * This file demonstrates inheritance by extending Employee.
 * It also demonstrates polymorphism by overriding calculatePay.
 */

public class CommissionEmployee extends Employee {
    private double salesAmount;
    private double commissionRate;

    public CommissionEmployee(int employeeId, String firstName, String lastName, Address address,
                              double salesAmount, double commissionRate) {
        super(employeeId, firstName, lastName, address);
        this.salesAmount = salesAmount;
        this.commissionRate = commissionRate;
    }

    public double getSalesAmount() {
        return salesAmount;
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    @Override
    public double calculatePay() {
        return salesAmount * commissionRate;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.printf("Sales Amount: $%.2f%n", salesAmount);
        System.out.printf("Commission Rate: %.2f%n", commissionRate);
        System.out.println("----------------------------------------");
    }
}
