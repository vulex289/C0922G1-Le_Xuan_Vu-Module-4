package com.example.validate_registration_form.dto;

import com.example.validate_registration_form.model.User;
import com.example.validate_registration_form.repository.IUserRepository;
import com.example.validate_registration_form.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Column;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Optional;

//@Component
public class UserDto implements Validator {


    private int id;
    @NotBlank(message = "Bạn phải nhập vào kí tự")
    @NotEmpty(message = "Bạn phải điền vào ô trống")
    @Size(min = 5,max = 45)
    private String firstName;
    @NotBlank(message = "Bạn phải nhập vào kí tự")
    @NotEmpty(message = "Bạn phải điền vào ô trống")
    @Size(min = 5,max = 45)
    private String lastName;
    @NotBlank(message = "Bạn phải nhập vào kí tự")
    @NotEmpty(message = "Bạn phải điền vào ô trống")
    @Pattern(regexp = "^[0]\\d{9}$",message = "Bạn phải nhập đúng sđt của VN")
    private String phoneNumber;

    @Min(value = 18,message = "Số tuổi phải lớn hơn hoặc bằng 18")
    private int age;
    @NotBlank(message = "Bạn phải nhập vào kí tự")
    @NotEmpty(message = "Bạn phải điền vào ô trống")
    @Email(message = "bạn phải nhập đúng định dạng của email")
    private String email;
    public UserDto() {
    }

    public UserDto(int id, String firstName, String lastName, String phoneNumber, int age, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors){
//    UserDto userDto = (UserDto)target;
//    String email = userDto.getEmail();
////    if (userRepository.findByEmail().contains(email)){
////        errors.rejectValue("email","phone123","Email đã tồn tại");
////    }
    }

}
