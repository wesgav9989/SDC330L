/*
 * Name: Wesley Gavitt
 * Course: SDC330L
 * Date: 04/26/2026
 * Purpose: Main class for Employee Management Application.
 * Controls menu system and user interaction.
 */
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        EmployeeManager manager = new EmployeeManager();

        // Add starting employee records
        manager.addEmployee(new SalariedEmployee(
                1001, "Sarah", "Johnson",
                new Address("101 Main St", "Richmond", "VA", "23220"),
                72000));

        manager.addEmployee(new HourlyEmployee(
                1002, "Marcus", "Lee",
                new Address("55 Oak Ave", "Petersburg", "VA", "23803"),
                22.50, 40));

        manager.addEmployee(new CommissionEmployee(
                1003, "Tiana", "Brooks",
                new Address("890 Maple Dr", "Colonial Heights", "VA", "23834"),
                18000, 0.12));

        boolean running = true;

        while (running) {

            displayHeader();
            displayMenu();

            System.out.print("Enter choice: ");
            String choice = input.nextLine();

            switch (choice) {

                case "1":
                    manager.displayAllEmployees();
                    pause(input);
                    break;

                case "2":
                    System.out.print("Enter employee type: ");
                    manager.displayEmployeesByType(input.nextLine());
                    pause(input);
                    break;

                case "3":
                    manager.addSampleEmployee();
                    pause(input);
                    break;

                case "4":
                    System.out.print("Enter employee ID: ");
                    int updateId = Integer.parseInt(input.nextLine());
                    manager.updateEmployeeName(updateId, input);
                    pause(input);
                    break;

                case "5":
                    System.out.print("Enter employee ID: ");
                    int removeId = Integer.parseInt(input.nextLine());
                    manager.removeEmployee(removeId);
                    pause(input);
                    break;

                case "6":
                    running = false;
                    System.out.println("Goodbye.");
                    break;

                default:
                    System.out.println("Invalid choice.");
                    pause(input);
            }
        }

        input.close();
    }

    // Displays application title
    public static void displayHeader() {
        System.out.println("\n==============================");
        System.out.println("Week 3 Employee Management App");
        System.out.println("Wesley Gavitt");
        System.out.println("==============================");
    }

    // Displays menu options
    public static void displayMenu() {
        System.out.println("1. Display All Employees");
        System.out.println("2. Display Employees By Type");
        System.out.println("3. Add Sample Employee");
        System.out.println("4. Update Employee Name");
        System.out.println("5. Remove Employee");
        System.out.println("6. Exit");
    }

    // Pause screen
    public static void pause(Scanner input) {
        System.out.println("\nPress Enter to continue...");
        input.nextLine();
    }
}
