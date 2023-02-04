package com.example.controller;

import com.example.model.Product;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("/product")
    public String showList(Model model) {
        model.addAttribute("products", productService.findAll());
        return "list";
    }
    @GetMapping("/product/create")
    public String showFormCreate(Model model){
        model .addAttribute("product",new Product());
        return "create";
    }
    @PostMapping("/product/save")
    public String save(@ModelAttribute Product product){
        productService.save(product);
        return "create";
    }
    @GetMapping("/product/delete/{id}")
    public String delete(@PathVariable int id, RedirectAttributes attributes){
        productService.remove(id);
        attributes.addFlashAttribute("msg","Xóa Thành Công");
        return "redirect:/product";
    }
    @GetMapping("/product/detail/{id}")
    public String showDetail(@PathVariable int id, Model model){
        model.addAttribute("product",productService.findById(id));
        return "detail";
    }
    @GetMapping("search")
    public String search(@RequestParam String name,Model model){
        model.addAttribute("products",productService.findProduct(name));
        return "list";
    }
}
