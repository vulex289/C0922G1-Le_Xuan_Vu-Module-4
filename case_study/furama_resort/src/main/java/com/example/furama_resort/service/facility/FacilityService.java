package com.example.furama_resort.service.facility;

import com.example.furama_resort.model.facility.Facility;
import com.example.furama_resort.repository.facility.IFacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class FacilityService implements IFacilityService {
    @Autowired
    private IFacilityRepository facilityRepository;

    @Override
    public Page<Facility> getAllByNameSearch(String nameSearch, Pageable pageable) {
        return facilityRepository.getAllByNameSearch(nameSearch, pageable);
    }

    @Override
    public Page<Facility> getAllByNameSearchAndFacilityType(String nameSearch, long facilityType, Pageable pageable) {
        return facilityRepository.getAllByNameSearchAndFacilityType(nameSearch, facilityType, pageable);
    }

    @Transactional
    @Override
    public void deleteLogic(long id) {
        facilityRepository.deleteLogic(id);
    }

    @Override
    public boolean save(Facility facility) {
        if (facilityRepository.findById(facility.getId()).isPresent()) {
            return false;
        } else {
            facilityRepository.save(facility);
            return true;
        }
    }

    @Override
    public boolean edit(Facility facility) {
        if (!facilityRepository.findById(facility.getId()).isPresent()) {
            return false;
        } else {
            facilityRepository.save(facility);
            return true;
        }
    }

    @Override
    public void findById(long id) {
        facilityRepository.findById(id).orElse(null);
    }

    @Override
    public List<Facility> findAll() {
        return facilityRepository.findAll();
    }

}
