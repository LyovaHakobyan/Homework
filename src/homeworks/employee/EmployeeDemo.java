package homeworks.employee;

import java.util.Scanner;

public class EmployeeDemo {
    public static void main(String[] args) {
        EmployeeStorage employeeStorage = new EmployeeStorage();
        boolean temp = true;
        Scanner in = new Scanner(System.in);
        while (temp) {
            System.out.println("-- Press 0: if you want to finish the process --");
            System.out.println("-- Press 1: if you want to add an employee --");
            System.out.println("-- Press 2: if you want to print all employee --");
            System.out.println("-- Press 3: if you want to search an employee by ID --");
            System.out.println("-- Press 4: if you want to search an employee by company name --");
            int choice = Integer.parseInt(in.nextLine());
            switch (choice) {
                case 0:
                    System.out.println("-- The process is finished --");
                    temp = false;
                    break;
                case 1:
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
                    break;
                case 2:
                    System.out.println("-- Here are all employees --");
                    employeeStorage.print();
                    break;
                case 3:
                    System.out.println("Searching by ID...");
                    String id = in.nextLine();
                    System.out.println("-- Here are the employees by this ID --");
                    employeeStorage.searchID(id);
                    break;
                case 4:
                    System.out.println("Searching by company...");
                    String companySearch = in.nextLine();
                    System.out.println("-- Here are the employees working in this company --");
                    System.out.println();
                    employeeStorage.searchCompany(companySearch);
                    break;
                default:
                    System.out.println("-- WRONG COMMAND ! --");
                    break;
            }
        }
    }
}