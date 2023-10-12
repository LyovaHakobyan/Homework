package homeworks.medicalcenter.storages;

import homeworks.medicalcenter.models.Doctor;
import homeworks.medicalcenter.models.Patient;

public class PatientStorage {
    private int size;
    private Patient[] patients;

    public PatientStorage() {
        patients = new Patient[10];
        size = 0;
    }

    public void add(Patient patient) {
        if (size == patients.length - 1) {
            extend();
        }
        patients[size++] = patient;
    }

    public void printAllPatients() {
        for (int i = 0; i < size; i++) {
            System.out.println(patients[i]);
        }
    }

    public Patient returnPatientById(String id) {
        for (int i = 0; i < size; i++) {
            if (patients[i].getId().equals(id)) {
                return patients[i];
            }
        }
        return null;
    }

    public void returnPatientByDoctor(Doctor doctor) {
        for (int i = 0; i < size; i++) {
            if (patients[i].getDoctor().equals(doctor)) {
                System.out.println(patients[i]);
            }
        }
    }

    public void deletePatientsByDoctor(Doctor doctor) {
        int index = 0;
        for (int i = 0; i < size; i++) {
            if (!patients[i].getDoctor().equals(doctor)) {
                patients[index++] = patients[i];
            }
        }
        size = index;
    }

    public void deletePatient(Patient patient) {
        for (int i = 0; i < size; i++) {
            if (patients[i].equals(patient)) {
                for (int j = i; j < size; j++) {
                    patients[j] = patients[j + 1];
                }
                size--;
                break;
            }
        }
    }

    private void extend() {
        Patient[] temp = new Patient[patients.length + 10];
        System.arraycopy(patients, 0, temp, 0, patients.length);
        patients = temp;
    }
}
