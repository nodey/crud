package com.example.crud.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "departments")
public class Department implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "department_id")
    @ApiModelProperty(notes = "Department ID")
    private int id;

    @Column(name = "department_name")
    @ApiModelProperty(notes = "Department name")
    private String name;

    @Size(min = 20)
    @Size(max = 255)
    @Column(name = "department_description")
    @ApiModelProperty(notes = "Department description")
    private String description;

    @Column (name = "department_phone")
    @Size(min = 13)
    @Size(max = 13)
    @ApiModelProperty(notes = "Department phone number")
    private String phoneNumber;

    @Size(min = 10)
    @Size(max = 10)
    @Column (name = "department_date_of_formation")
    @ApiModelProperty(notes = "Date of establishment of the department")
    private String dateOfFormation;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id")
    @ApiModelProperty(notes = "All employees of the department")
    private List<Employee> employees;

    public Department() {
    super();
    }

    public Department(int id, String name, String description,
                      String phoneNumber, String dateOfFormation,
                      List<Employee> employees) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.phoneNumber = phoneNumber;
        this.dateOfFormation = dateOfFormation;
        this.employees = employees;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDateOfFormation() {
        return dateOfFormation;
    }

    public void setDateOfFormation(String dateOfFormation) {
        this.dateOfFormation = dateOfFormation;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", dateOfFormation='" + dateOfFormation + '\'' +
                ", employees=" + employees +
                '}';
    }
}
