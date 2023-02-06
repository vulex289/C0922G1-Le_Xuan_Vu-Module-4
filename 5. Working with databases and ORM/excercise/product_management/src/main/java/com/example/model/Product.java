package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private double price;
    private String describe1;
    private String producer;

    public Product() {
    }

    public Product(int id, String name, double price, String describe1, String producer) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.describe1 = describe1;
        this.producer = producer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescribe1() {
        return describe1;
    }

    public void setDescribe1(String describe1) {
        this.describe1 = describe1;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}
