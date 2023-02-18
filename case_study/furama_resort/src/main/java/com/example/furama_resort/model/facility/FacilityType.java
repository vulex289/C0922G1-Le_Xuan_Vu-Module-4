package com.example.furama_resort.model.facility;

import com.example.furama_resort.model.facility.Facility;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "facility_type")
public class FacilityType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(columnDefinition = "varchar(45)")
    private String name;
    @OneToMany(mappedBy = "facilityType")
    private Set<Facility> facilitySet;
    private boolean isDelete;

    public FacilityType() {
    }

    public FacilityType(long id, String name, Set<Facility> facilitySet, boolean isDelete) {
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
