package com.example.furama_resort.model.employee;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Division {
    @Id
    private long id;
    @Column(columnDefinition = "varchar(45) unique")
    private String name;
    private boolean isDelete;
    @OneToMany(mappedBy = "division")
    private Set<Employee> employeeSet;

    public Division() {
    }

    public Division(long id, String name, boolean isDelete, Set<Employee> employeeSet) {
        this.id = id;
        this.name = name;
        this.isDelete = isDelete;
        this.employeeSet = employeeSet;
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

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public Set<Employee> getEmployeeSet() {
        return employeeSet;
    }

    public void setEmployeeSet(Set<Employee> employeeSet) {
        this.employeeSet = employeeSet;
    }
}
