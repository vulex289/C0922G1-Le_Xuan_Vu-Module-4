package com.example.shop_product_card.service;

import com.example.shop_product_card.model.Product;

import java.util.List;

public interface IProductService {
    List<Product>findAll();
    Product findById(long id);

}
