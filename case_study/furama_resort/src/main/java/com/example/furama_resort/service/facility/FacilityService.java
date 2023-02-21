package com.example.furama_resort.service.facility;

import com.example.furama_resort.model.facility.Facility;
import com.example.furama_resort.repository.facility.IFacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class FacilityService implements IFacilityService{
    @Autowired
    private IFacilityRepository facilityRepository;
    @Override
    public Page<Facility> findAll(String nameSearch, String facilityType, Pageable pageable) {
        return facilityRepository.findAll(nameSearch,facilityType,pageable);
    }
@Transactional
    @Override
    public void deleteLogic(long id) {
    facilityRepository.deleteLogic(id);
    }

    @Override
    public void save(Facility facility) {
    facilityRepository.save(facility);
    }

    @Override
    public void edit(Facility facility) {
    facilityRepository.save(facility);
    }

    @Override
    public void findById(long id) {
    facilityRepository.findById(id).orElse(null);
    }
}
