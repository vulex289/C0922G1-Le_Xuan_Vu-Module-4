package com.example.furama_resort.controller;

import com.example.furama_resort.model.contract.Contract;
import com.example.furama_resort.model.contract.ContractDetail;
import com.example.furama_resort.service.contract.IAttachFacilityService;
import com.example.furama_resort.service.contract.IContractDetailService;
import com.example.furama_resort.service.contract.IContractService;
import com.example.furama_resort.service.customer.ICustomerService;
import com.example.furama_resort.service.employee.IEmployeeService;
import com.example.furama_resort.service.facility.IFacilityService;
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

    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IFacilityService facilityService;
    @Autowired
    private IEmployeeService employeeService;


    @GetMapping("/furama/contract")
    public String showList(Model model){
        model.addAttribute("contracts",contractService.getAllContracts());
        model.addAttribute("attachFacilities",attachFacilityService.findAll());
        model.addAttribute("contractDetail",new ContractDetail());
        model.addAttribute("customers",customerService.findAll());
        model.addAttribute("facilities",facilityService.findAll());
        model.addAttribute("contract",new Contract());
        model.addAttribute("employees",employeeService.findAll());
        return "contract/list";
    }
    @PostMapping("/createContractDetail")
        public String saveContractDetail(@ModelAttribute ContractDetail contractDetail){
        contractDetailService.save(contractDetail);
        return "redirect:/furama/contract";
    }
    @PostMapping("/contract/create")
    public String saveContract(@ModelAttribute Contract contract){
        contractService.save(contract);
        return "redirect:/furama/contract";
    }
}
