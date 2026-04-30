/*
 * Name: Wesley Gavitt
 * Course: SDC330L
 * Date: 04/29/2026
 * Purpose: Connects user menu actions to employee database operations.
 * This class helps keep App.java cleaner and easier to read.
 */

import java.util.Scanner;

public class EmployeeManager {

    // DatabaseManager object used to store and retrieve employee records
    private DatabaseManager database;

    /*
     * Constructor receives a DatabaseManager object.
     */
    public EmployeeManager(DatabaseManager database) {
        this.database = database;
    }

    /*
     * Collects employee information from the user and creates the correct employee type.
     */
    public void addEmployeeFromUser(Scanner input) {
        try {
            System.out.print("Enter employee ID: ");
            int id = Integer.parseInt(input.nextLine());

            System.out.print("Enter first name: ");
            String firstName = input.nextLine();

            System.out.print("Enter last name: ");
            String lastName = input.nextLine();

            System.out.print("Enter street: ");
            String street = input.nextLine();

            System.out.print("Enter city: ");
            String city = input.nextLine();

            System.out.print("Enter state: ");
            String state = input.nextLine();

            System.out.print("Enter zip code: ");
            String zipCode = input.nextLine();

            Address address = new Address(street, city, state, zipCode);

            System.out.print("Enter employee type (Salaried, Hourly, Commission): ");
            String type = input.nextLine().trim().toLowerCase();

            // Create the correct subclass based on employee type
            if (type.equals("salaried")) {
                System.out.print("Enter annual salary: ");
                double salary = Double.parseDouble(input.nextLine());

                database.insertEmployee(new SalariedEmployee(id, firstName, lastName, address, salary));

            } else if (type.equals("hourly")) {
                System.out.print("Enter hourly rate: ");
                double rate = Double.parseDouble(input.nextLine());

                System.out.print("Enter hours worked: ");
                double hours = Double.parseDouble(input.nextLine());

                database.insertEmployee(new HourlyEmployee(id, firstName, lastName, address, rate, hours));

            } else if (type.equals("commission")) {
                System.out.print("Enter sales amount: ");
                double sales = Double.parseDouble(input.nextLine());

                System.out.print("Enter commission rate: ");
                double commissionRate = Double.parseDouble(input.nextLine());

                database.insertEmployee(new CommissionEmployee(id, firstName, lastName, address, sales, commissionRate));

            } else {
                System.out.println("Invalid employee type. Employee was not added.");
            }

        } catch (NumberFormatException e) {
            System.out.println("Invalid number entered. Employee was not added.");
        }
    }

    /*
     * Displays all employees from the database.
     */
    public void displayAllEmployees() {
        database.displayAllEmployees();
    }

    /*
     * Displays one employee from the database by employee ID.
     */
    public void displayEmployeeById(int employeeId) {
        database.displayEmployeeById(employeeId);
    }

    /*
     * Updates an employee name in the database.
     */
    public void updateEmployeeName(int employeeId, Scanner input) {
        System.out.print("Enter new first name: ");
        String firstName = input.nextLine();

        System.out.print("Enter new last name: ");
        String lastName = input.nextLine();

        database.updateEmployeeName(employeeId, firstName, lastName);
    }

    /*
     * Removes an employee from the database.
     */
    public void removeEmployee(int employeeId) {
        database.deleteEmployee(employeeId);
    }
}