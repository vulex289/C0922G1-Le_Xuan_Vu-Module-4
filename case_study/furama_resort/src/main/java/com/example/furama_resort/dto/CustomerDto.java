package com.example.furama_resort.dto;

import com.example.furama_resort.model.customer.CustomerType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CustomerDto implements Validator {
    private long id;
    @NotBlank(message = "Bạn đang để trống trường này")
    @NotEmpty(message = "Bạn đang để trống trường này")
    @Pattern(regexp = "^([\\p{L}\\s])+$",message = "Bạn phải nhập đúng định dạng tên")
    private String name;
    @NotBlank(message = "Bạn đang để trống trường này")
    @NotEmpty(message = "Bạn đang để trống trường này")
    @NotNull
    private String dateOfBirth;
    private int gender;
    @NotBlank(message = "Bạn đang để trống trường này")
    @NotEmpty(message = "Bạn đang để trống trường này")
    @Pattern(regexp = "^([1-9])([0-9]){8,11}$",message = "Bạn phải nhập đúng định dạng")
    private String idCard;
    @NotBlank(message = "Bạn đang để trống trường này")
    @NotEmpty(message = "Bạn đang để trống trường này")
    @Pattern(regexp = "^(([(]84[)][+]91)|([(]84[)][+]90)|090|091)\\d{7}$", message = "Bạn phải nhập đúng định dạng số điện thoại")
    private String phoneNumber;
    @NotBlank(message = "Bạn đang để trống trường này")
    @NotEmpty(message = "Bạn đang để trống trường này")
    @Email(message = "Nhập đúng định dạng của email")
    private String email;
    @NotBlank(message = "Bạn đang để trống trường này")
    @NotEmpty(message = "Bạn đang để trống trường này")
    private String address;
    private CustomerType customerType;

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public CustomerDto() {
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

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDto customerDto = (CustomerDto) target;
        String dateOfBirth = customerDto.getDateOfBirth();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(dateOfBirth, dateTimeFormatter);
        LocalDate currentDate = LocalDate.now();
        if (date.isAfter(currentDate)) {
            errors.rejectValue("dateOfBirth","aa","Ngay sinh phải nhỏ hơn ngày hien tại");
        }
    }
}
