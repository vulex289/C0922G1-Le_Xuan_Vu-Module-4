package com.example.furama_resort.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "customer_type")
public class CustomerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private long customerTypeId;
    private String name;
    @OneToMany(mappedBy = "customerType")
    @JsonManagedReference
    private Set<Customer> customer;

    public CustomerType() {
    }

    public CustomerType(long customerTypeId, String name, Set<Customer> customer) {
        this.customerTypeId = customerTypeId;
        this.name = name;
        this.customer = customer;
    }

    public long getCustomerTypeId() {
        return customerTypeId;
    }

    public void setCustomerTypeId(long customerTypeId) {
        this.customerTypeId = customerTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Customer> getCustomer() {
        return customer;
    }

    public void setCustomer(Set<Customer> customer) {
        this.customer = customer;
    }
}
