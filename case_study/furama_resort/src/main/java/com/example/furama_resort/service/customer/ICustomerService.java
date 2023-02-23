package com.example.furama_resort.service.customer;
import com.example.furama_resort.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface ICustomerService {
    Page<Customer>findAll(String name,  String email, long customerTypeId, Pageable pageable);
    Page<Customer>findAllAndSearchNotCustomerType(String name,  String email, Pageable pageable);
    List<Customer> findAll();
    boolean save(Customer customer);
    Customer findById(long id);
    boolean edit(Customer customer);
    void deleteLogic(long id);
    void delete(Customer customer);
}
