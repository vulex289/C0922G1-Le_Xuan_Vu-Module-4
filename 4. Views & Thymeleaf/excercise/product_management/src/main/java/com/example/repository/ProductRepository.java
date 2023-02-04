package com.example.repository;

import com.example.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class ProductRepository implements IProductRepository {
    private final static List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(1, "iphone5", 200, "VNA", "Apple"));
        products.add(new Product(2, "iphone6", 250, "VNA", "Apple"));
        products.add(new Product(3, "iphone8", 300, "VNA", "Apple"));
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void save(Product product) {
        products.add(product);
    }

    @Override
    public void edit(Product product) {
        for (Product product1 : products) {
            if (product1.getId() == product.getId()) {
                product1.setName(product.getName());
                product1.setPrice(product.getPrice());
                product1.setDescribe(product.getDescribe());
                product1.setProducer(product.getProducer());
                break;
            }
        }
    }

    @Override
    public void remove(int id) {
        Product product2 = null;
        for (Product product1 : products) {
            if (product1.getId() == id) {
                product2 = product1;
                break;
            }
        }
            products.remove(product2);
    }

    @Override
    public Product findById(int id) {
        Product product2 = null;
        for (Product product1 : products) {
            if (product1.getId() == id) {
                product2 = product1;
            }
        }
        return product2;
    }

    @Override
    public List<Product> findProduct(String name) {
        List<Product>productSearch = new ArrayList<>();
        for (Product product1 : products) {
            if (product1.getName().contains(name)) {
                productSearch.add(product1);
            }
        }
        return productSearch;
    }
}
