package com.example.furama_resort.repository.employee;

import com.example.furama_resort.model.employee.Division;
import com.example.furama_resort.model.employee.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPositionRepository extends JpaRepository<Position,Long> {
}
