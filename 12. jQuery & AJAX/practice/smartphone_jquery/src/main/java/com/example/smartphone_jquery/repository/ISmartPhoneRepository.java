package com.example.smartphone_jquery.repository;

import com.example.smartphone_jquery.model.Smartphone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISmartPhoneRepository extends JpaRepository<Smartphone,Long> {
}
