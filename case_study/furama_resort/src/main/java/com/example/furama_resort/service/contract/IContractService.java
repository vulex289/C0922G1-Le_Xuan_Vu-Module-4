package com.example.furama_resort.service.contract;

import com.example.furama_resort.model.contract.Contract;
import com.example.furama_resort.dto.IContractDto;

import java.util.List;

public interface IContractService {
    List<IContractDto> getAllContracts();
    Contract save(Contract contract);
}
