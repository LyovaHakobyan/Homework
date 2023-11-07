package homeworks.medicalcenter.model;

import java.util.Objects;

public class Doctor extends Person {
    private String email;
    private String profession;

    public Doctor(String name, String surname, String id, long phoneNumber, String email, String profession) {
        super(name, surname, id, phoneNumber);
        this.email = email;
        this.profession = profession;
    }

    public Doctor() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    @Override
    public String toString() {
        return "[ Doctor name:" + getName() + " Surname:" + getSurname() + " PhoneNumber:" + getPhoneNumber() + " ID:" + getId() + " Mail:" + email + " Profession:" + profession + " ]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Doctor doctor = (Doctor) o;

        if (!Objects.equals(email, doctor.email)) return false;
        return Objects.equals(profession, doctor.profession);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (profession != null ? profession.hashCode() : 0);
        return result;
    }
}
