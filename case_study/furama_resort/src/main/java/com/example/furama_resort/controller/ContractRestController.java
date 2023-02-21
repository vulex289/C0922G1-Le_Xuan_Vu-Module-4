package com.example.furama_resort.controller;

import com.example.furama_resort.model.dto.IAttachFacilityDto;
import com.example.furama_resort.service.contract.IAttachFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
public class ContractRestController {
    @Autowired
    private IAttachFacilityService attachFacilityService;

    @GetMapping("api/contract/{id}")
    public ResponseEntity<List<IAttachFacilityDto>> getAttachFacility(@PathVariable long id) {
        List<IAttachFacilityDto> attachFacilityDtos = attachFacilityService.findByContractId(id);

        if (attachFacilityDtos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<List<IAttachFacilityDto>>(attachFacilityDtos, HttpStatus.OK);
        }
    }
}
