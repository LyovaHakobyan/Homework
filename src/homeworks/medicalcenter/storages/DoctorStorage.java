package homeworks.medicalcenter.storages;

import homeworks.medicalcenter.models.Doctor;

public class DoctorStorage {
    private int size;
    private Doctor[] doctors;

    public DoctorStorage() {
        doctors = new Doctor[10];
        size = 0;
    }

    public void add(Doctor doctor) {
        if (size == doctors.length - 1) {
            extend();
        }
        doctors[size++] = doctor;
    }

    public void printAllDoctors() {
        for (int i = 0; i < size; i++) {
            System.out.println(doctors[i]);
        }
    }

    public void searchDoctorByProfession(String profession) {
        for (int i = 0; i < size; i++) {
            if (doctors[i].getProfession().toLowerCase().contains(profession.toLowerCase())) {
                System.out.println(doctors[i]);
            }
        }
    }

    public Doctor returnDoctorById(String id) {
        for (int i = 0; i < size; i++) {
            if (doctors[i].getId().equals(id)) {
                return doctors[i];
            }
        }
        return null;
    }

    public void deleteDoctor(Doctor doctor) {
        for (int i = 0; i < size; i++) {
            if (doctors[i].equals(doctor)) {
                for (int j = i; j < size; j++) {
                    doctors[j] = doctors[j + 1];
                }
                size--;
                break;
            }
        }
    }

    private void extend() {
        Doctor[] temp = new Doctor[doctors.length + 10];
        System.arraycopy(doctors, 0, temp, 0, doctors.length);
        doctors = temp;
    }
}
