package com.example.blog_ajax.controller;


import com.example.blog_ajax.model.Blog;
import com.example.blog_ajax.service.IBlogService;
import com.example.blog_ajax.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
   private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/blog")
    public String showList(Model model, @RequestParam(required = false,defaultValue = "") String nameSearch, @PageableDefault(size = 2,page = 0,sort = "date",direction = Sort.Direction.ASC) Pageable pageable) {
        Page<Blog> blogList=blogService.findByNameContaining(nameSearch,pageable);
        model.addAttribute("blogList",blogList);
        model.addAttribute("nameSearch",nameSearch);
        if(blogService.findAll().isEmpty()){
            model.addAttribute("mess","Danh sách trống");
        }
        return "/list";
    }

    @GetMapping("blog/create")
    public String showFormCreate(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("categoryList",categoryService.findAll());
        return "/create";
    }

    @PostMapping("/blog/save")
    public String save(RedirectAttributes attributes, @ModelAttribute Blog blog) {
        blogService.save(blog);
        attributes.addFlashAttribute("msg", "Tạo thành công");
        return "redirect:/blog";
    }

    @GetMapping("/blog/edit/{id}")
    public String showFormEdit(Model model, @PathVariable int id,RedirectAttributes redirectAttributes) {
        if (blogService.findById(id)==null) {
            redirectAttributes.addFlashAttribute("msg", "Không tìm thấy id");
            return "redirect:/blog";
        } else {
            model.addAttribute("blog", blogService.findById(id));
            model.addAttribute("categoryList", categoryService.findAll());
            return "/edit";
        }
    }

    @PostMapping("/blog/edit")
    public String edit(@ModelAttribute Blog blog, RedirectAttributes attributes) {
        blogService.save(blog);
        attributes.addFlashAttribute("msg", "Sửa thành công");
        return "redirect:/blog";
    }
    @GetMapping("/blog/delete/{id}")
    public String delete(@PathVariable int id, RedirectAttributes attributes) {
        int count =0;
        for (Blog blog: blogService.findAll()) {
            if (blog.getId()==id){
                count++;
            }
        }
        if (count!=blogService.findAll().size()){
            blogService.deleteBlog(id);
            attributes.addFlashAttribute("msg", "Xóa thành công");
            return "redirect:/blog";
        }
       else{
            attributes.addFlashAttribute("msg", "Không tìm thấy id");
            return "redirect:/blog";
        }
    }
    @GetMapping("blog/detail/{id}")
    public String showDetail(@PathVariable int id, Model model){
        model.addAttribute("blog",blogService.findById(id));
        model.addAttribute("categoryList",categoryService.findAll());
        return "/detail";
    }
//    @GetMapping("find-category")
//    public String showListBlogByCategory(@RequestParam(value = "id") int id,Model model, @PageableDefault(size = 2,page = 0,sort = "date",direction = Sort.Direction.ASC) Pageable pageable){
//        model.addAttribute("blogList",blogService.findByCategory(id,pageable));
//        return "list";
//    }
}
