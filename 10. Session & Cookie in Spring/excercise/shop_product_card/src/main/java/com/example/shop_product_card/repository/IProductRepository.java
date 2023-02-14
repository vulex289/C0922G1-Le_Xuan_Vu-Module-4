package com.example.shop_product_card.repository;

import com.example.shop_product_card.dto.ProductDto;
import com.example.shop_product_card.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product,Long> {
}
