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
                default:
                    System.out.println("-- WRONG COMMAND ! --");
                    break;
            }
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
        System.out.println("Enter employeeID");
        String employeeID = in.nextLine();
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
    }
}