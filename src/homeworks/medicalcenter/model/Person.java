package homeworks.medicalcenter.model;

import java.util.Objects;

public abstract class Person {
    private String name;
    private String surname;
    private String id;
    private long phoneNumber;

    public Person(String name, String surname, String id, long phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.phoneNumber = phoneNumber;
    }

    public Person() {
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (phoneNumber != person.phoneNumber) return false;
        if (!Objects.equals(name, person.name)) return false;
        if (!Objects.equals(surname, person.surname)) return false;
        return Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (int) (phoneNumber ^ (phoneNumber >>> 32));
        return result;
    }
}
