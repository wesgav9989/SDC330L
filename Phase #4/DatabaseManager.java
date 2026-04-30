/*
 * Name: Wesley Gavitt
 * Course: SDC330L
 * Date: 04/29/2026
 * Purpose: Handles SQLite database operations for the Employee Management Application.
 * This class performs create, read, update, and delete operations.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {

    // Private connection object protects the database connection
    private Connection connection;

    // SQLite database file name
    private final String databaseUrl = "jdbc:sqlite:employees.db";

    /*
    * Connects the Java program to the SQLite database.
    */
    public void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(databaseUrl);
            System.out.println("Connected to SQLite database.");
        } catch (ClassNotFoundException e) {
            System.out.println("SQLite JDBC driver not found. Make sure the jar file is added.");
        } catch (SQLException e) {
            System.out.println("Database connection failed: " + e.getMessage());
        }
    }

    /*
     * Creates the employees table if it does not already exist.
     */
    public void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS employees ("
                + "employee_id INTEGER PRIMARY KEY, "
                + "first_name TEXT NOT NULL, "
                + "last_name TEXT NOT NULL, "
                + "street TEXT, "
                + "city TEXT, "
                + "state TEXT, "
                + "zip_code TEXT, "
                + "employee_type TEXT NOT NULL, "
                + "annual_salary REAL, "
                + "hourly_rate REAL, "
                + "hours_worked REAL, "
                + "sales_amount REAL, "
                + "commission_rate REAL"
                + ");";

        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
            System.out.println("Employee table is ready.");
        } catch (SQLException e) {
            System.out.println("Table creation failed: " + e.getMessage());
        }
    }

    /*
     * Inserts a new employee record into the database.
     */
    public void insertEmployee(Employee employee) {
        String sql = "INSERT INTO employees VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, employee.getEmployeeId());
            statement.setString(2, employee.getFirstName());
            statement.setString(3, employee.getLastName());
            statement.setString(4, employee.getAddress().getStreet());
            statement.setString(5, employee.getAddress().getCity());
            statement.setString(6, employee.getAddress().getState());
            statement.setString(7, employee.getAddress().getZipCode());
            statement.setString(8, employee.getClass().getSimpleName());

            // Store pay data based on the specific employee subclass
            if (employee instanceof SalariedEmployee) {
                SalariedEmployee salaried = (SalariedEmployee) employee;
                statement.setDouble(9, salaried.getAnnualSalary());
                statement.setNull(10, java.sql.Types.REAL);
                statement.setNull(11, java.sql.Types.REAL);
                statement.setNull(12, java.sql.Types.REAL);
                statement.setNull(13, java.sql.Types.REAL);
            } else if (employee instanceof HourlyEmployee) {
                HourlyEmployee hourly = (HourlyEmployee) employee;
                statement.setNull(9, java.sql.Types.REAL);
                statement.setDouble(10, hourly.getHourlyRate());
                statement.setDouble(11, hourly.getHoursWorked());
                statement.setNull(12, java.sql.Types.REAL);
                statement.setNull(13, java.sql.Types.REAL);
            } else if (employee instanceof CommissionEmployee) {
                CommissionEmployee commission = (CommissionEmployee) employee;
                statement.setNull(9, java.sql.Types.REAL);
                statement.setNull(10, java.sql.Types.REAL);
                statement.setNull(11, java.sql.Types.REAL);
                statement.setDouble(12, commission.getSalesAmount());
                statement.setDouble(13, commission.getCommissionRate());
            }

            statement.executeUpdate();
            System.out.println("Employee added to database.");

        } catch (SQLException e) {
            System.out.println("Insert failed: " + e.getMessage());
        }
    }

    /*
     * Displays every employee currently stored in the database.
     */
    public void displayAllEmployees() {
        String sql = "SELECT * FROM employees";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            System.out.println("\nEmployees Stored in Database");
            System.out.println("----------------------------------------");

            while (resultSet.next()) {
                displayEmployeeResult(resultSet);
            }

        } catch (SQLException e) {
            System.out.println("Read failed: " + e.getMessage());
        }
    }

    /*
     * Displays one employee by employee ID.
     */
    public void displayEmployeeById(int employeeId) {
        String sql = "SELECT * FROM employees WHERE employee_id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, employeeId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                displayEmployeeResult(resultSet);
            } else {
                System.out.println("Employee not found.");
            }

        } catch (SQLException e) {
            System.out.println("Search failed: " + e.getMessage());
        }
    }

    /*
     * Updates an employee's first and last name in the database.
     */
    public void updateEmployeeName(int employeeId, String firstName, String lastName) {
        String sql = "UPDATE employees SET first_name = ?, last_name = ? WHERE employee_id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setInt(3, employeeId);

            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println("Employee updated in database.");
            } else {
                System.out.println("Employee not found.");
            }

        } catch (SQLException e) {
            System.out.println("Update failed: " + e.getMessage());
        }
    }

    /*
     * Deletes an employee from the database by employee ID.
     */
    public void deleteEmployee(int employeeId) {
        String sql = "DELETE FROM employees WHERE employee_id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, employeeId);

            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println("Employee deleted from database.");
            } else {
                System.out.println("Employee not found.");
            }

        } catch (SQLException e) {
            System.out.println("Delete failed: " + e.getMessage());
        }
    }

    /*
     * Helper method that formats database result data for display.
     */
    private void displayEmployeeResult(ResultSet resultSet) throws SQLException {
        System.out.println("ID: " + resultSet.getInt("employee_id"));
        System.out.println("Name: " + resultSet.getString("first_name") + " "
                + resultSet.getString("last_name"));
        System.out.println("Address: " + resultSet.getString("street") + ", "
                + resultSet.getString("city") + ", "
                + resultSet.getString("state") + " "
                + resultSet.getString("zip_code"));
        System.out.println("Type: " + resultSet.getString("employee_type"));

        String type = resultSet.getString("employee_type");

        if (type.equals("SalariedEmployee")) {
            System.out.printf("Annual Salary: $%.2f%n", resultSet.getDouble("annual_salary"));
        } else if (type.equals("HourlyEmployee")) {
            System.out.printf("Hourly Rate: $%.2f%n", resultSet.getDouble("hourly_rate"));
            System.out.printf("Hours Worked: %.2f%n", resultSet.getDouble("hours_worked"));
        } else if (type.equals("CommissionEmployee")) {
            System.out.printf("Sales Amount: $%.2f%n", resultSet.getDouble("sales_amount"));
            System.out.printf("Commission Rate: %.2f%n", resultSet.getDouble("commission_rate"));
        }

        System.out.println("----------------------------------------");
    }

    /*
     * Closes the database connection.
     */
    public void close() {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Database connection closed.");
            }
        } catch (SQLException e) {
            System.out.println("Close failed: " + e.getMessage());
        }
    }
}