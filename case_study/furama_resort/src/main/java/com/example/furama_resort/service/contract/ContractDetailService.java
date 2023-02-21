package com.example.furama_resort.service.contract;

import com.example.furama_resort.model.contract.ContractDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDetailService implements IContractDetailService{
    @Autowired
    private IContractDetailService contractDetailService;
    @Override
    public List<ContractDetail> findAll() {
        return contractDetailService.findAll();
    }

    @Override
    public void save(ContractDetail contractDetail) {
    contractDetailService.save(contractDetail);
    }
}
