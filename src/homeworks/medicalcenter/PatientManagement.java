package homeworks.medicalcenter;

import homeworks.medicalcenter.models.Doctor;
import homeworks.medicalcenter.models.Patient;
import homeworks.medicalcenter.models.Person;
import homeworks.medicalcenter.storages.PersonStorage;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class PatientManagement {
    static PersonStorage storage = new PersonStorage();
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
        long doctorPhoneNumber = Long.parseLong(in.nextLine());
        boolean temp = true;
        String doctorId = null;
        while (temp) {
            System.out.println("Id...");
            doctorId = in.nextLine();
            Person person = storage.returnPersonById(doctorId);
            if (person != null) {
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
        storage.add(doctor);
        System.out.println("-- Completed --");
    }

    static private void printAllDoctors() {
        System.out.println("-- Here are all doctors --");
        storage.printAllDoctors();
    }

    private static void searchDoctorByProfession() {
        System.out.println("-- Enter the profession of the doctor who you want to find --");
        String profession = in.nextLine();
        System.out.println("-- Here are the doctors by this profession --");
        storage.searchDoctorByProfession(profession);
    }

    private static void deleteDoctor() {
        System.out.println("-- Enter the ID of the doctor who you want to delete --");
        String id = in.nextLine();
        Person person = storage.returnPersonById(id);
        if (person != null && person.getClass() == Doctor.class) {
            storage.deletePerson(person);
            storage.deletePatientsByDoctor(person);
            System.out.println("-- Doctor is deleted --");
        } else {
            System.out.println("-- Doctor by this ID is not found --");
        }
    }

    private static void changeDoctorById() {
        System.out.println("-- Enter the ID of the doctor who you want to change --");
        String id = in.nextLine();
        Person person = storage.returnPersonById(id);
        if (person != null && person.getClass() == Doctor.class) {
            System.out.println("Old name:" + person.getName() + "  New name... ");
            String newName = in.nextLine();
            person.setName(newName);
            System.out.println("Old surname:" + person.getSurname() + "  New surname... ");
            String newSurname = in.nextLine();
            person.setSurname(newSurname);
            System.out.println("Old PhoneNumber:" + person.getPhoneNumber() + "  New phoneNumber... ");
            long newPhoneNumber = Long.parseLong(in.nextLine());
            person.setPhoneNumber(newPhoneNumber);
            System.out.println("Old Email:" + ((Doctor) person).getEmail() + "  New Email... ");
            String newEmail = in.nextLine();
            ((Doctor) person).setEmail(newEmail);
            System.out.println("Old profession:" + ((Doctor) person).getProfession() + "  New profession... ");
            String newProfession = in.nextLine();
            ((Doctor) person).setProfession(newProfession);
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
            Person person = storage.returnPersonById(patientId);
            if (person != null) {
                System.out.println("-- This ID is already used --");
            } else {
                temp = false;
            }
        }
        System.out.println("PhoneNumber...");
        long patientPhoneNumber = Long.parseLong(in.nextLine());
        System.out.println("Doctor id where he will be registered...");
        storage.printAllDoctors();
        String id = null;
        temp = true;
        while (temp) {
            id = in.nextLine();
            Person person = storage.returnPersonById(id);
            if (person != null && person.getClass() == Patient.class) {
                System.out.println("-- Wrong Id, try again --");
            } else if (person == null) {
                System.out.println("-- Wrong Id, try again --");
            } else {
                temp = false;
            }
        }
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy hh:mm");
        String date = sdf.format(d);
        Patient patient = new Patient(patientName, patientSurname, patientId, patientPhoneNumber, (Doctor) storage.returnPersonById(id), date);
        storage.add(patient);
        System.out.println("-- Completed --");
    }

    static private void printAllPatientsByDoctor() {
        System.out.println("-- Enter ID of the doctor if you want to see the patients --");
        String idOfDoctor = in.nextLine();
        Person person = storage.returnPersonById(idOfDoctor);
        if (person != null && person.getClass() == Doctor.class) {
            storage.returnPatientByDoctor(person);
        } else {
            System.out.println("-- Doctor by this ID is not found --");
        }
    }

    static private void printAllPatients() {
        System.out.println("-- Here are all patients --");
        storage.printAllPatients();
    }

    static private void deletePatientById() {
        System.out.println("-- Enter the ID of the patient who you want to delete --");
        String id = in.nextLine();
        Person person = storage.returnPersonById(id);
        if (person != null && person.getClass() == Patient.class) {
            storage.deletePerson(person);
            System.out.println("-- The patient is deleted --");
        } else {
            System.out.println("-- The patient by this Id is not found --");
        }
    }

    static private void changePatientById() {
        System.out.println("-- Enter the ID of the patient who you want to change --");
        String id = in.nextLine();
        Person person = storage.returnPersonById(id);
        if (person != null && person.getClass() == Patient.class) {
            System.out.println("Old name:" + person.getName() + "  New name... ");
            String newName = in.nextLine();
            person.setName(newName);
            System.out.println("Old surname:" + person.getSurname() + "  New surname... ");
            String newSurname = in.nextLine();
            person.setSurname(newSurname);
            System.out.println("Old PhoneNumber:" + person.getPhoneNumber() + "  New phoneNumber... ");
            long newPhoneNumber = Long.parseLong(in.nextLine());
            person.setPhoneNumber(newPhoneNumber);
            System.out.println("-- Completed --");
        } else {
            System.out.println("-- Patient by this Id is not found --");
        }
    }
}
