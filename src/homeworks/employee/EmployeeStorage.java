package homeworks.employee;

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

    public void deleteByID(String id) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeID().equals(id)) {
                System.out.println(employees[i] + " --> IS DELETED !");
                delete(i);
                break;
            }
        }
    }

    public void changeByID(String id, String newName, String newSurname, String newEmployeeID, double newSalary, String newCompany, String newPosition) {
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

    public int returnIndexByID(String id) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeID().equals(id)) {
                return i;
            }
        }
        System.out.println("-- This ID doest exist --");
        return -1;
    }

    private void delete(int i) {
        for (int j = i; j < size; j++) {
            employees[j] = employees[j + 1];
        }
        size--;
    }

    public boolean checkExistenceID(String id) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeID().equals(id)) {
                return true;
            }
        }
        return false;
    }

    private void extend() {
        Employee[] newEmployees = new Employee[employees.length + 10];
        System.arraycopy(employees, 0, newEmployees, 0, employees.length);
        employees = newEmployees;
    }
}
