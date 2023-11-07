package homeworks.employee.storage;

import homeworks.employee.model.Company;
import homeworks.employee.model.Employee;

public class EmployeeStorage {
    private Employee[] employees;
    private int size;

    public EmployeeStorage() {
        employees = new Employee[10];
        size = 0;
    }

    public Employee getEmployees(int index) {
        return employees[index];
    }

    public void add(Employee employee) {
        if (size == employees.length) {
            extend();
        }
        employees[size++] = employee;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    public void searchID(String id) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeID().toLowerCase().contains(id.toLowerCase())) {
                System.out.println(employees[i]);
            }
        }
    }

    public void searchEmployeeByCompanyId(String companyId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getCompany().getId().toLowerCase().contains(companyId.toLowerCase())) {
                System.out.println(employees[i]);
            }
        }
    }

    public void deleteByID(String id) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeID().equals(id)) {
                System.out.println(employees[i] + "<< IS DELETED ! >>");
                delete(i);
                break;
            }
        }
    }

    public void changeByID(String id, String newName, String newSurname, String newEmployeeID, double newSalary, Company newCompany, String newPosition) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeID().equals(id)) {
                employees[i].setName(newName);
                employees[i].setSurname(newSurname);
                employees[i].setEmployeeID(newEmployeeID);
                employees[i].setSalary(newSalary);
                employees[i].setCompany(newCompany);
                employees[i].setPosition(newPosition);
                break;
            }
        }
    }

    public boolean exist(String id) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeID().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkExistenceID(String id) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeID().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public int returnIndexByID(String id) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeID().equals(id)) {
                return i;
            }
        }
        System.out.println("-- This ID doest exist --");
        return -1;
    }

    public void deleteAllEmployeeByCompanyId(String id) {
        Employee[] temp = new Employee[employees.length];
        int index = 0;
        for (int i = 0; i < size; i++) {
            if (!employees[i].getCompany().getId().equals(id)) {
                temp[index++] = employees[i];
            }
        }
        employees = temp;
        size = index;
    }

    private void delete(int i) {
        for (int j = i; j < size; j++) {
            employees[j] = employees[j + 1];
        }
        size--;
    }


    private void extend() {
        Employee[] newEmployees = new Employee[employees.length + 10];
        System.arraycopy(employees, 0, newEmployees, 0, employees.length);
        employees = newEmployees;
    }
}
