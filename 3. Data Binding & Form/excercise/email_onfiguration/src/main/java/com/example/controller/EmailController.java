package com.example.controller;

import com.example.model.Email;
import com.example.service.EmailService;
import com.example.service.IEmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class EmailController {
   private final IEmailService emailService = new EmailService();
    @GetMapping("/email")
    public String get(Model model){
        model.addAttribute("emailList",emailService.findAll());
        return "email/list";
    }
    @GetMapping("/edit")
    public String showEdit(Model model, @RequestParam int id){
        String msg="";
        Email email =emailService.findById(id);
        if (email==null){
            msg="Không tìm thấy email";
            model.addAttribute("msg",msg);
            model.addAttribute("emailList",emailService.findAll());
            return "email/list";
        }
        model.addAttribute("email",email);
        model.addAttribute("languages",emailService.showLanguages());
        model.addAttribute("pageSize",emailService.showPageSize());
        return "email/setting";
    }
    @PostMapping("/setting")
    public String edit( @ModelAttribute Email email, RedirectAttributes attributes){
        emailService.edit(email);
        attributes.addFlashAttribute("msg","Thêm mới thành công");
        return "redirect:/email";
    }

}
