package com.example.springsercurity.repository;

import com.example.springsercurity.model.AppUser;
import com.example.springsercurity.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUserRoleRepository extends JpaRepository<UserRole,Long> {
    List<UserRole> findByAppUser(AppUser appUser);
}
