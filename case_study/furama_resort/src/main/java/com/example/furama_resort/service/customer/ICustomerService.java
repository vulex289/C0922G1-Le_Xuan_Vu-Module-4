package com.example.furama_resort.service.customer;

import com.example.furama_resort.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICustomerService {
    Page<Customer>findAll(String name,  String email, String customerTypeId, Pageable pageable);
    List<Customer> findAll();
    void save(Customer customer);
    Customer findById(long id);
    void edit(Customer customer);
    void deleteLogic(long id);
    void delete(Customer customer);
}
