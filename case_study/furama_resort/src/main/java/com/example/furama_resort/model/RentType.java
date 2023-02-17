package com.example.furama_resort.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "rent_type")
public class RentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rent_type_id")
    private long rentTypeId;
    private String name;
    @OneToMany(mappedBy = "rentType")
    @JsonBackReference
    private Set<Facility> facilitySet;
    public RentType() {
    }

    public RentType(long rentTypeId, String name, Set<Facility> facilitySet) {
        this.rentTypeId = rentTypeId;
        this.name = name;
        this.facilitySet = facilitySet;
    }

    public long getRentTypeId() {
        return rentTypeId;
    }

    public void setRentTypeId(long rentTypeId) {
        this.rentTypeId = rentTypeId;
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
