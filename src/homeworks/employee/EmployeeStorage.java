package homeworks.employee;

public class EmployeeStorage {
    private Employee[] employees;
    private int size;

    public EmployeeStorage() {
        employees = new Employee[10];
        size = 0;
    }

    public void add(Employee employee) {
        if (employees.length == size) {
            extend();
        }
        employees[size++] = employee;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println("Name: " + employees[i].getName() + " Surname: " + employees[i].getSurname() + " EmployeeID: " + employees[i].getEmployeeID() + " Salary: " + employees[i].getSalary() + " Company: " + employees[i].getCompany() + " Position: " + employees[i].getPosition() + " ");
        }
    }

    public void searchID(String id) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeID().toLowerCase().contains(id.toLowerCase())) {
                System.out.println("Name: " + employees[i].getName() + " Surname: " + employees[i].getSurname() + " EmployeeID: " + employees[i].getEmployeeID() + " Salary: " + employees[i].getSalary() + " Company: " + employees[i].getCompany() + " Position: " + employees[i].getPosition() + " ");
            }
        }
    }

    public void searchCompany(String companyName) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getCompany().toLowerCase().contains(companyName.toLowerCase())) {
                System.out.println("Name: " + employees[i].getName() + " Surname: " + employees[i].getSurname() + " EmployeeID: " + employees[i].getEmployeeID() + " Salary: " + employees[i].getSalary() + " Company: " + employees[i].getCompany() + " Position: " + employees[i].getPosition() + " ");
            }
        }
    }

    private void extend() {
        Employee[] newEmployees = new Employee[employees.length + 10];
        System.arraycopy(employees, 0, newEmployees, 0, employees.length);
        employees = newEmployees;
    }
}
