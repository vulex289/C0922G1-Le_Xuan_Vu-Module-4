package com.example.service;

import com.example.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    void save(Product product);
    void edit(Product product);
    void remove(int id);
    Product findById(int id);
    List<Product>findProduct(String name);
}
