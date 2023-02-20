package com.example.furama_resort.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/furama")
    public String showHome(){
        return "home";
    }
}
