package com.example.furama_resort.controller;

import com.example.furama_resort.model.employee.Employee;
import com.example.furama_resort.service.employee.IDivisionService;
import com.example.furama_resort.service.employee.IEducationDegreeService;
import com.example.furama_resort.service.employee.IEmployeeService;
import com.example.furama_resort.service.employee.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;
    @Autowired
    private IDivisionService divisionService;
    @Autowired
    private IEducationDegreeService educationDegreeService;
    @Autowired
    private IPositionService positionService;

    @GetMapping("/furama/employee")
    public String showList(Model model, @RequestParam(defaultValue = "", required = false) String nameSearch, @PageableDefault(page = 0, size = 4, sort = "name", direction = Sort.Direction.ASC) Pageable pageable) {
        model.addAttribute("employees", employeeService.findAll(nameSearch, pageable));
        model.addAttribute("nameSearch", nameSearch);
        model.addAttribute("divisions", divisionService.findAll());
        model.addAttribute("positions", positionService.findAll());
        model.addAttribute("educationDegrees", educationDegreeService.findAll());
        model.addAttribute("employee", new Employee());
        model.addAttribute("employee1", new Employee());
        return "employee/list";
    }

    @PostMapping("/employee/delete")
    public String deleteEmployee(@RequestParam long idDelete, RedirectAttributes attributes) {
        employeeService.deleteById(idDelete);
        attributes.addFlashAttribute("msg", "Xóa thành Công");
        return "redirect:/furama/employee";
    }

    @PostMapping("/employee/create")
    public String showFormCreate(@ModelAttribute Employee employee, RedirectAttributes attributes) {
        employeeService.save(employee);
        attributes.addFlashAttribute("msg", "Thêm mới thành công");
        return "redirect:/furama/employee";
    }
    @PostMapping("/employee/edit")
    public String showFormEdit(@ModelAttribute Employee employee, RedirectAttributes attributes) {
        employeeService.save(employee);
        attributes.addFlashAttribute("msg", "Sửa mới thành công");
        return "redirect:/furama/employee";
    }
}
