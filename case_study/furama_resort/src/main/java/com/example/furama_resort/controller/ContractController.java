package com.example.furama_resort.controller;

import com.example.furama_resort.model.contract.ContractDetail;
import com.example.furama_resort.service.contract.IAttachFacilityService;
import com.example.furama_resort.service.contract.IContractDetailService;
import com.example.furama_resort.service.contract.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContractController {
    @Autowired
    private IContractService contractService;
    @Autowired
    private IContractDetailService contractDetailService;
    @Autowired
    private IAttachFacilityService attachFacilityService;


    @GetMapping("/furama/contract")
    public String showList(Model model){
        model.addAttribute("contracts",contractService.getAllContracts());
        model.addAttribute("attachFacilities",attachFacilityService.findAll());
        model.addAttribute("contractDetail",new ContractDetail());
        return "contract/list";
    }
    @PostMapping("furama/createContractDetail")
        public String saveContractDetail(@ModelAttribute ContractDetail contractDetail){
        contractDetailService.save(contractDetail);
        return "redirect:/furama/contract";
    }
}
