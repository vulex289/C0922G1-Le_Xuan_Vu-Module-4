package com.example.furama_resort.controller;

import com.example.furama_resort.dto.CustomerDto;
import com.example.furama_resort.model.customer.Customer;
import com.example.furama_resort.service.customer.ICustomerService;
import com.example.furama_resort.service.customer.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;

@Controller
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private ICustomerTypeService customerTypeService;

    @GetMapping("/furama/customer")
    public String showList(Model model, @RequestParam(defaultValue = "", required = false) String nameSearch,
                           @RequestParam(defaultValue = "", required = false) String email,
                           @RequestParam(defaultValue = "-1", required = false) long customerTypeId,
                           @PageableDefault(page = 0, size = 4, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        for (Customer customer : customerService.findAll()) {
            if (customer.getDateOfBirth().contains("-")) {
                String[] arr = customer.getDateOfBirth().split("-");
                customer.setDateOfBirth(arr[2] + "-" + arr[1] + "-" + arr[0]);
            }
        }
        Page<Customer> customers;
        if (customerTypeId == -1) {
            customers = customerService.findAllAndSearchNotCustomerType(nameSearch, email, pageable);
        } else {
            customers = customerService.findAll(nameSearch, email, customerTypeId, pageable);
        }
        model.addAttribute("customers", customers);
        model.addAttribute("nameSearch", nameSearch);
        model.addAttribute("email", email);
        model.addAttribute("customerTypeId", customerTypeId);
        model.addAttribute("customerTypeList", customerTypeService.findAll());
        return "customer/list";
    }

    @GetMapping("/furama/customer1")
    public String showList2(Model model) {
        model.addAttribute("customers", customerService.findAll());
        model.addAttribute("customerTypeList", customerTypeService.findAll());
        return "customer/list1";
    }

    @GetMapping("/customer/create")
    public String showFormCreate(Model model) {
        model.addAttribute("customerDto", new CustomerDto());
        LocalDate minAge = LocalDate.now().minusYears(70);
        LocalDate maxAge = LocalDate.now().minusYears(18);
        model.addAttribute("minAge", minAge);
        model.addAttribute("maxAge", maxAge);
        model.addAttribute("customerTypeList", customerTypeService.findAll());
        return "customer/create";
    }

    @PostMapping("/customer/create")
    public String save(@Validated @ModelAttribute CustomerDto customerDto, BindingResult bindingResult, Model model) {
        new CustomerDto().validate(customerDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("customerDto", customerDto);
            model.addAttribute("customerTypeList", customerTypeService.findAll());
            return "customer/create";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        boolean check = customerService.save(customer);
        if (!check) {
            model.addAttribute("msg", "Thêm mới thành công");
            return "/customer/create";
        } else {
            model.addAttribute("msg", "Không Thành Công");
            return "redirect:/customer/create";
        }
    }

    @GetMapping("customer/edit/{id}")
    public String showFormEdit(Model model, @PathVariable long id) {
        Customer customer = customerService.findById(id);
        if (customer == null) {
            return "error";
        } else {
            CustomerDto customerDto = new CustomerDto();
            BeanUtils.copyProperties(customer, customerDto);
            model.addAttribute("customerDto", customerDto);
            model.addAttribute("customerTypeList", customerTypeService.findAll());
            return "customer/edit";
        }
    }

    @PostMapping("/customer/edit")
    public String edit(@Validated @ModelAttribute CustomerDto customerDto, BindingResult bindingResult, Model model, RedirectAttributes attributes) {
        new CustomerDto().validate(customerDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("customerDto", customerDto);
            model.addAttribute("customerTypeList", customerTypeService.findAll());
            return "customer/edit";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        boolean check = customerService.edit(customer);
        if (check) {
            attributes.addFlashAttribute("msg", "Sửa thành công");
            return "redirect:/furama/customer";
        } else {
            attributes.addFlashAttribute("msg", "Không Sửa thành công");
            return "redirect:/furama/customer";
        }
    }

    @PostMapping("/customer/delete")
    public String deleteLogic(@RequestParam long idDelete, RedirectAttributes attributes) {
        customerService.deleteLogic(idDelete);
        attributes.addFlashAttribute("msg", "Xóa thành công");
        return "redirect:/furama/customer";
    }

    @PostMapping("/customer/delete1")
    public String remove(@RequestParam long idDelete, RedirectAttributes attributes) {
        customerService.delete(customerService.findById(idDelete));
        attributes.addFlashAttribute("msg", "Xóa thành công");
        return "redirect:/furama/customer1";
    }
}

