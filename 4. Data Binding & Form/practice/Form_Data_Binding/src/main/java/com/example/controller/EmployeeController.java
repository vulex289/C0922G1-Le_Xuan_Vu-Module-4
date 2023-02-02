package com.example.controller;

import com.example.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmployeeController {

    @RequestMapping(value = "/showForm", method = RequestMethod.GET)
    public String showForm(ModelMap model) {
        model.addAttribute("employee", new Employee());
        return "/create";
    }
    @RequestMapping(value = "/addEmployee",method = RequestMethod.POST)
    public String submit(@ModelAttribute("employee") Employee employee,Model model){
        model.addAttribute("name",employee.getName());
        model.addAttribute("contactNumber",employee.getContactNumber());
        model.addAttribute("id",employee.getId());
        return "/info";
    }
}