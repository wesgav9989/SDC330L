/*
 * Name: Wesley Gavitt
 * Course: SDC330L
 * Date: 5/6/2026
 * Purpose: Main class for the Final Employee Management Application.
 * This application demonstrates object-oriented programming concepts
 * and SQLite database integration.
 */

import java.util.Scanner;

public class App {

    /*
     * Main method starts the Employee Management Application.
     */
    public static void main(String[] args) {

        // Scanner object used for user input
        Scanner input = new Scanner(System.in);

        // DatabaseManager handles all database operations
        DatabaseManager database = new DatabaseManager();

        // EmployeeManager handles employee features
        EmployeeManager manager = new EmployeeManager(database);

        // Connect to SQLite database
        database.connect();

        // Create employee table if it does not exist
        database.createTable();

        boolean running = true;

        // Main application loop
        while (running) {

            displayHeader();
            displayMenu();

            System.out.print("\nEnter your choice: ");
            String choice = input.nextLine();

            switch (choice) {

                case "1":
                    manager.addEmployeeFromUser(input);
                    pause(input);
                    break;

                case "2":
                    manager.displayAllEmployees();
                    pause(input);
                    break;

                case "3":
                    System.out.print("Enter employee ID to search: ");
                    int searchId = Integer.parseInt(input.nextLine());

                    manager.displayEmployeeById(searchId);
                    pause(input);
                    break;

                case "4":
                    System.out.print("Enter employee ID to update: ");
                    int updateId = Integer.parseInt(input.nextLine());

                    manager.updateEmployeeName(updateId, input);
                    pause(input);
                    break;

                case "5":
                    System.out.print("Enter employee ID to delete: ");
                    int deleteId = Integer.parseInt(input.nextLine());

                    manager.removeEmployee(deleteId);
                    pause(input);
                    break;

                case "6":
                    addSampleEmployees(manager);
                    pause(input);
                    break;

                case "7":
                    System.out.println("\nThank you for using the Employee Management Application.");
                    running = false;
                    break;

                default:
                    System.out.println("\nInvalid choice. Please try again.");
                    pause(input);
            }
        }

        // Close database connection
        database.close();

        // Close scanner object
        input.close();
    }

    /*
     * Displays application title and instructions.
     */
    public static void displayHeader() {

        System.out.println("\n==================================================");
        System.out.println(" Final Employee Management Application");
        System.out.println(" Wesley Gavitt");
        System.out.println("==================================================");
        System.out.println("This application stores employee data in SQLite.");
        System.out.println("Use the menu below to create, view, update,");
        System.out.println("or delete employee records.");
    }

    /*
     * Displays the application menu.
     */
    public static void displayMenu() {

        System.out.println("\n1. Add Employee");
        System.out.println("2. Display All Employees");
        System.out.println("3. Display Employee by ID");
        System.out.println("4. Update Employee Name");
        System.out.println("5. Delete Employee");
        System.out.println("6. Add Sample Employees");
        System.out.println("7. Exit");
    }

    /*
     * Adds sample employee records with realistic information.
     */
    public static void addSampleEmployees(EmployeeManager manager) {

        manager.addEmployeeDirectly(new SalariedEmployee(
                1001,
                "Sarah",
                "Johnson",
                new Address(
                        "101 Main St",
                        "Richmond",
                        "VA",
                        "23220"),
                72000));

        manager.addEmployeeDirectly(new HourlyEmployee(
                1002,
                "Marcus",
                "Lee",
                new Address(
                        "55 Oak Ave",
                        "Petersburg",
                        "VA",
                        "23803"),
                22.50,
                40));

        manager.addEmployeeDirectly(new CommissionEmployee(
                1003,
                "Tiana",
                "Brooks",
                new Address(
                        "890 Maple Dr",
                        "Colonial Heights",
                        "VA",
                        "23834"),
                18000,
                0.12));

        System.out.println("\nSample employees added successfully.");
    }

    /*
     * Pauses the application until the user presses Enter.
     */
    public static void pause(Scanner input) {

        System.out.println("\nPress Enter to continue...");
        input.nextLine();
    }
}