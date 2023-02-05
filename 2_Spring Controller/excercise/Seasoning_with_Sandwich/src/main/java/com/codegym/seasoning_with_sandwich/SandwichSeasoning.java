package com.codegym.seasoning_with_sandwich;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichSeasoning {
    @GetMapping("")
    public String showList(){
        return "index";
    }
    @PostMapping("/save")
    public String save(@RequestParam String[] condiment,  Model model){
        String msg="";
        if (condiment.length==0){
            msg="Bạn chưa chọn";
            model.addAttribute("msg",msg);
        }
        else {
            model.addAttribute("condiment", condiment);
        }
    return "index";
    }
}
