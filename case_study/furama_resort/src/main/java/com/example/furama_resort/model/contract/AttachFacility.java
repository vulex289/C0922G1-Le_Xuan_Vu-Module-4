package com.example.furama_resort.model.contract;

import javax.persistence.*;
import java.util.Set;

@Entity
public class AttachFacility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(columnDefinition = "varchar(45)")
    private String name;
    private double cost;
    @Column(columnDefinition = "varchar(10)")
    private String unit;
    @Column(columnDefinition = "varchar(45)")
    private String status;
    private boolean isDelete;
    @OneToMany(mappedBy = "attachFacility")
    private Set<ContractDetail> contractDetailSet;

    public AttachFacility() {
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public Set<ContractDetail> getContractDetailSet() {
        return contractDetailSet;
    }

    public void setContractDetailSet(Set<ContractDetail> contractDetailSet) {
        this.contractDetailSet = contractDetailSet;
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

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
