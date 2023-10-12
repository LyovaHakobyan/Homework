package homeworks.medicalcenter;

import homeworks.medicalcenter.models.Doctor;
import homeworks.medicalcenter.models.Patient;
import homeworks.medicalcenter.storages.DoctorStorage;
import homeworks.medicalcenter.storages.PatientStorage;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class PatientManagement {
    static DoctorStorage doctorStorage = new DoctorStorage();
    static PatientStorage patientStorage = new PatientStorage();
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        boolean truth = true;
        while (truth) {
            options();
            int choice = Integer.parseInt(in.nextLine());
            switch (choice) {
                case 0:
                    System.out.println("-- The process is finished --");
                    truth = false;
                    break;
                case 1:
                    addDoctor();
                    break;
                case 2:
                    printAllDoctors();
                    break;
                case 3:
                    searchDoctorByProfession();
                    break;
                case 4:
                    deleteDoctor();
                    break;
                case 5:
                    changeDoctorById();
                    break;
                case 6:
                    addPatient();
                    break;
                case 7:
                    printAllPatientsByDoctor();
                    break;
                case 8:
                    printAllPatients();
                    break;
                case 9:
                    deletePatientById();
                    break;
                case 10:
                    changePatientById();
                    break;
                default:
                    System.out.println("-- Wrong Command --");
                    break;
            }
        }
    }

    private static void options() {
        System.out.println("-- Enter 0: if you want to FINISH the process --");
        System.out.println("-- Enter 1: if you want to ADD a doctor --");
        System.out.println("-- Enter 2: if you want to PRINT all doctors --");
        System.out.println("-- Enter 3: if you want to SEARCH the doctor by profession --");
        System.out.println("-- Enter 4: if you want to DELETE the doctor by ID --");
        System.out.println("-- Enter 5: if you want to CHANGE the doctor by ID --");
        System.out.println("-- Enter 6: if you want to ADD a patient --");
        System.out.println("-- Enter 7: if you want to PRINT all patients by doctor --");
        System.out.println("-- Enter 8: if you want to PRINT all patients --");
        System.out.println("-- Enter 9: if you want to DELETE a patient --");
        System.out.println("-- Enter 10: if you want to CHANGE a patient --");
    }

    private static void addDoctor() {
        System.out.println("Name...");
        String doctorName = in.nextLine();
        System.out.println("Surname...");
        String doctorSurname = in.nextLine();
        System.out.println("PhoneNumber...");
        int doctorPhoneNumber = Integer.parseInt(in.nextLine());
        boolean temp = true;
        String doctorId = null;
        while (temp) {
            System.out.println("Id...");
            doctorId = in.nextLine();
            if (doctorStorage.returnDoctorById(doctorId) != null) {
                System.out.println("-- This ID is already used --");
            } else {
                temp = false;
            }
        }
        System.out.println("Email...");
        String doctorEmail = in.nextLine();
        System.out.println("Profession...");
        String doctorProfession = in.nextLine();
        Doctor doctor = new Doctor(doctorName, doctorSurname, doctorId, doctorPhoneNumber, doctorEmail, doctorProfession);
        doctorStorage.add(doctor);
        System.out.println("-- Completed --");
    }

    static private void printAllDoctors() {
        System.out.println("-- Here are all doctors --");
        doctorStorage.printAllDoctors();
    }

    private static void searchDoctorByProfession() {
        System.out.println("-- Enter the profession of the doctor who you want to find --");
        String profession = in.nextLine();
        System.out.println("-- Here are the doctors by this profession --");
        doctorStorage.searchDoctorByProfession(profession);
    }

    private static void deleteDoctor() {
        System.out.println("-- Enter the ID of the doctor who you want to delete --");
        String id = in.nextLine();
        Doctor doctor = doctorStorage.returnDoctorById(id);
        if (doctor != null) {
            doctorStorage.deleteDoctor(doctor);
            patientStorage.deletePatientsByDoctor(doctor);
            System.out.println("-- Doctor is deleted --");
        } else {
            System.out.println("-- Doctor by this ID is not found --");
        }
    }

    private static void changeDoctorById() {
        System.out.println("-- Enter the ID of the doctor who you want to change --");
        String id = in.nextLine();
        Doctor doctor = doctorStorage.returnDoctorById(id);
        if (doctor != null) {
            System.out.println("Old name:" + doctor.getName() + "  New name... ");
            String newName = in.nextLine();
            doctor.setName(newName);
            System.out.println("Old surname:" + doctor.getSurname() + "  New surname... ");
            String newSurname = in.nextLine();
            doctor.setSurname(newSurname);
            System.out.println("Old PhoneNumber:" + doctor.getPhoneNumber() + "  New phoneNumber... ");
            int newPhoneNumber = Integer.parseInt(in.nextLine());
            doctor.setPhoneNumber(newPhoneNumber);
            System.out.println("Old Email:" + doctor.getEmail() + "  New Email... ");
            String newEmail = in.nextLine();
            doctor.setEmail(newEmail);
            System.out.println("Old profession:" + doctor.getProfession() + "  New profession... ");
            String newProfession = in.nextLine();
            doctor.setProfession(newProfession);
            System.out.println("-- Completed --");
        } else {
            System.out.println("-- Doctor by this ID is not found --");
        }
    }

    private static void addPatient() {
        System.out.println("Name...");
        String patientName = in.nextLine();
        System.out.println("Surname...");
        String patientSurname = in.nextLine();
        boolean temp = true;
        String patientId = null;
        while (temp) {
            System.out.println("Id...");
            patientId = in.nextLine();
            if (patientStorage.returnPatientById(patientId) != null) {
                System.out.println("-- This ID is already used --");
            } else {
                temp = false;
            }
        }
        System.out.println("PhoneNumber...");
        int patientPhoneNumber = Integer.parseInt(in.nextLine());
        System.out.println("Doctor id where he will be registered...");
        doctorStorage.printAllDoctors();
        String id = null;
        temp = true;
        while (temp) {
            id = in.nextLine();
            if (doctorStorage.returnDoctorById(id) == null) {
                System.out.println("-- Wrong Id, try again --");
            } else {
                temp = false;
            }
        }
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy hh:mm");
        String date = sdf.format(d);
        Patient patient = new Patient(patientName, patientSurname, patientId, patientPhoneNumber, doctorStorage.returnDoctorById(id), date);
        patientStorage.add(patient);
        System.out.println("-- Completed --");
    }

    static private void printAllPatientsByDoctor() {
        System.out.println("-- Enter ID of the doctor if you want to see the patients --");
        String idOfDoctor = in.nextLine();
        Doctor doctor = doctorStorage.returnDoctorById(idOfDoctor);
        if (doctor != null) {
            patientStorage.returnPatientByDoctor(doctor);
        } else {
            System.out.println("-- Doctor by this ID is not found --");
        }
    }

    static private void printAllPatients() {
        System.out.println("-- Here are all patients --");
        patientStorage.printAllPatients();
    }

    static private void deletePatientById() {
        System.out.println("-- Enter the ID of the patient who you want to delete --");
        String id = in.nextLine();
        Patient patient = patientStorage.returnPatientById(id);
        if (patient != null) {
            patientStorage.deletePatient(patient);
            System.out.println("-- The patient is deleted --");
        } else {
            System.out.println("-- The patient by this Id is not found --");
        }
    }

    static private void changePatientById() {
        System.out.println("-- Enter the ID of the patient who you want to change --");
        String id = in.nextLine();
        Patient patient = patientStorage.returnPatientById(id);
        if (patient != null) {
            System.out.println("Old name:" + patient.getName() + "  New name... ");
            String newName = in.nextLine();
            patient.setName(newName);
            System.out.println("Old surname:" + patient.getSurname() + "  New surname... ");
            String newSurname = in.nextLine();
            patient.setSurname(newSurname);
            System.out.println("Old PhoneNumber:" + patient.getPhoneNumber() + "  New phoneNumber... ");
            int newPhoneNumber = Integer.parseInt(in.nextLine());
            patient.setPhoneNumber(newPhoneNumber);
            System.out.println("-- Completed --");
        } else {
            System.out.println("-- Patient by this Id is not found --");
        }
    }
}
