package homeworks.medicalcenter.storages;

import homeworks.medicalcenter.models.Doctor;
import homeworks.medicalcenter.models.Patient;
import homeworks.medicalcenter.models.Person;

public class Storage {
    private Person[] persons;
    private int size;

    public Storage() {
        persons = new Person[10];
        size = 0;
    }

    public void add(Person person) {
        if (size == persons.length - 1) {
            extend();
        }
        persons[size++] = person;
    }

    public Person returnPersonById(String id) {
        for (int i = 0; i < size; i++) {
            if (persons[i].getId().equals(id)) {
                return persons[i];
            }
        }
        return null;
    }

    public void printAllDoctors() {
        for (int i = 0; i < size; i++) {
            if (persons[i].getClass() == Doctor.class) {
                System.out.println(persons[i]);
            }
        }
    }

    public void printAllPatients() {
        for (int i = 0; i < size; i++) {
            if (persons[i].getClass() == Patient.class) {
                System.out.println(persons[i]);
            }
        }
    }

    public void deletePerson(Person person) {
        for (int i = 0; i < size; i++) {
            if (persons[i].equals(person)) {
                for (int j = i; j < size; j++) {
                    persons[j] = persons[j + 1];
                }
                size--;
                break;
            }
        }
    }

    public void searchDoctorByProfession(String profession) {
        for (int i = 0; i < size; i++) {
            if (persons[i].getClass() == Doctor.class) {
                Doctor doctor = (Doctor) persons[i];
                if (doctor.getProfession().toLowerCase().contains(profession.toLowerCase())) {
                    System.out.println(doctor);
                }
            }
        }
    }

    public void deletePatientsByDoctor(Person person) {
        int index = 0;
        for (int i = 0; i < size; i++) {
            if (persons[i].getClass() == Patient.class) {
                Patient patient = (Patient) persons[i];
                if (!patient.getDoctor().equals(person)) {
                    persons[index++] = persons[i];
                }
            }
            if (persons[i].getClass() == Doctor.class) {
                persons[index++] = persons[i];
            }

        }
        size = index;
    }

    public void returnPatientByDoctor(Person person) {
        for (int i = 0; i < size; i++) {
            if (persons[i].getClass() == Patient.class) {
                Patient patient = (Patient) persons[i];
                if (patient.getDoctor().equals(person)) {
                    System.out.println(persons[i]);
                }
            }
        }
    }

    private void extend() {
        Person[] temp = new Person[persons.length + 10];
        System.arraycopy(persons, 0, temp, 0, persons.length);
        persons = temp;
    }
}