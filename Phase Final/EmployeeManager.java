/*
 * Name: Wesley Gavitt
 * Course: SDC330L
 * Date: 5/6/2026
 * Purpose: Handles employee-related features for the
 * Employee Management Application.
 * This class connects menu actions to database operations.
 */

import java.util.Scanner;

public class EmployeeManager {

    // DatabaseManager object used for CRUD operations
    private DatabaseManager database;

    /*
     * Constructor receives a DatabaseManager object.
     */
    public EmployeeManager(DatabaseManager database) {

        this.database = database;
    }

    /*
     * Collects employee information from the user
     * and stores the employee in the SQLite database.
     */
    public void addEmployeeFromUser(Scanner input) {

        try {

            // Collect shared employee data
            System.out.print("Enter employee ID: ");
            int id =
                    Integer.parseInt(
                            input.nextLine());

            System.out.print("Enter first name: ");
            String firstName =
                    input.nextLine();

            System.out.print("Enter last name: ");
            String lastName =
                    input.nextLine();

            System.out.print("Enter street: ");
            String street =
                    input.nextLine();

            System.out.print("Enter city: ");
            String city =
                    input.nextLine();

            System.out.print("Enter state: ");
            String state =
                    input.nextLine();

            System.out.print("Enter zip code: ");
            String zipCode =
                    input.nextLine();

            // Create Address object
            Address address =
                    new Address(
                            street,
                            city,
                            state,
                            zipCode);

            // Determine employee type
            System.out.print(
                    "Enter employee type "
                            + "(Salaried, Hourly, Commission): ");

            String type =
                    input.nextLine()
                            .trim()
                            .toLowerCase();

            /*
             * Create correct employee subclass
             * based on user selection.
             */
            if (type.equals("salaried")) {

                System.out.print(
                        "Enter annual salary: ");

                double salary =
                        Double.parseDouble(
                                input.nextLine());

                SalariedEmployee employee =
                        new SalariedEmployee(
                                id,
                                firstName,
                                lastName,
                                address,
                                salary);

                database.insertEmployee(employee);

            } else if (type.equals("hourly")) {

                System.out.print(
                        "Enter hourly rate: ");

                double rate =
                        Double.parseDouble(
                                input.nextLine());

                System.out.print(
                        "Enter hours worked: ");

                double hours =
                        Double.parseDouble(
                                input.nextLine());

                HourlyEmployee employee =
                        new HourlyEmployee(
                                id,
                                firstName,
                                lastName,
                                address,
                                rate,
                                hours);

                database.insertEmployee(employee);

            } else if (type.equals("commission")) {

                System.out.print(
                        "Enter sales amount: ");

                double sales =
                        Double.parseDouble(
                                input.nextLine());

                System.out.print(
                        "Enter commission rate: ");

                double commissionRate =
                        Double.parseDouble(
                                input.nextLine());

                CommissionEmployee employee =
                        new CommissionEmployee(
                                id,
                                firstName,
                                lastName,
                                address,
                                sales,
                                commissionRate);

                database.insertEmployee(employee);

            } else {

                System.out.println(
                        "Invalid employee type.");
            }

        } catch (NumberFormatException e) {

            System.out.println(
                    "Invalid number entered.");
        }
    }

    /*
     * Adds an employee object directly into the database.
     * Used for sample employee creation.
     */
    public void addEmployeeDirectly(Employee employee) {

        database.insertEmployee(employee);
    }

    /*
     * Displays all employee records stored in the database.
     */
    public void displayAllEmployees() {

        database.displayAllEmployees();
    }

    /*
     * Displays one employee based on employee ID.
     */
    public void displayEmployeeById(int employeeId) {

        database.displayEmployeeById(employeeId);
    }

    /*
     * Updates an employee's first and last name.
     */
    public void updateEmployeeName(
            int employeeId,
            Scanner input) {

        // Collect updated name information
        System.out.print(
                "Enter new first name: ");

        String firstName =
                input.nextLine();

        System.out.print(
                "Enter new last name: ");

        String lastName =
                input.nextLine();

        // Send updated data to database
        database.updateEmployeeName(
                employeeId,
                firstName,
                lastName);
    }

    /*
     * Removes an employee from the database.
     */
    public void removeEmployee(int employeeId) {

        database.deleteEmployee(employeeId);
    }
}