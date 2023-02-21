package com.example.furama_resort.controller;

import com.example.furama_resort.model.facility.Facility;
import com.example.furama_resort.service.facility.IFacilityService;
import com.example.furama_resort.service.facility.IFacilityTypeService;
import com.example.furama_resort.service.facility.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class FacilityController {
    @Autowired
    private IFacilityTypeService facilityTypeService;
    @Autowired
    private IFacilityService facilityService;
    @Autowired
    private IRentTypeService rentTypeService;

    @GetMapping("/furama/facility")
    public String showList(Model model, @RequestParam(defaultValue = "", required = false) String nameSearch, @RequestParam(defaultValue = "", required = false) String facilityTypeId, @PageableDefault(size = 4, page = 0) Pageable pageable) {
        model.addAttribute("facilitys", facilityService.findAll(nameSearch, facilityTypeId, pageable));
        model.addAttribute("facilityTypes", facilityTypeService.findAll());
        model.addAttribute("rentTypes", rentTypeService.findAll());
        model.addAttribute("nameSearch", nameSearch);
        model.addAttribute("facilityTypeId", facilityTypeId);
        model.addAttribute("facility", new Facility());
        return "facility/list";
    }

    @PostMapping("/facility/delete")
    public String deleteFacility(@RequestParam long idDelete, RedirectAttributes attributes) {
        facilityService.deleteLogic(idDelete);
        attributes.addFlashAttribute("msg", "Xóa Thành công");
        return "redirect:/furama/facility";
    }

    @PostMapping("/facility/create")
    public String createFacility(@ModelAttribute Facility facility, RedirectAttributes attributes) {
        facilityService.save(facility);
        attributes.addFlashAttribute("msg", "Thêm mới Thành công");
        return "redirect:/furama/facility";
    }

    @PostMapping("/facility/edit")
    public String editFacility(@ModelAttribute Facility facility, RedirectAttributes redirectAttributes) {
        facilityService.edit(facility);
        redirectAttributes.addFlashAttribute("msg", "Sửa thành công");
        return "redirect:/furama/facility";
    }
}