/*
 * Name: Wesley Gavitt
 * Course: SDC330L
 * Date: 04/29/2026
 * Purpose: Main class for the Week 4 Employee Management Application.
 * This class displays the menu, collects user input, and connects the user
 * to employee database features.
 */

import java.util.Scanner;

public class App {

    /*
     * Main method starts the application.
     */
    public static void main(String[] args) {

        // Scanner used for keyboard input
        Scanner input = new Scanner(System.in);

        // DatabaseManager handles all SQLite operations
        DatabaseManager database = new DatabaseManager();

        // EmployeeManager connects menu choices to database actions
        EmployeeManager manager = new EmployeeManager(database);

        // Connect to the database and create table if needed
        database.connect();
        database.createTable();

        boolean running = true;

        // Program keeps running until the user chooses to exit
        while (running) {

            displayHeader();
            displayMenu();

            System.out.print("Enter choice: ");
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
                    manager.displayEmployeeById(Integer.parseInt(input.nextLine()));
                    pause(input);
                    break;

                case "4":
                    System.out.print("Enter employee ID to update: ");
                    manager.updateEmployeeName(Integer.parseInt(input.nextLine()), input);
                    pause(input);
                    break;

                case "5":
                    System.out.print("Enter employee ID to delete: ");
                    manager.removeEmployee(Integer.parseInt(input.nextLine()));
                    pause(input);
                    break;

                case "6":
                    System.out.println("Thanks for using the Employee Management Application.");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    pause(input);
            }
        }

        // Close resources before ending program
        database.close();
        input.close();
    }

    /*
     * Displays title, assignment week, student name, and instructions.
     */
    public static void displayHeader() {
        System.out.println("\n==================================================");
        System.out.println("Project Week 4 - Employee Management Application");
        System.out.println("Wesley Gavitt");
        System.out.println("==================================================");
        System.out.println("This program stores employee records in SQLite.");
        System.out.println("Use the menu to create, read, update, or delete employee records.");
    }

    /*
     * Displays the main menu choices.
     */
    public static void displayMenu() {
        System.out.println("\n1. Add Employee");
        System.out.println("2. Display All Employees");
        System.out.println("3. Display Employee by ID");
        System.out.println("4. Update Employee Name");
        System.out.println("5. Delete Employee");
        System.out.println("6. Exit");
    }

    /*
     * Pauses the program until the user presses Enter.
     */
    public static void pause(Scanner input) {
        System.out.println("\nPress Enter to continue...");
        input.nextLine();
    }
}