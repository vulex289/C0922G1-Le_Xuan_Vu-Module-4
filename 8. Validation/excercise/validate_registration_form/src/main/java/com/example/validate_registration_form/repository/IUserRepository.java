package com.example.validate_registration_form.repository;

import com.example.validate_registration_form.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User,Integer> {
}
