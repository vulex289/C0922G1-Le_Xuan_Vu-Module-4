package com.example.furama_resort.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "facility_type")
public class FacilityType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "facility_type_id")
    private long facilityTypeId;
    private String name;
    @OneToMany(mappedBy = "facilityType")
    @JsonBackReference
    private Set<Facility> facilitySet;
    public FacilityType() {
    }

    public FacilityType(long facilityTypeId, String name, Set<Facility> facilitySet) {
        this.facilityTypeId = facilityTypeId;
        this.name = name;
        this.facilitySet = facilitySet;
    }

    public long getFacilityTypeId() {
        return facilityTypeId;
    }

    public void setFacilityTypeId(long facilityTypeId) {
        this.facilityTypeId = facilityTypeId;
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
