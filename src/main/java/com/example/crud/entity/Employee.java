package com.example.crud.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "employees")
public class Employee{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "departments_seq")
    @SequenceGenerator(name = "departments_seq",
                        sequenceName = "SEQ_DEPARTMENT",
                        allocationSize = 1)
    private Long employeeId;

    @Column(name = "employee_name")
    private String fullName;

    @Column(name = "employee_dateofbirth")
    private String dateOfBirth;

    @Column(name = "employee_phone")
    private String phoneNumber;

    @Column(name = "employee_email")
    private String email;

    @Column(name = "employee_position")
    private String position;

    @Column(name = "employee_date_of_employment")
    private Date dateOfEmployment;

    @ManyToOne (fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    @JoinColumn (name = "department_id")
    private Department department;

    public Employee() {
    }

    public Employee(Long employeeId, Department department,
                    String fullName, String dateOfBirth,
                    String phoneNumber, String email,
                    String position, Date dateOfEmployment) {
        super();
        this.employeeId = employeeId;
        this.department = department;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.position = position;
        this.dateOfEmployment = dateOfEmployment;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Date getDateOfEmployment() {
        return dateOfEmployment;
    }

    public void setDateOfEmployment(Date dateOfEmployment) {
        this.dateOfEmployment = dateOfEmployment;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", department=" + department +
                ", fullName='" + fullName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", position='" + position + '\'' +
                ", dateOfEmployment=" + dateOfEmployment +
                '}';
    }
}
