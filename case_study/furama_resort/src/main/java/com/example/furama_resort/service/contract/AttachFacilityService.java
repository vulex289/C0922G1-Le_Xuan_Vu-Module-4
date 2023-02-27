package com.example.furama_resort.service.contract;

import com.example.furama_resort.model.contract.AttachFacility;
import com.example.furama_resort.dto.IAttachFacilityDto;
import com.example.furama_resort.repository.contract.IAttachFacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AttachFacilityService implements IAttachFacilityService {
    @Autowired
    private IAttachFacilityRepository attachFacilityRepository;
    @Override
    public List<AttachFacility> findAll() {
        return attachFacilityRepository.findAll();
    }

    @Override
    public List<IAttachFacilityDto> findByContractId(long id) {
        return attachFacilityRepository.findByContractId(id);
    }
}
