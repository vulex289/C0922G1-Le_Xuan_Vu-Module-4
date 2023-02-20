package com.example.furama_resort.controller;

import com.example.furama_resort.model.customer.Customer;
import com.example.furama_resort.service.customer.ICustomerService;
import com.example.furama_resort.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String showList(Model model, @RequestParam(defaultValue = "", required = false) String nameSearch, @RequestParam(defaultValue = "", required = false) String email, @RequestParam(defaultValue = "", required = false) String customerTypeId, @PageableDefault(page = 0, size = 4, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        for (Customer customer : customerService.findAll()) {
            if (customer.getDateOfBirth().contains("-")) {
                String[] arr = customer.getDateOfBirth().split("-");
                customer.setDateOfBirth(arr[2] + "-" + arr[1] + "-" + arr[0]);
            }
        }
        model.addAttribute("customers", customerService.findAll(nameSearch, email, customerTypeId, pageable));
        model.addAttribute("nameSearch", nameSearch);
        model.addAttribute("email", email);
        model.addAttribute("customerTypeId", customerTypeId);
        model.addAttribute("customerTypeList", customerTypeService.findAll());
        return "customer/list";
    }

    @GetMapping("/furama/customer1")
    public String showList2(Model model) {
        model.addAttribute("customers", customerService.findAll());
        model.addAttribute("customerTypeList",customerTypeService.findAll());
        return "customer/list1";
    }

    @GetMapping("customer/create")
    public String showFormCreate(Model model) {
        model.addAttribute("customer", new Customer());
        LocalDate minAge = LocalDate.now().minusYears(70);
        LocalDate maxAge = LocalDate.now().minusYears(18);
        model.addAttribute("customerTypeList", customerTypeService.findAll());
        model.addAttribute("minAge", minAge);
        model.addAttribute("maxAge", maxAge);
        return "customer/create";
    }

    @PostMapping("customer/create")
    public String save(Model model, @ModelAttribute Customer customer) {
        customerService.save(customer);
        model.addAttribute("msg", "Thêm mới thành công");
        return "customer/create";
    }

    @GetMapping("customer/edit/{id}")
    public String showFormEdit(Model model, @PathVariable long id) {
        Customer customer = customerService.findById(id);
        if (customer == null) {
            return "error";
        } else {
            model.addAttribute("customer", customer);
            model.addAttribute("customerTypeList", customerTypeService.findAll());
            return "customer/edit";
        }
    }

    @PostMapping("customer/edit")
    public String edit(@ModelAttribute Customer customer, RedirectAttributes attributes) {
        customerService.edit(customer);
        attributes.addFlashAttribute("msg", "Sửa thành công");
        return "redirect:/furama/customer1";
    }

    @PostMapping ("customer/delete")
    public String deleteLogic(@RequestParam long idDelete,RedirectAttributes attributes) {
        customerService.deleteLogic(idDelete);
        attributes.addFlashAttribute("msg","Xóa thành công");
        return "redirect:/furama/customer";
    }
    @PostMapping ("customer/delete1")
    public String remove(@RequestParam long idDelete,RedirectAttributes attributes) {
        customerService.delete(customerService.findById(idDelete));
        attributes.addFlashAttribute("msg","Xóa thành công");
        return "redirect:/furama/customer1";
    }
}

