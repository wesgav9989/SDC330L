/*
 * Name: Wesley Gavitt
 * Date: 04/09/2026
 * Purpose: This class manages the employee list.
 * It handles adding, removing, updating, and displaying employees.
 */
import java.util.ArrayList;
import java.util.Scanner;
public class EmployeeManager {
    private ArrayList<Employee> employees;

    public EmployeeManager() {
        employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void removeEmployee(int employeeId) {
        Employee employeeToRemove = findEmployeeById(employeeId);

        if (employeeToRemove != null) {
            employees.remove(employeeToRemove);
            System.out.println("Employee removed successfully.");
        } else {
            System.out.println("Employee not found.");
        }
    }

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

    public Employee findEmployeeById(int employeeId) {
        for (Employee employee : employees) {
            if (employee.getEmployeeId() == employeeId) {
                return employee;
            }
        }
        return null;
    }

    public void displayAllEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees to display.");
            return;
        }

        System.out.println("\nAll Employees");
        System.out.println("----------------------------------------");

        // Polymorphism: each Employee object uses its own version of displayInfo
        for (Employee employee : employees) {
            employee.displayInfo();
        }
    }

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
