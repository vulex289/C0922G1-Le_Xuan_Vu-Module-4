package com.example.blog_ajax.controller;


import com.example.blog_ajax.model.Category;
import com.example.blog_ajax.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;
    @GetMapping("/category")
    public String showList(Model model) {
        model.addAttribute("categoryList", categoryService.findAll());
        return "category-list";
    }
    @GetMapping("category/create")
    public String showFormCreateCategory(Model model) {
        model.addAttribute("category", new Category());
        return "/category-create";
    }

    @PostMapping("/category/save")
    public String saveCategory(RedirectAttributes attributes, @ModelAttribute Category category) {
        categoryService.save(category);
        attributes.addFlashAttribute("msg", "Tạo thành công");
        return "redirect:/category";
    }
    @GetMapping("/category/edit/{id}")
    public String showFormEditCategory(Model model, @PathVariable int id, RedirectAttributes redirectAttributes) {
        if (categoryService.findById(id)==null) {
            redirectAttributes.addFlashAttribute("msg", "Không tìm thấy id");
            return "redirect:/category";
        } else {
            model.addAttribute("category", categoryService.findById(id));
            return "/category-edit";
        }
    }

    @PostMapping("/category/edit")
    public String edit(@ModelAttribute Category category, RedirectAttributes attributes) {
        categoryService.save(category);
        attributes.addFlashAttribute("msg", "Sửa thành công");
        return "redirect:/category";
    }
    @GetMapping("/category/delete/{id}")
    public String delete(@PathVariable int id, RedirectAttributes attributes) {
        int count =0;
        for (Category category: categoryService.findAll()) {
            if (category.getId()==id){
                count++;
            }
        }
        if (count!=categoryService.findAll().size()){
            categoryService.deleteCategory(id);
            attributes.addFlashAttribute("msg", "Xóa thành công");
            return "redirect:/category";
        }
        else{
            attributes.addFlashAttribute("msg", "Không tìm thấy id");
            return "redirect:/category";
        }

    }
}
