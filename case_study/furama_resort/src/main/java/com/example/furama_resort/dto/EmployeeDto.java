package com.example.furama_resort.dto;

import com.example.furama_resort.model.employee.Division;
import com.example.furama_resort.model.employee.EducationDegree;
import com.example.furama_resort.model.employee.Position;
import javax.validation.constraints.*;

public class EmployeeDto {
    private long id;
    @NotBlank(message = "Bạn đang để trống trường này")
    @NotEmpty(message = "Bạn đang để trống trường này")
    @Pattern(regexp = "^([\\p{L}\\s])+$",message = "Bạn phải nhập đúng định dạng tên")
    private String name;
    @NotBlank(message = "Bạn đang để trống trường này")
    @NotEmpty(message = "Bạn đang để trống trường này")
    private String dateOfBirth;
    @Pattern(regexp = "^\\d{9,12}$",message = "Bạn phải nhap đúng định dạng CMND")
    private String idCard;
    @Min(value = 1)
    private double salary;
    @Pattern(regexp = "^(([(]84[)][+]91)|([(]84[)][+]90)|090|091)\\d{7}$", message = "Bạn phải nhập đúng định dạng số điện thoại")
    private String phoneNumber;
    @Email(message = "Bạn phải nhập đún định dạng email")
    private String email;
    @NotBlank(message = "Bạn đang để trống trường này")
    @NotEmpty(message = "Bạn đang để trống trường này")
    private String address;
    private Position position;
    private EducationDegree educationDegree;
    private Division division;

    public EmployeeDto() {
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
}
