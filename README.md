# Employee Management Application

## Project Overview
The Employee Management Application is a Java console-based program that demonstrates object-oriented programming concepts and SQLite database integration. The application allows users to create, view, update, and delete employee records using a menu-driven interface.

This project was developed as the final course project for SDC330L.

---

## Features
- Add employee records
- Display all employees
- Search employees by employee ID
- Update employee names
- Delete employee records
- Store employee information in SQLite
- Demonstrate CRUD database operations
- Demonstrate object-oriented programming concepts

---

## Object-Oriented Programming Concepts Used

### Abstraction
The abstract Employee class defines shared employee behavior and forces child classes to define calculatePay().

### Inheritance
Employee subclasses inherit common employee fields and methods:
- SalariedEmployee
- HourlyEmployee
- CommissionEmployee

### Polymorphism
Each employee subclass overrides methods such as calculatePay() and displayInfo().

### Interfaces
The Displayable interface requires classes to implement displayInfo().

### Composition
Each Employee object contains an Address object.

### Encapsulation
Private fields and public getter/setter methods protect employee data.

---

## Database Features
This application uses SQLite for persistent data storage.

CRUD operations included:
- Create employee records
- Read employee records
- Update employee information
- Delete employee records

---

## Technologies Used
- Java
- SQLite
- JDBC
- Visual Studio Code

---

## Files Included
- App.java
- Employee.java
- SalariedEmployee.java
- HourlyEmployee.java
- CommissionEmployee.java
- Address.java
- EmployeeManager.java
- DatabaseManager.java
- Displayable.java

---

## How to Run the Program

### Compile
```powershell
javac -cp ".;sqlite-jdbc-3.36.0.3.jar" *.java
