package com.example.cinema.controller;

import com.example.cinema.model.Cinema;
import com.example.cinema.service.ICinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class RestfulCinemaController {
    @Autowired
    private ICinemaService cinemaService;
    @GetMapping("/cinema/{code}")
    public ResponseEntity<Cinema> findByCinema(@PathVariable String code){
       Cinema  cinemaDetail= cinemaService.findById(code);
        if (cinemaDetail==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(cinemaDetail,HttpStatus.OK);
        }
    }
}
