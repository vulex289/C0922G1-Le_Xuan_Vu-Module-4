package com.example.furama_resort.service.contract;

import com.example.furama_resort.model.contract.Contract;
import com.example.furama_resort.model.dto.IContractDto;
import com.example.furama_resort.repository.contract.IContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService implements IContractService {

    @Autowired
    private IContractRepository contractRepository;

    @Override
    public List<IContractDto> getAllContracts() {
        return contractRepository.getAllContracts();
    }

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }
}
