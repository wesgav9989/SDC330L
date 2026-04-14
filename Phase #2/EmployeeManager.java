/*
 * Name: Wesley Gavitt
 * Date: 04/14/2026
 * Purpose: This class manages the employee list.
 * It handles adding, removing, updating, and displaying employees.
 * This file also demonstrates polymorphism when Employee objects
 * are displayed through shared method calls.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeManager {
    private ArrayList<Employee> employees;

    /**
     * Creates an EmployeeManager object and initializes the employee list.
     */
    public EmployeeManager() {
        employees = new ArrayList<>();
    }

    /**
     * Adds an employee object to the list.
     *
     * @param employee the employee to add
     */
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    /**
     * Removes an employee from the list by matching the employee ID.
     * If no employee is found, a message is displayed.
     *
     * @param employeeId the ID of the employee to remove
     */
    public void removeEmployee(int employeeId) {
        Employee employeeToRemove = findEmployeeById(employeeId);

        if (employeeToRemove != null) {
            employees.remove(employeeToRemove);
            System.out.println("Employee removed successfully.");
        } else {
            System.out.println("Employee not found.");
        }
    }

    /**
     * Updates the first and last name of an employee selected by ID.
     * This method asks the user for the new name values.
     *
     * @param employeeId the ID of the employee to update
     * @param input the Scanner object used for user input
     */
    public void updateEmployeeName(int employeeId, Scanner input) {
        Employee employee = findEmployeeById(employeeId);

        if (employee != null) {
            System.out.print("Enter new first name: ");
            String newFirstName = input.nextLine();

            System.out.print("Enter new last name: ");
            String newLastName = input.nextLine();

            employee.setFirstName(newFirstName);
            employee.setLastName(newLastName);

            System.out.println("Employee name updated successfully.");
        } else {
            System.out.println("Employee not found.");
        }
    }

    /**
     * Searches the employee list for a matching ID.
     * Returns the employee object if found, or null if not found.
     *
     * @param employeeId the ID to search for
     * @return the matching employee or null
     */
    public Employee findEmployeeById(int employeeId) {
        for (Employee employee : employees) {
            if (employee.getEmployeeId() == employeeId) {
                return employee;
            }
        }
        return null;
    }

    /**
     * Displays all employees currently stored in the system.
     * This demonstrates polymorphism because each Employee object
     * calls its own version of displayInfo().
     */
    public void displayAllEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees to display.");
            return;
        }

        System.out.println("\nAll Employees");
        System.out.println("----------------------------------------");

        for (Employee employee : employees) {
            employee.displayInfo();
        }
    }

    /**
     * Displays only employees whose class type matches the user input.
     * For example, the user may enter Salaried, Hourly, or Commission.
     *
     * @param type the employee type to display
     */
    public void displayEmployeesByType(String type) {
        boolean found = false;

        System.out.println("\nEmployees of Type: " + type);
        System.out.println("----------------------------------------");

        for (Employee employee : employees) {
            String className = employee.getClass().getSimpleName().toLowerCase();

            if (className.contains(type.toLowerCase())) {
                employee.displayInfo();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No employees found for that type.");
        }
    }
}