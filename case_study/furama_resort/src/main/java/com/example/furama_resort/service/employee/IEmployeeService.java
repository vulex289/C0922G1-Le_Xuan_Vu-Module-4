package com.example.furama_resort.service.employee;

import com.example.furama_resort.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEmployeeService {
    Page<Employee> findAll(String nameSearch, Pageable pageable);
    void save(Employee employee);
    void edit(Employee employee);
    Employee findById(long id);
    void deleteById(long id);
}
