package com.example.springsercurity.repository;

import com.example.springsercurity.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppUserRepository extends JpaRepository<AppUser,Long> {
    AppUser findByUserName(String userName);
}
