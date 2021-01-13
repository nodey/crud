package com.example.crud.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "employees")
public class Employee implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_id")
    @ApiModelProperty(notes = "Employee ID")
    private int id;

    @Column(name = "department_id")
    @JsonProperty("departmentId")
    @ApiModelProperty(notes = "ID of the department where the employee works")
    private int departmentId;

    @Column(name = "employee_name")
    @ApiModelProperty(notes = "Full name of employee")
    private String fullName;

    @Column(name = "employee_date_of_birth")
    @Size(min = 10)
    @Size(max = 10)
    @ApiModelProperty(notes = "Employee's birthday")
    private String dateOfBirth;

    @Column(name = "employee_phone")
    @Size(min = 13)
    @Size(max = 13)
    @ApiModelProperty(notes = "Employee's mobile phone")
    private String phoneNumber;

    @Column(name = "employee_email")
    @Email
    @ApiModelProperty(notes = "Employee email")
    private String email;

    @Column(name = "employee_position")
    @ApiModelProperty(notes = "Employee's position")
    private String position;

    @Column(name = "employee_date_of_employment")
    @Size(min = 10)
    @Size(max = 10)
    @ApiModelProperty(notes = "Employee date of employment")
    private String dateOfEmployment;

    public Employee() {
    }

    public Employee(int id, int departmentId, String fullName,
                    String dateOfBirth, String phoneNumber, String email,
                    String position, String dateOfEmployment) {
        this.id = id;
        this.departmentId = departmentId;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.position = position;
        this.dateOfEmployment = dateOfEmployment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
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

    public String getDateOfEmployment() {
        return dateOfEmployment;
    }

    public void setDateOfEmployment(String dateOfEmployment) {
        this.dateOfEmployment = dateOfEmployment;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", departmentId=" + departmentId +
                ", fullName='" + fullName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", position='" + position + '\'' +
                ", dateOfEmployment=" + dateOfEmployment +
                '}';
    }
}
