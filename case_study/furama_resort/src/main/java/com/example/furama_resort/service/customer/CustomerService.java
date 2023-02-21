package com.example.furama_resort.service.customer;

import com.example.furama_resort.model.customer.Customer;
import com.example.furama_resort.repository.customer.ICustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public Page<Customer> findAll(String name, String email, String customerTypeId, Pageable pageable) {
        return customerRepository.findAll(name, email, customerTypeId, pageable);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Customer findById(long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public void edit(Customer customer) {
        customerRepository.save(customer);
    }

    @Transactional
    @Override
    public void deleteLogic(long id) {
        customerRepository.deleteLogic(id);
    }

    @Override
    public void delete(Customer customer) {
        customerRepository.delete(customer);
    }
}
