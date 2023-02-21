package com.example.furama_resort.model.employee;

import com.example.furama_resort.model.contract.Contract;
import com.example.furama_resort.model.facility.RentType;
import com.example.furama_resort.model.security.User;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(columnDefinition = "varchar(45)")
    private String name;
    @Column(columnDefinition = "date")
    private String dateOfBirth;
    @Column(columnDefinition = "varchar(45) unique")
    private String idCard;
    private double salary;
    @Column(columnDefinition = "varchar(45) unique")
    private String phoneNumber;
    @Column(columnDefinition = "varchar(45) unique")
    private String email;
    @Column(columnDefinition = "varchar(45)")
    private String address;
    @ManyToOne
    @JoinColumn(name = "position_id",nullable = false,referencedColumnName = "id")
    private Position position;
    @ManyToOne
    @JoinColumn(name = "education_degree_id",nullable = false,referencedColumnName = "id")
    private EducationDegree educationDegree;
    @ManyToOne
    @JoinColumn(name = "division_id",nullable = false,referencedColumnName = "id")
    private Division division;
    @OneToOne
    @JoinColumn(name = "username",referencedColumnName = "username",columnDefinition = "varchar(255)")
    private User user;
    @OneToMany(mappedBy = "employee")
    private Set<Contract> contractSet;
    private boolean isDelete;
    public Employee() {
    }

    public Set<Contract> getContractSet() {
        return contractSet;
    }

    public void setContractSet(Set<Contract> contractSet) {
        this.contractSet = contractSet;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }
}
