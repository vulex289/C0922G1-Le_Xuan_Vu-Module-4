package com.example.blog_ajax.controller;

import com.example.blog_ajax.model.Category;

import com.example.blog_ajax.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryRestfulController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/category")
    public ResponseEntity<List<Category>> getAll() {
        List<Category> categoryList = categoryService.findAll();
        if (categoryList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(categoryList, HttpStatus.OK);
        }
    }
}
