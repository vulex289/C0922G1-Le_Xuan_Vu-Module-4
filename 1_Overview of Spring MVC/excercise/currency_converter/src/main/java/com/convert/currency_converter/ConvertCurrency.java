package com.convert.currency_converter;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvertCurrency{
    @GetMapping("/convert")
    public String showList(){
        return "convert";
    }
    @PostMapping("/convert")
    public String showList(@RequestParam double usd, Model model){
        double vnd = usd*23000;
        model.addAttribute("vnd",vnd);
        return "convert";
    }
}
