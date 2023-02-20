package com.example.furama_resort.service.employee;

import com.example.furama_resort.model.employee.Division;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IDivisionService  {
    List<Division> findAll();
}
