package com.example.furama_resort.service.contract;

import com.example.furama_resort.model.contract.ContractDetail;

import java.util.List;

public interface IContractDetailService {
    List<ContractDetail>findAll();
    void save(ContractDetail contractDetail);
}
