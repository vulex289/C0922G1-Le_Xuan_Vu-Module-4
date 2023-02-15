package com.example.blog_management_restful.controller;

import com.example.blog_management_restful.model.Blog;
import com.example.blog_management_restful.repository.IBlogRepository;
import com.example.blog_management_restful.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class BlogRestfulController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("/blog")
    public ResponseEntity<List<Blog>> getAll() {
        List<Blog> blogs = blogService.findAll();
        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(blogs, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getDetailBlog(@PathVariable int id) {
        Blog blog1 = blogService.findById(id);
        if (blog1 == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(blog1, HttpStatus.OK);
        }
    }

    @GetMapping("/find-category/{id}")
    public ResponseEntity<Page<Blog>> getBlogByCategory(@PathVariable int id, Pageable pageable) {
        Page<Blog> blogs = blogService.findByCategory(id,pageable);
        if (blogs == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(blogs, HttpStatus.OK);
        }
    }
    @GetMapping("/blog")
    public String showList1(Model model, @RequestParam(required = false,defaultValue = "") String nameSearch, @PageableDefault(size = 2,page = 0,sort = "date",direction = Sort.Direction.ASC) Pageable pageable) {
        Page<Blog> blogList=blogService.findByNameContaining(nameSearch,pageable);
        model.addAttribute("blogList",blogList);
        model.addAttribute("nameSearch",nameSearch);
        if(blogService.findAll().isEmpty()){
            model.addAttribute("mess","Danh sách trống");
        }
        return "/list";
    }
}
