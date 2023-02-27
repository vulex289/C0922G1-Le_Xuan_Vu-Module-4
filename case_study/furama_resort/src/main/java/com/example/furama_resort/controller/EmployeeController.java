package com.example.furama_resort.controller;
import com.example.furama_resort.dto.EmployeeDto;
import com.example.furama_resort.model.employee.Employee;
import com.example.furama_resort.service.employee.IDivisionService;
import com.example.furama_resort.service.employee.IEducationDegreeService;
import com.example.furama_resort.service.employee.IEmployeeService;
import com.example.furama_resort.service.employee.IPositionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
    public String showList(ModelMap model, @RequestParam(defaultValue = "", required = false) String nameSearch,
                           @PageableDefault(page = 0, size = 4, sort = "name", direction = Sort.Direction.ASC) Pageable pageable) {
        model.addAttribute("employees", employeeService.findAll(nameSearch, pageable));
        model.addAttribute("nameSearch", nameSearch);
        model.addAttribute("divisions", divisionService.findAll());
        model.addAttribute("positions", positionService.findAll());
        model.addAttribute("educationDegrees", educationDegreeService.findAll());
        if (model.getAttribute("employeeDtoEdit") != null) {
            model.addAttribute("employeeDtoEdit", model.getAttribute("employeeDtoEdit"));
            model.addAttribute("flagEdit", "true");
        } else {
            model.addAttribute("employeeDtoEdit", new EmployeeDto());
            model.addAttribute("flagEdit", "false");
        }

        if (model.getAttribute("employeeDto") != null) {
            model.addAttribute("employeeDto", model.getAttribute("employeeDto"));
            model.addAttribute("flagCreate", "true");
        } else {
            model.addAttribute("employeeDto", new EmployeeDto());
            model.addAttribute("flagCreate", "false");
        }
        return "employee/list";
    }

    @PostMapping("/employee/delete")
    public String deleteEmployee(@RequestParam long idDelete, RedirectAttributes attributes) {
        employeeService.deleteById(idDelete);
        attributes.addFlashAttribute("msg", "Xóa thành Công");
        return "redirect:/furama/employee";
    }

    @PostMapping("/employee/create")
    public String showFormCreate(@Validated @ModelAttribute EmployeeDto employeeDto, BindingResult bindingResult,
                                 RedirectAttributes attributes) {
        if (bindingResult.hasErrors()) {
            attributes.addFlashAttribute("employeeDto", employeeDto);
            attributes.addFlashAttribute("org.springframework.validation.BindingResult.employeeDto", bindingResult);
            return "redirect:/furama/employee";
        }
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);
        employeeService.save(employee);
        attributes.addFlashAttribute("flagSuccess", "true");
        return "redirect:/furama/employee";
    }

    @PostMapping("/employee/edit")
    public String showFormEdit(@Validated @ModelAttribute EmployeeDto employeeDtoEdit, BindingResult bindingResult, RedirectAttributes attributes) {
        if (bindingResult.hasErrors()) {
            attributes.addFlashAttribute("employeeDtoEdit", employeeDtoEdit);
            attributes.addFlashAttribute("org.springframework.validation.BindingResult.employeeDtoEdit", bindingResult);
            return "redirect:/furama/employee";
        }
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDtoEdit, employee);
            employeeService.save(employee);
            return "redirect:/furama/employee";
    }
}
