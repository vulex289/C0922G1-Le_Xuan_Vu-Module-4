package com.example.furama_resort.service.employee.impl;
import com.example.furama_resort.model.employee.Employee;
import com.example.furama_resort.repository.employee.IEmployeeRepository;
import com.example.furama_resort.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository employeeRepository;


    @Override
    public Page<Employee> findAll(String nameSearch, Pageable pageable) {
        return employeeRepository.findAll(nameSearch,pageable);
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void edit(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Employee findById(long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public static interface IEmployeeService {
        Page<Employee> findAll(String nameSearch, Pageable pageable);
        void save(Employee employee);
        void edit(Employee employee);
        Employee findById(long id);
        void deleteById(long id);
    }
}
