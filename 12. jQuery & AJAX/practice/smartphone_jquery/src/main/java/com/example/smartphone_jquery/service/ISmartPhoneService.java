package com.example.smartphone_jquery.service;

import com.example.smartphone_jquery.model.Smartphone;

import java.util.List;

public interface ISmartPhoneService {
    List<Smartphone> findAll();
    Smartphone findById(Long id);
    void save(Smartphone smartPhone);
    void remove(long id);
}
