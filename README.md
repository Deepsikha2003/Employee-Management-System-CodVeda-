Employee Management System
This is a basic console-based Employee Management System built in Java. It demonstrates fundamental Object-Oriented Programming (OOP) principles and core Java concepts by allowing users to perform CRUD (Create, Read, Update, Delete) operations on employee data.

The application stores employee information in an in-memory collection (ArrayList), which means the data is not persistent and will be reset each time the program is run.

Features
Add Employee: Create a new employee record with a unique ID, name, and salary.

View All Employees: Display a list of all current employees.

Update Employee: Modify an existing employee's name and salary using their ID.

Delete Employee: Remove an employee record from the system using their ID.

Technologies Used
Java: The core programming language used to build the application.

Object-Oriented Programming (OOP): The project is structured using an Employee class and a main management class to demonstrate key OOP concepts.

ArrayList: A dynamic array used to store employee objects in memory.

How to Run
Save the Code: Save the provided Java code as EmployeeManagementSystem.java.

Open a Terminal: Navigate to the directory where you saved the file.

Compile the Code: Compile the Java source file using the javac command.

Bash

javac EmployeeManagementSystem.java
Run the Program: Execute the compiled class file using the java command.

Bash

java EmployeeManagementSystem
The application will then display a menu in your terminal, and you can interact with the system by entering your choices.

Project Structure
Employee.java: Defines the Employee class, which holds an employee's ID, name, and salary.

EmployeeManagementSystem.java: Contains the main method and all the logic for managing the employee records, including the CRUD operations.
