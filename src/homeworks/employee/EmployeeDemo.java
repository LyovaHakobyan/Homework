package homeworks.employee;

import homeworks.employee.models.Company;
import homeworks.employee.models.Employee;
import homeworks.employee.storages.CompanyStorage;
import homeworks.employee.storages.EmployeeStorage;

import java.util.Scanner;

public class EmployeeDemo {
    static Scanner in = new Scanner(System.in);
    static EmployeeStorage employeeStorage = new EmployeeStorage();
    static CompanyStorage companyStorage = new CompanyStorage();

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
                    addCompany();
                    break;
                case 2:
                    printCompanyes();
                    break;
                case 3:
                    deleteCompany();
                    break;
                case 4:
                    changeCompanyById();
                    break;
                case 5:
                    addEmployee();
                    break;
                case 6:
                    show();
                    break;
                case 7:
                    searchEmployeeByID();
                    break;
                case 8:
                    searchEmployeeByCompany();
                    break;
                case 9:
                    deleteByID();
                    break;
                case 10:
                    changeEmployeeByID();
                    break;
                default:
                    System.out.println("-- WRONG COMMAND ! --");
                    break;
            }
        }
    }

    private static void changeCompanyById() {
        System.out.println("-- Write full-ID of the company which you want to change --");
        String id = in.nextLine();
        if (companyStorage.exist(id)) {
            int index = companyStorage.getCompanyIndexById(id);
            System.out.print("Old name: " + companyStorage.getCompany(index).getName());
            System.out.print("  New name... ");
            String newName = in.nextLine();
            System.out.print("Old address: " + companyStorage.getCompany(index).getAddress());
            System.out.print("  New address... ");
            String newAddress = in.nextLine();
            companyStorage.changeById(id, newName, newAddress);
            System.out.println("-- The company is changed --");
        } else {
            System.out.println("-- Company by this ID doest exist --");
        }
    }

    private static void deleteCompany() {
        System.out.println("-- Enter full-ID of the company who you want to delete --");
        String companyId = in.nextLine();
        if (companyStorage.exist(companyId)) {
            companyStorage.deleteCompany(companyId);
            employeeStorage.deleteAllEmployeeByCompanyId(companyId);
        } else {
            System.out.println("-- Company by this ID doest exist --");
        }
    }

    private static void printCompanyes() {
        System.out.println("-- Here are all company's --");
        companyStorage.print();
    }

    private static void addCompany() {
        System.out.println("Enter company name");
        String companyName = in.nextLine();
        System.out.println("Enter company address");
        String companyAddress = in.nextLine();
        boolean tmp = true;
        String companyId = null;
        while (tmp) {
            System.out.println("Enter company ID");
            companyId = in.nextLine();
            if (companyStorage.exist(companyId)) {
                System.out.println("-- This ID is already used --");
            } else {
                tmp = false;
            }
        }
        Company company = new Company(companyName, companyId, companyAddress);
        companyStorage.add(company);
        System.out.println("-- Completed --");
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
            String newEmployeeID = null;
            boolean tmp = true;
            while (tmp) {
                System.out.print("Old ID: " + employeeStorage.getEmployees(index).getEmployeeID());
                System.out.print("  New ID... ");
                newEmployeeID = in.nextLine();
                if (employeeStorage.checkExistenceID(newEmployeeID)) {
                    System.out.println("-- This ID is already used --");
                } else {
                    tmp = false;
                }
            }
            System.out.print("Old salary: " + employeeStorage.getEmployees(index).getSalary());
            System.out.print("  New salary... ");
            double newSalary = Double.parseDouble(in.nextLine());
            tmp = true;
            String newCompanyId = null;
            while (tmp) {
                System.out.print("Old company ID: " + employeeStorage.getEmployees(index).getCompany().getId());
                System.out.print("  New company ID... ");
                newCompanyId = in.nextLine();
                if (companyStorage.exist(newCompanyId)) {
                    tmp = false;
                } else {
                    System.out.println("-- Company by this ID doest exist --");
                }
            }
            System.out.print("Old position: " + employeeStorage.getEmployees(index).getPosition());
            System.out.print("  New position... ");
            String newPosition = in.nextLine();

            employeeStorage.changeByID(id, newName, newSurname, newEmployeeID, newSalary, companyStorage.getCompanyById(newCompanyId), newPosition);
            System.out.println("-- The person is changed --");
        } else {
            System.out.println("-- The person by this ID is not found --");
        }
    }

    private static void deleteByID() {
        System.out.println("-- Enter full-ID of the person who you want to be deleted --");
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
        System.out.println("Searching by company ID...");
        String companyId = in.nextLine();
        System.out.println("-- Here are the employees working in this company --");
        System.out.println();
        employeeStorage.searchEmployeeByCompanyId(companyId);
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
        boolean tmp = true;
        String companyId = null;
        while (tmp) {
            System.out.println("Enter company ID");
            companyId = in.nextLine();
            if (companyStorage.exist(companyId)) {
                tmp = false;
            } else {
                System.out.println("-- Company by this ID doest exist --");
            }
        }
        System.out.println("Enter position");
        String position = in.nextLine();
        Employee employee = new Employee(name, surname, employeeID, salary, companyStorage.getCompanyById(companyId), position);
        employeeStorage.add(employee);
        System.out.println("-- Completed --");
    }

    private static void options() {
        System.out.println("-- Press 0: if you want to finish the process --");
        System.out.println("-- Press 1: if you want to add a Company --");
        System.out.println("-- Press 2: if you want to print all company's --");
        System.out.println("-- Press 3: if you want to delete company");
        System.out.println("-- Press 4: if you want to change company");
        System.out.println("-- Press 5: if you want to add an employee --");
        System.out.println("-- Press 6: if you want to print all employees --");
        System.out.println("-- Press 7: if you want to search an employee by ID --");
        System.out.println("-- Press 8: if you want to search an employee by company ID --");
        System.out.println("-- Press 9: if you want to delete the employee by ID --");
        System.out.println("-- Press 10: if you want to change the employee by ID --");
    }
}