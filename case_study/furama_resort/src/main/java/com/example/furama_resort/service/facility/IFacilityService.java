package com.example.furama_resort.service.facility;

import com.example.furama_resort.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IFacilityService {
    Page<Facility> getAllByNameSearch(String nameSearch, Pageable pageable);
    Page<Facility> getAllByNameSearchAndFacilityType(String nameSearch, long facilityType, Pageable pageable);
    void deleteLogic(long id);
    boolean save(Facility facility);
    boolean edit(Facility facility);
    void findById(long id);
    List<Facility> findAll();
}
