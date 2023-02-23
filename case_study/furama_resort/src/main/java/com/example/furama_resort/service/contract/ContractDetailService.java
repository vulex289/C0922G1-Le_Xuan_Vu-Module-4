package com.example.furama_resort.service.contract;

import com.example.furama_resort.model.contract.ContractDetail;
import com.example.furama_resort.repository.contract.IContractDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDetailService implements IContractDetailService{
    @Autowired
    private IContractDetailRepository contractDetailRepository;
    @Override
    public List<ContractDetail> findAll() {
        return contractDetailRepository.findAll();
    }

    @Override
    public void save(ContractDetail contractDetail) {
    contractDetailRepository.save(contractDetail);
    }
}
