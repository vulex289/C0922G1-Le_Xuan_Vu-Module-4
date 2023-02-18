package com.example.furama_resort.model.customer;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "customer_type")
public class CustomerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(columnDefinition = "varchar(45)")
    private String name;
    @OneToMany(mappedBy = "customerType")

    private Set<Customer> customerSet;

    private boolean isDelete;

    public CustomerType() {
    }

    public CustomerType(long id, String name, Set<Customer> customerSet, boolean isDelete) {
        this.id = id;
        this.name = name;
        this.customerSet = customerSet;
        this.isDelete = isDelete;
    }

    public Set<Customer> getCustomerSet() {
        return customerSet;
    }

    public void setCustomerSet(Set<Customer> customerSet) {
        this.customerSet = customerSet;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
