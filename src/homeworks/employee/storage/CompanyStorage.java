package homeworks.employee.storage;

import homeworks.employee.model.Company;

public class CompanyStorage {
    private Company[] companies;
    private int size;

    public CompanyStorage() {
        companies = new Company[10];
        size = 0;
    }

    public void add(Company company) {
        if (size == companies.length) {
            extend();
        }
        companies[size++] = company;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(companies[i]);
        }
    }

    public boolean exist(String id) {
        for (int i = 0; i < size; i++) {
            if (companies[i].getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public Company getCompanyById(String id) {
        for (int i = 0; i < size; i++) {
            if (companies[i].getId().equals(id)) {
                return companies[i];
            }
        }
        return null;
    }

    public void deleteCompany(String id) {
        for (int i = 0; i < size; i++) {
            if (companies[i].getId().equals(id)) {
                System.out.println(companies[i].toString() + "<< IS DELETED ! >>");
                delete(i);
                break;
            }
        }
    }

    public int getCompanyIndexById(String id) {
        for (int i = 0; i < size; i++) {
            if (companies[i].getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    public void changeById(String id, String newName, String newAddress) {
        for (int i = 0; i < size; i++) {
            if (companies[i].getId().equals(id)) {
                companies[i].setName(newName);
                companies[i].setAddress(newAddress);
                break;
            }
        }
    }

    public Company getCompany(int index) {
        return companies[index];
    }

    private void extend() {
        Company[] tmp = new Company[companies.length + 10];
        System.arraycopy(companies, 0, tmp, 0, companies.length);
        companies = tmp;
    }

    private void delete(int i) {
        for (int j = i; j < size; j++) {
            companies[j] = companies[j + 1];
        }
        size--;
    }
}
