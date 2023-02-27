package com.example.furama_resort.service.contract;

import com.example.furama_resort.model.contract.AttachFacility;
import com.example.furama_resort.dto.IAttachFacilityDto;

import java.util.List;

public interface IAttachFacilityService {
    List<AttachFacility> findAll();
    List<IAttachFacilityDto> findByContractId( long id);
}
