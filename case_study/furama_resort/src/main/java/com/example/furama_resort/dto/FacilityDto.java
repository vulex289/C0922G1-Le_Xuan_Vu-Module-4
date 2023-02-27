package com.example.furama_resort.dto;

import com.example.furama_resort.model.facility.FacilityType;
import com.example.furama_resort.model.facility.RentType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

public class FacilityDto implements Validator {
    private long id;
    @Pattern(regexp = "^([A-Z]([a-z]+)|\\s|\\d)+$")
    private String name;
    @Min(value = 1)
    private int area;
    @Min(value = 1)
    private double cost;
    private int maxPeople;

    private String standardRoom;

    private String descriptionOtherConvenience;
    @Min(value = 1)
    private double poolArea;
    private RentType rentType;
    private FacilityType facilityType;

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public FacilityType getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(FacilityType facilityType) {
        this.facilityType = facilityType;
    }

    private int numberOfFloors;

    private String facilityFree;

    public FacilityDto() {
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

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public String getFacilityFree() {
        return facilityFree;
    }

    public void setFacilityFree(String facilityFree) {
        this.facilityFree = facilityFree;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        FacilityDto facilityDto = (FacilityDto) target;
        String numberOfFloors = String.valueOf(facilityDto.getNumberOfFloors());
        String maxPeople = String.valueOf(facilityDto.getMaxPeople());
        if (!(numberOfFloors).matches("^([1-9]\\d)|[1-9]+$")) {
            errors.rejectValue("numberOfFloors", "aa", "Số tầng phải là số nguyên dương");
        }
        if (!(maxPeople).matches("^([1-9]\\d)|[1-9]+$")) {
            errors.rejectValue("maxPeople", "aa", "Số nguời phải là số nguyên dương");
        }
    }
}
