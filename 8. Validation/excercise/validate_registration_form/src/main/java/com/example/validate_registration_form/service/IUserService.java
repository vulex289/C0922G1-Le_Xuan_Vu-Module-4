package com.example.validate_registration_form.service;

import com.example.validate_registration_form.model.User;

import java.util.List;

public interface IUserService {
    List<User>findAll();
    boolean save(User user);
//    boolean isEmailExists(String email);
}
