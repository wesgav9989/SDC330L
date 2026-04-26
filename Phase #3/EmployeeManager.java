/*
 * Name: Wesley Gavitt
 * Date: 04/26/2026
 * Purpose: This class manages the employee list.
 * It handles adding, removing, updating, and displaying employees.
 * This file also demonstrates polymorphism when Employee objects
 * are displayed through shared method calls.
 */
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeManager {

    private ArrayList<Employee> employees;

    // Constructor
    public EmployeeManager() {
        employees = new ArrayList<Employee>();
    }

    // Add employee
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    // Adds sample employee
    public void addSampleEmployee() {

        employees.add(new SalariedEmployee(
                2001,
                "New",
                "Employee",
                new Address("1 Test St",
                "Hopewell", "VA", "23860"),
                55000));

        System.out.println("Sample employee added.");
    }

    // Remove employee
    public void removeEmployee(int id) {

        Employee employee = findEmployeeById(id);

        if (employee != null) {
            employees.remove(employee);
            System.out.println("Employee removed.");
        } else {
            System.out.println("Employee not found.");
        }
    }

    // Search by ID
    public Employee findEmployeeById(int id) {

        for (Employee employee : employees) {
            if (employee.getEmployeeId() == id) {
                return employee;
            }
        }

        return null;
    }

    // Update name
    public void updateEmployeeName(int id,
                                   Scanner input) {

        Employee employee = findEmployeeById(id);

        if (employee != null) {

            System.out.print("Enter first name: ");
            employee.setFirstName(input.nextLine());

            System.out.print("Enter last name: ");
            employee.setLastName(input.nextLine());

            System.out.println("Employee updated.");
        } else {
            System.out.println("Employee not found.");
        }
    }

    // Display all employees
    public void displayAllEmployees() {

        for (Employee employee : employees) {
            employee.displayInfo();
        }
    }

    // Display by type
    public void displayEmployeesByType(String type) {

        for (Employee employee : employees) {

            if (employee.getClass()
                    .getSimpleName()
                    .toLowerCase()
                    .contains(type.toLowerCase())) {

                employee.displayInfo();
            }
        }
    }
}