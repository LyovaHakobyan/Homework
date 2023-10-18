package homeworks.medicalcenter.models;

import homeworks.medicalcenter.util.DateUtil;

import java.util.Date;
import java.util.Objects;

public class Patient extends Person {
    private Doctor doctor;
    private Date registerDateTime;

    public Patient(String name, String surname, String id, long phoneNumber, Doctor doctor, Date registerDateTime) {
        super(name, surname, id, phoneNumber);
        this.doctor = doctor;
        this.registerDateTime = registerDateTime;
    }

    public Patient() {
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Date getRegisterDateTime() {
        return registerDateTime;
    }

    public void setRegisterDateTime(Date registerDateTime) {
        this.registerDateTime = registerDateTime;
    }

    @Override
    public String toString() {
        return "Patient name:" + getName() + " Surname:" + getSurname() + " PhoneNumber:" + getPhoneNumber() + " ID:" + getId() + " Doctor:" + doctor + " RegisterDate:" + DateUtil.dateTostring(registerDateTime);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Patient patient = (Patient) o;

        if (!Objects.equals(doctor, patient.doctor)) return false;
        return Objects.equals(registerDateTime, patient.registerDateTime);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (doctor != null ? doctor.hashCode() : 0);
        result = 31 * result + (registerDateTime != null ? registerDateTime.hashCode() : 0);
        return result;
    }
}
