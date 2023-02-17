package com.example.validate_registration_form.repository;

import com.example.validate_registration_form.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<User,Integer> {
@Query(value = "select email from user",nativeQuery = true)
List<String> findByEmail();

}
