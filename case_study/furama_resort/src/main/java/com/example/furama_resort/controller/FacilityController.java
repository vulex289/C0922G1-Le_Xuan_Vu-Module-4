package com.example.furama_resort.controller;
import com.example.furama_resort.dto.FacilityDto;
import com.example.furama_resort.model.facility.Facility;
import com.example.furama_resort.service.facility.IFacilityService;
import com.example.furama_resort.service.facility.IFacilityTypeService;
import com.example.furama_resort.service.facility.IRentTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
    public String showList(Model model, @RequestParam(defaultValue = "", required = false) String nameSearch,
                           @RequestParam(defaultValue = "-1", required = false) long facilityTypeId,
                           @PageableDefault(size = 4, page = 0) Pageable pageable) {
        Page<Facility> facilities;
        if (facilityTypeId == -1) {
            facilities = facilityService.getAllByNameSearch(nameSearch, pageable);
        } else {
            facilities = facilityService.getAllByNameSearchAndFacilityType(nameSearch, facilityTypeId, pageable);
        }
        model.addAttribute("facilities", facilities);
        model.addAttribute("facilityTypes", facilityTypeService.findAll());
        model.addAttribute("rentTypes", rentTypeService.findAll());
        model.addAttribute("nameSearch", nameSearch);
        model.addAttribute("facilityTypeId", facilityTypeId);
        if (model.getAttribute("facilityCreateDto") != null) {
            model.addAttribute("facilityCreateDto", model.getAttribute("facilityCreateDto"));
            model.addAttribute("flagCreate", "true");
        } else {
            model.addAttribute("facilityCreateDto", new FacilityDto());
            model.addAttribute("flagCreate", "false");
        }
        if (model.getAttribute("facilityEditDto") != null) {
            model.addAttribute("facilityEditDto", model.getAttribute("facilityEditDto"));
            model.addAttribute("flagEdit", "true");
        } else {
            model.addAttribute("facilityEditDto", new FacilityDto());
            model.addAttribute("flagEdit", "false");
        }
        return "facility/list";
    }

    @PostMapping("/facility/delete")
    public String deleteFacility(@RequestParam long idDelete, RedirectAttributes attributes) {
        facilityService.deleteLogic(idDelete);
        attributes.addFlashAttribute("msg", "Xóa Thành công");
        return "redirect:/furama/facility";
    }

    @PostMapping("/facility/create")
    public String createFacility(@Validated @ModelAttribute FacilityDto facilityCreateDto, BindingResult bindingResult, RedirectAttributes attributes) {
        new FacilityDto().validate(facilityCreateDto, bindingResult);
        if (bindingResult.hasErrors()) {
            attributes.addFlashAttribute("facilityCreateDto", facilityCreateDto);
            attributes.addFlashAttribute("org.springframework.validation.BindingResult.facilityCreateDto", bindingResult);
            return "redirect:/furama/facility";
        }
        Facility facility = new Facility();
        BeanUtils.copyProperties(facilityCreateDto, facility);
        boolean check = facilityService.save(facility);
        if (check) {
            attributes.addFlashAttribute("msg", "Thêm mới Thành công");
            return "redirect:/furama/facility";
        } else {
            attributes.addFlashAttribute("msg", "Thêm mới Không Thành công");
            return "redirect:/furama/facility";
        }
    }

    @PostMapping("/facility/edit")
    public String editFacility(@Validated @ModelAttribute FacilityDto facilityEditDto,BindingResult bindingResult, RedirectAttributes attributes) {
        if (bindingResult.hasErrors()){
            attributes.addFlashAttribute("facilityEditDto",facilityEditDto);
            attributes.addFlashAttribute("org.springframework.validation.BindingResult.facilityEditDto",bindingResult);
            return "redirect:/furama/facility";
        }
        Facility facility = new Facility();
        BeanUtils.copyProperties(facilityEditDto,facility);
        boolean check = facilityService.edit(facility);
        if (!check) {
            attributes.addFlashAttribute("msg", "Không Sửa thành công");
            return "redirect:/furama/facility";
        } else {
            attributes.addFlashAttribute("msg", "Sửa thành công");
            return "redirect:/furama/facility";
        }
    }
}
