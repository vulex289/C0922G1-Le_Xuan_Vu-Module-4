package com.example.validate_registration_form.service;

import com.example.validate_registration_form.model.User;
import com.example.validate_registration_form.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public boolean save(User user) {
        if (userRepository.findById(user.getId()).isPresent()) {
            return false;
        }
        try {
            userRepository.save(user);
        } catch (DataIntegrityViolationException e) {
            return false;
        }
        return true;
    }

//    @Override
//    public boolean isEmailExists(String email) {
//        for (User user:userRepository.findAll()) {
//            if (user.getEmail().equals(email)){
//                return true;
//            }
//        }
//        return false;
//    }
}
