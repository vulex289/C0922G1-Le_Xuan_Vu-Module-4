package com.codegym.controller;

import com.codegym.service.DictionaryService;
import com.codegym.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
@Autowired
    IDictionaryService dictionaryService ;
    @GetMapping("/dictionary")
    public String showList(){
        return "dictionary";
    }
    @PostMapping("/dictionary")
    public String showList(@RequestParam String name, Model model){
model.addAttribute("vie",dictionaryService.search(name));
        return "dictionary";
    }
}
