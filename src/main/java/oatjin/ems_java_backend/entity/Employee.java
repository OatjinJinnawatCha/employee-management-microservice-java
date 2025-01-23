package oatjin.ems_java_backend.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name= "employee")
public class Employee {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="nick_name")
    private String nickName;

    @Column(name="email")
    private String email;

    @Column(name="department")
    private String department;

    @Column(name="job_title")
    private String jobTitle;

    @Column(name = "date_added", nullable = false)
    private LocalDateTime dateAdded;

    @Column(name="updated_date")
    private Timestamp updatedDate;

    @Column(name="employee_code", nullable = false)
    private String employeeCode;

    public Employee(int id, String firstName, String lastName, String nickName, String email, String department, String jobTitle, LocalDateTime dateAdded, Timestamp updated_date, String employeeCode) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickName = nickName;
        this.email = email;
        this.department = department;
        this.jobTitle = jobTitle;
        this.dateAdded = dateAdded;
        this.updatedDate = updated_date;
        this.employeeCode = employeeCode;
    }

    public Employee() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public LocalDateTime getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDateTime dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public Timestamp getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Timestamp updated_date) {
        this.updatedDate = updated_date;
    }
}
