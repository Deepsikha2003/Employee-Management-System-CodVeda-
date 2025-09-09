import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Employee class to represent an employee
class Employee {
    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Salary: $" + String.format("%.2f", salary);
    }
}

// EmployeeManagementSystem class to manage employee records
public class EmployeeManagementSystem {
    private List<Employee> employees = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private int nextId = 1;

    public static void main(String[] args) {
        EmployeeManagementSystem system = new EmployeeManagementSystem();
        system.run();
    }

    // Main menu loop
    public void run() {
        boolean running = true;
        while (running) {
            printMenu();
            int choice = getUserChoice();
            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    viewAllEmployees();
                    break;
                case 3:
                    updateEmployee();
                    break;
                case 4:
                    deleteEmployee();
                    break;
                case 5:
                    running = false;
                    System.out.println("Exiting system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    // Prints the main menu
    private void printMenu() {
        System.out.println("\n--- Employee Management System ---");
        System.out.println("1. Add Employee");
        System.out.println("2. View All Employees");
        System.out.println("3. Update Employee");
        System.out.println("4. Delete Employee");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    // Gets user's menu choice
    private int getUserChoice() {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); // Clear the invalid input
        }
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline
        return choice;
    }

    // Adds a new employee
    private void addEmployee() {
        System.out.println("\n--- Add New Employee ---");
        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();
        System.out.print("Enter employee salary: ");
        double salary = getDoubleInput();

        Employee newEmployee = new Employee(nextId++, name, salary);
        employees.add(newEmployee);
        System.out.println("Employee added successfully!");
    }

    // Displays all employees
    private void viewAllEmployees() {
        System.out.println("\n--- All Employees ---");
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            employees.forEach(System.out::println);
        }
    }

    // Updates an existing employee's details
    private void updateEmployee() {
        System.out.println("\n--- Update Employee ---");
        System.out.print("Enter employee ID to update: ");
        int idToUpdate = getIntInput();

        Employee employeeToUpdate = findEmployeeById(idToUpdate);
        if (employeeToUpdate == null) {
            System.out.println("Employee with ID " + idToUpdate + " not found.");
            return;
        }

        System.out.print("Enter new name (leave blank to keep current): ");
        String newName = scanner.nextLine();
        if (!newName.isEmpty()) {
            employeeToUpdate.setName(newName);
        }

        System.out.print("Enter new salary (enter -1 to keep current): ");
        double newSalary = getDoubleInput();
        if (newSalary != -1) {
            employeeToUpdate.setSalary(newSalary);
        }

        System.out.println("Employee updated successfully!");
        System.out.println("Updated details: " + employeeToUpdate);
    }

    // Deletes an employee record
    private void deleteEmployee() {
        System.out.println("\n--- Delete Employee ---");
        System.out.print("Enter employee ID to delete: ");
        int idToDelete = getIntInput();

        boolean removed = employees.removeIf(emp -> emp.getId() == idToDelete);
        if (removed) {
            System.out.println("Employee with ID " + idToDelete + " deleted successfully.");
        } else {
            System.out.println("Employee with ID " + idToDelete + " not found.");
        }
    }

    // Helper method to find an employee by their ID
    private Employee findEmployeeById(int id) {
        return employees.stream()
                .filter(emp -> emp.getId() == id)
                .findFirst()
                .orElse(null);
    }
    
    // Helper method for getting a valid integer input
    private int getIntInput() {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); // Clear the invalid input
        }
        int input = scanner.nextInt();
        scanner.nextLine(); // Consume the newline
        return input;
    }

    // Helper method for getting a valid double input
    private double getDoubleInput() {
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); // Clear the invalid input
        }
        double input = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline
        return input;
    }
}