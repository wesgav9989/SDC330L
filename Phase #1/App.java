/*
 * Name: Wesley Gavitt
 * Date: 04/09/2026
 * Purpose: Main class for Project Week 1 Employee Management Application.
 * This file displays the title, welcomes the user, shows the menu,
 * and keeps the application running until the user chooses to quit.
 */
import java.util.Scanner;
public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        EmployeeManager manager = new EmployeeManager();

        // Sample employee objects with realistic information
        manager.addEmployee(new SalariedEmployee(
                1001,
                "Sarah",
                "Johnson",
                new Address("101 Main St", "Richmond", "VA", "23220"),
                72000.00));

        manager.addEmployee(new HourlyEmployee(
                1002,
                "Marcus",
                "Lee",
                new Address("55 Oak Ave", "Petersburg", "VA", "23803"),
                22.50,
                40));

        manager.addEmployee(new CommissionEmployee(
                1003,
                "Tiana",
                "Brooks",
                new Address("890 Maple Dr", "Colonial Heights", "VA", "23834"),
                18000.00,
                0.12));

        boolean running = true;

        while (running) {
            displayHeader();
            displayMenu();

            System.out.print("Enter your choice: ");
            String choice = input.nextLine();

            switch (choice) {
                case "1":
                    manager.displayAllEmployees();
                    pause(input);
                    break;
                case "2":
                    System.out.print("Enter employee type to display (Salaried, Hourly, Commission): ");
                    String type = input.nextLine();
                    manager.displayEmployeesByType(type);
                    pause(input);
                    break;
                case "3":
                    addEmployeeFromUser(input, manager);
                    pause(input);
                    break;
                case "4":
                    System.out.print("Enter employee ID to update: ");
                    int updateId = Integer.parseInt(input.nextLine());
                    manager.updateEmployeeName(updateId, input);
                    pause(input);
                    break;
                case "5":
                    System.out.print("Enter employee ID to remove: ");
                    int removeId = Integer.parseInt(input.nextLine());
                    manager.removeEmployee(removeId);
                    pause(input);
                    break;
                case "6":
                    System.out.println("\nThanks for using the Employee Management Application. Goodbye.");
                    running = false;
                    break;
                default:
                    System.out.println("\nInvalid choice. Please try again.");
                    pause(input);
            }
        }

        input.close();
    }

    public static void displayHeader() {
        System.out.println("\n==================================================");
        System.out.println("Project Week 1 - Employee Management Application");
        System.out.println("Wesley Gavitt");
        System.out.println("==================================================");
    }

    public static void displayMenu() {
        System.out.println("Welcome to the Employee Management Application.");
        System.out.println("Choose an option from the menu below:");
        System.out.println("1. Display All Employees");
        System.out.println("2. Display Employees by Type");
        System.out.println("3. Add Employee");
        System.out.println("4. Update Employee Name");
        System.out.println("5. Remove Employee");
        System.out.println("6. Exit");
        System.out.println();
    }

    public static void addEmployeeFromUser(Scanner input, EmployeeManager manager) {
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
            String zip = input.nextLine();

            Address address = new Address(street, city, state, zip);

            System.out.print("Enter employee type (Salaried, Hourly, Commission): ");
            String type = input.nextLine().trim().toLowerCase();

            if (type.equals("salaried")) {
                System.out.print("Enter annual salary: ");
                double annualSalary = Double.parseDouble(input.nextLine());

                manager.addEmployee(new SalariedEmployee(id, firstName, lastName, address, annualSalary));
                System.out.println("Salaried employee added successfully.");
            } else if (type.equals("hourly")) {
                System.out.print("Enter hourly rate: ");
                double hourlyRate = Double.parseDouble(input.nextLine());

                System.out.print("Enter hours worked: ");
                double hoursWorked = Double.parseDouble(input.nextLine());

                manager.addEmployee(new HourlyEmployee(id, firstName, lastName, address, hourlyRate, hoursWorked));
                System.out.println("Hourly employee added successfully.");
            } else if (type.equals("commission")) {
                System.out.print("Enter sales amount: ");
                double salesAmount = Double.parseDouble(input.nextLine());

                System.out.print("Enter commission rate (example 0.10 for 10%): ");
                double commissionRate = Double.parseDouble(input.nextLine());

                manager.addEmployee(new CommissionEmployee(id, firstName, lastName, address, salesAmount, commissionRate));
                System.out.println("Commission employee added successfully.");
            } else {
                System.out.println("Invalid employee type. Employee was not added.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid number entered. Employee was not added.");
        }
    }

    public static void pause(Scanner input) {
        System.out.println("\nPress Enter to continue...");
        input.nextLine();
    }
}
