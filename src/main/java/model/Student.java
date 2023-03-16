package model;

public class Student implements Comparable<Student> {
    private String id;
    private String full_name;
    private int gender;
    private String datebirth;
    private String address;
    private String phone;
    private String email;
    private double GPA;

    public Student() {
    }

    public Student(String id, String full_name, int gender, String datebirth, String address, String phone, String email, double GPA) {
        this.id = id;
        this.full_name = full_name;
        this.gender = gender;
        this.datebirth = datebirth;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.GPA = GPA;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getDatebirth() {
        return datebirth;
    }

    public void setDatebirth(String datebirth) {
        this.datebirth = datebirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", full_name='" + full_name + '\'' +
                ", gender=" + gender +
                ", datebirth='" + datebirth + '\'' +
                ", address='" + address+ '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", GPA=" + GPA +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        return 0;
    }
}
