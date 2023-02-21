package com.example.furama_resort.model.facility;

import com.example.furama_resort.model.facility.Facility;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "rent_type")
public class RentType {
    @Id
    private long id;
    @Column(columnDefinition = "varchar(45) unique")
    private String name;
    @OneToMany(mappedBy = "rentType")
    @JsonBackReference
    private Set<Facility> facilitySet;
    private boolean isDelete;

    public RentType() {
    }

    public RentType(long id, String name, Set<Facility> facilitySet, boolean isDelete) {
        this.id = id;
        this.name = name;
        this.facilitySet = facilitySet;
        this.isDelete = isDelete;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Facility> getFacilitySet() {
        return facilitySet;
    }

    public void setFacilitySet(Set<Facility> facilitySet) {
        this.facilitySet = facilitySet;
    }
}
