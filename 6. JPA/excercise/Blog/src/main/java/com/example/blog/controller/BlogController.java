package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BlogController {
    @Autowired
   private IBlogService blogService;

    @GetMapping("/blog")
    public String showList(Model model) {
        model.addAttribute("blogList", blogService.findAll());
//        if(blogService.findAll().isEmpty()){
//            model.addAttribute("mess","Danh sách trống");
//        }
        return "/list";
    }

    @GetMapping("blog/create")
    public String showFormCreate(Model model) {
        model.addAttribute("blog", new Blog());
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
        if (count==blogService.findAll().size()){
            blogService.deleteBlog(id);
            attributes.addFlashAttribute("msg", "Sửa thành công");
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
        return "/detail";
    }
}
