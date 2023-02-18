package com.example.furama_resort.model.contract;

import com.example.furama_resort.model.customer.Customer;
import com.example.furama_resort.model.employee.Employee;
import com.example.furama_resort.model.facility.Facility;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(columnDefinition = "DATETIME")
    private String startDate;
    @Column(columnDefinition = "DATETIME")
    private String endDate;
    private double deposit;
    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false, referencedColumnName = "id")
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false, referencedColumnName = "id")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "facility_id", nullable = false, referencedColumnName = "id")
    private Facility facility;
    @OneToMany(mappedBy = "contract")
    private Set<ContractDetail> contractDetailSet;
    private boolean isDelete;

    public Contract() {
    }

    public Set<ContractDetail> getContractDetailSet() {
        return contractDetailSet;
    }

    public void setContractDetailSet(Set<ContractDetail> contractDetailSet) {
        this.contractDetailSet = contractDetailSet;
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

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }
}
