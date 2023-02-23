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
    public Page<Customer> findAll(String name, String email, long customerTypeId, Pageable pageable) {
        return customerRepository.findAll(name,email,customerTypeId,pageable);
    }

    @Override
    public Page<Customer> findAllAndSearchNotCustomerType(String name, String email,Pageable pageable) {
        return customerRepository.findAllAndSearchNotCustomerType(name,email,pageable);
    }


    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public boolean save(Customer customer) {
        for (Customer customer1 : customerRepository.findAll()) {
            if (customer1.getId() == customer.getId()) {
                return false;
            }
        }
        customerRepository.save(customer);
        return true;
    }


    @Override
    public Customer findById(long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public boolean edit(Customer customer) {
        if (!customerRepository.findById(customer.getId()).isPresent()){
            return false;
        }else {
            customerRepository.save(customer);
            return true;
        }
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
