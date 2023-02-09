package com.example.validate_registration_form.controller;

import com.example.validate_registration_form.dto.UserDto;
import com.example.validate_registration_form.model.User;
import com.example.validate_registration_form.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {
    @Autowired
    IUserService userService;

    @GetMapping("/user")
    public String showList(Model model) {
        model.addAttribute("userList", userService.findAll());
        return "/list";
    }

    @GetMapping("/user/create")
    public String showFormCreate(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "/create";
    }

    @PostMapping("/user/save")
    public String save(@Validated @ModelAttribute UserDto userDto, BindingResult bindingResult, RedirectAttributes attributes,Model model) {
        User user = new User();
        if (bindingResult.hasErrors()){
            model.addAttribute("userDto",userDto);
            return "create";
        }else {
            BeanUtils.copyProperties(userDto, user);
            attributes.addFlashAttribute("msg", "Tạo mới thành công");
            userService.save(user);
            return "redirect:/user";
        }
    }
}
