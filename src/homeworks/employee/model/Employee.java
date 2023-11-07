package homeworks.employee.model;

public class Employee {
    private String name;
    private String surname;
    private String employeeID;
    private double salary;
    private Company company;
    private String position;

    public Employee() {
    }

    public Employee(String name, String surname, String employeeID, double salary, Company company, String position) {
        this.name = name;
        this.surname = surname;
        this.employeeID = employeeID;
        this.salary = salary;
        this.company = company;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    @Override
    public String toString() {
        return "Name: " + name + " Surname: " + surname + " EmployeeID: " + employeeID + " Salary: " + salary + " Company: " + company.toString() + " Position: " + position + " ";
    }
}
