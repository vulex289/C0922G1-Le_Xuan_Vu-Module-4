package com.example.furama_resort.model;

import javax.persistence.*;

@Entity
public class Facility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long facilityId;
    private String name;
    private int area;
    private double cost;
    private int maxPeople;
    private String standardRoom;
    private String descriptionOtherConvenience;
    private double poolArea;
    private int numberOfFloors;
    private String facilityFree;
    private boolean isDelete;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "facility_type_id",nullable = false,referencedColumnName = "facility_type_id")
    private FacilityType facilityType;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rent_type_id",nullable = false,referencedColumnName = "rent_type_id")
    private RentType rentType;






}
