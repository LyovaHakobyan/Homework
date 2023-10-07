package homeworks.employee;

import java.util.Scanner;

public class EmployeeDemo {
    static Scanner in = new Scanner(System.in);
    static EmployeeStorage employeeStorage = new EmployeeStorage();

    public static void main(String[] args) {
        boolean temp = true;
        while (temp) {
            options();
            int choice = Integer.parseInt(in.nextLine());
            switch (choice) {
                case 0:
                    System.out.println("-- The process is finished --");
                    temp = false;
                    break;
                case 1:
                    addEmployee();
                    break;
                case 2:
                    show();
                    break;
                case 3:
                    searchEmployeeByID();
                    break;
                case 4:
                    searchEmployeeByCompany();
                    break;
                case 5:
                    deleteByID();
                    break;
                case 6:
                    changeEmployeeByID();
                    break;
                default:
                    System.out.println("-- WRONG COMMAND ! --");
                    break;
            }
        }
    }

    private static void changeEmployeeByID() {
        System.out.println("-- Write full-ID of the person who you want to change --");
        String id = in.nextLine();
        if (employeeStorage.exist(id)) {
            int index = employeeStorage.returnIndexByID(id);
            System.out.print("Old name: " + employeeStorage.getEmployees(index).getName());
            System.out.print("  New name... ");
            String newName = in.nextLine();
            System.out.print("Old surname: " + employeeStorage.getEmployees(index).getSurname());
            System.out.print("  New surname... ");
            String newSurname = in.nextLine();
            System.out.print("Old ID: " + employeeStorage.getEmployees(index).getEmployeeID());
            System.out.print("  New ID... ");
            String newEmployeeID = in.nextLine();
            System.out.print("Old salary: " + employeeStorage.getEmployees(index).getSalary());
            System.out.print("  New salary... ");
            double newSalary = Double.parseDouble(in.nextLine());
            System.out.print("Old company: " + employeeStorage.getEmployees(index).getCompany());
            System.out.print("  New company... ");
            String newCompany = in.nextLine();
            System.out.print("Old position: " + employeeStorage.getEmployees(index).getPosition());
            System.out.print("  New position... ");
            String newPosition = in.nextLine();
            employeeStorage.changeByID(id, newName, newSurname, newEmployeeID, newSalary, newCompany, newPosition);
            System.out.println("-- The person is changed --");
        } else {
            System.out.println("-- The person by this ID is not found --");
        }
    }

    private static void deleteByID() {
        System.out.println("-- Write full-ID of the person who you want to be deleted --");
        String id = in.nextLine();
        if (employeeStorage.exist(id)) {
            employeeStorage.deleteByID(id);
        } else {
            System.out.println("-- The person by this ID is not found --");
        }
    }

    private static void show() {
        System.out.println("-- Here are all employees --");
        employeeStorage.print();
    }

    private static void searchEmployeeByCompany() {
        System.out.println("Searching by company...");
        String companySearch = in.nextLine();
        System.out.println("-- Here are the employees working in this company --");
        System.out.println();
        employeeStorage.searchCompany(companySearch);
    }

    private static void searchEmployeeByID() {
        System.out.println("Searching by ID...");
        String id = in.nextLine();
        System.out.println("-- Here are the employees by this ID --");
        employeeStorage.searchID(id);
    }

    private static void addEmployee() {
        System.out.println("Enter name");
        String name = in.nextLine();
        System.out.println("Enter surname");
        String surname = in.nextLine();
        String employeeID = null;
        boolean temp = true;
        while (temp) {
            System.out.println("Enter employeeID");
            employeeID = in.nextLine();
            if (employeeStorage.checkExistenceID(employeeID)) {
                System.out.println("-- This ID is already used --");
            } else {
                temp = false;
            }
        }
        System.out.println("Enter salary");
        double salary = Double.parseDouble(in.nextLine());
        System.out.println("Enter company");
        String company = in.nextLine();
        System.out.println("Enter position");
        String position = in.nextLine();
        Employee employee = new Employee(name, surname, employeeID, salary, company, position);
        employeeStorage.add(employee);
        System.out.println("-- Completed --");
    }

    private static void options() {
        System.out.println("-- Press 0: if you want to finish the process --");
        System.out.println("-- Press 1: if you want to add an employee --");
        System.out.println("-- Press 2: if you want to print all employees --");
        System.out.println("-- Press 3: if you want to search an employee by ID --");
        System.out.println("-- Press 4: if you want to search an employee by company name --");
        System.out.println("-- Press 5: if you want to delete the employee by ID --");
        System.out.println("-- Press 6: if you want to change the employee by ID --");
    }
}