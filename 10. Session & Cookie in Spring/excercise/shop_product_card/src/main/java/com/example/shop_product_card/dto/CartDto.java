package com.example.shop_product_card.dto;

import java.util.HashMap;
import java.util.Map;

public class CartDto {
    private Map<ProductDto, Integer> products = new HashMap<>();

    public Map<ProductDto, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<ProductDto, Integer> products) {
        this.products = products;
    }

    public CartDto() {
    }

    public CartDto(Map<ProductDto, Integer> products) {
        this.products = products;
    }

    //    public boolean checkItemsInCart(ProductDto productDto) {
//        for (Map.Entry<ProductDto, Integer> entry : products.entrySet()) {
//        if (entry.getKey().getId()==(productDto.getId())){
//            return true;
//        }
//        }
//        return false;
//    }
    public void addProduct(ProductDto productDto) {
        if (products.containsKey(productDto)) {
            Integer currentValue = products.get(productDto);
            products.replace(productDto, currentValue + 1);
        } else {
            products.put(productDto, 1);
        }
    }

    public void decrease(ProductDto productDto) {
        if (products.containsKey(productDto)) {
            Integer currentValue = products.get(productDto);
            products.replace(productDto, currentValue - 1);
        }
        if (products.get(productDto) <= 0) {
            products.remove(productDto);
        }
    }

    public void remove(ProductDto productDto) {
        products.remove(productDto);
    }

    public double payTotal() {
        double sum = 0;
        for (Map.Entry<ProductDto, Integer> entry : products.entrySet()) {
            sum += entry.getValue() * entry.getKey().getPrice();
        }
        return sum;
    }
}


