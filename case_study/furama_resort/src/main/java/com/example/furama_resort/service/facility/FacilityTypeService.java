package com.example.furama_resort.service.facility;

import com.example.furama_resort.model.facility.FacilityType;
import com.example.furama_resort.repository.facility.IFacilityTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FacilityTypeService implements IFacilityTypeService{
    @Autowired
    private IFacilityTypeRepository facilityTypeRepository;
    @Override
    public List<FacilityType> findAll() {
        return facilityTypeRepository.findAll();
    }
}
