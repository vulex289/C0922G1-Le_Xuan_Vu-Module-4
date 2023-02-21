package com.example.furama_resort.service.facility;

import com.example.furama_resort.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface IFacilityService {
    Page<Facility> findAll(String nameSearch, String facilityType, Pageable pageable);
    void deleteLogic(long id);
    void save(Facility facility);
    void edit(Facility facility);
    void findById(long id);
}
