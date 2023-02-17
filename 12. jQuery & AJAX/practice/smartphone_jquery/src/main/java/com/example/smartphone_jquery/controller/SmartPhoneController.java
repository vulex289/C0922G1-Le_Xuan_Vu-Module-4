package com.example.smartphone_jquery.controller;

import com.example.smartphone_jquery.model.Smartphone;
import com.example.smartphone_jquery.service.ISmartPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/smartphone")
public class SmartPhoneController  {
    @Autowired
   private ISmartPhoneService smartPhoneService;
    @GetMapping("")
    public ResponseEntity<List<Smartphone>> showList(){
        List<Smartphone> phones=smartPhoneService.findAll();
        if (phones==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(phones,HttpStatus.OK);
        }
    }
//@GetMapping("")
//public ModelAndView getAllSmartphonePage() {
//    ModelAndView modelAndView = new ModelAndView("list");
//    modelAndView.addObject("smartphones", smartPhoneService.findAll());
//    return modelAndView;
//}
    @PostMapping("/create")
    public ResponseEntity<Smartphone> createSmartphone(@RequestBody Smartphone smartphone) {
        smartPhoneService.save(smartphone);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
