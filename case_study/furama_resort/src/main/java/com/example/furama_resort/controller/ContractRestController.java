package com.example.furama_resort.controller;

import com.example.furama_resort.model.contract.Contract;
import com.example.furama_resort.model.contract.ContractAndAttachFacilityDto;
import com.example.furama_resort.model.contract.ContractDetail;
import com.example.furama_resort.model.dto.IAttachFacilityDto;
import com.example.furama_resort.service.contract.IAttachFacilityService;
import com.example.furama_resort.service.contract.IContractDetailService;
import com.example.furama_resort.service.contract.IContractService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@CrossOrigin("*")
@RestController
public class ContractRestController {
    @Autowired
    private IAttachFacilityService attachFacilityService;
    @Autowired
    private IContractDetailService contractDetailService;
    @Autowired
    private IContractService contractService;

    @GetMapping("/api/contract/{id}")
    public ResponseEntity<List<IAttachFacilityDto>> getAttachFacility(@PathVariable long id) {
        List<IAttachFacilityDto> attachFacilityDtos = attachFacilityService.findByContractId(id);

        if (attachFacilityDtos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<List<IAttachFacilityDto>>(attachFacilityDtos, HttpStatus.OK);
        }
    }

    @PostMapping("/api/contract/create")
    public ResponseEntity<?> createSmartphone(@RequestBody List<ContractAndAttachFacilityDto> contractAndAttachFacilityDtos) {
        if (contractAndAttachFacilityDtos.size() == 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            Contract contract = new Contract();
            BeanUtils.copyProperties(contractAndAttachFacilityDtos.get(0).getContract(), contract);
            Contract contract1 = contractService.save(contract);
            for (int i = 0; i < contractAndAttachFacilityDtos.size(); i++) {
                ContractDetail contractDetail = new ContractDetail();
                BeanUtils.copyProperties(contractAndAttachFacilityDtos.get(i), contractDetail);
                contractDetail.setContract(contract1);
                contractDetailService.save(contractDetail);
            }
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }
}
