package com.example.crud.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "departments")
public class Department{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "department_seq")
    @SequenceGenerator(name = "department_seq",
                        sequenceName = "SEQ_DEPARTMENT",
                        allocationSize = 1)
    @Column(name = "department_id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "department_name")
    private String name;

    @Column(name = "department_description")
    private String description;

    @Column (name = "department_phone")
    private String phoneNumber;

    @Column (name = "department_date_of_formation")
    private Date dateOfFormation;

    @OneToMany(fetch = FetchType.EAGER,
                mappedBy = "department",
                cascade = CascadeType.ALL)
    private List<Employee> employee;

    public Department() {
    }

    public Department(String name,
                      String description, String phoneNumber,
                      Date dateOfFormation) {
        super();
        this.name = name;
        this.description = description;
        this.phoneNumber = phoneNumber;
        this.dateOfFormation = dateOfFormation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Date getDateOfFormation() {
        return dateOfFormation;
    }

    public void setDateOfFormation(Date dateOfFormation) {
        this.dateOfFormation = dateOfFormation;
    }

    public List<Employee> getEmployees() {
        return employee;
    }

    public void setEmployees(List<Employee> employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", dateOfFormation=" + dateOfFormation +
                '}';
    }
}
