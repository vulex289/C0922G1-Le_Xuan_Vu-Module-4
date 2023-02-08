package com.example.blog_management.service;

import com.example.blog_management.model.Blog;
import com.example.blog_management.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
    Category findById(int id);
    void editCategory(Category category);
    void deleteCategory(int id);
    void save(Category category);
}
