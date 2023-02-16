package com.example.blog_ajax.service;

import com.example.blog_ajax.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();

    Category findById(int id);

    void editCategory(Category category);

    void deleteCategory(int id);

    void save(Category category);
}
