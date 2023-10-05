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

    public void searchCompany(String companyName) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getCompany().toLowerCase().contains(companyName.toLowerCase())) {
                System.out.println(employees[i]);
            }
        }
    }

    private void extend() {
        Employee[] newEmployees = new Employee[employees.length + 10];
        System.arraycopy(employees, 0, newEmployees, 0, employees.length);
        employees = newEmployees;
    }
}
