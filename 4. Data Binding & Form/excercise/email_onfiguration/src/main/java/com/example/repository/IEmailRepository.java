package com.example.repository;

import com.example.model.Email;

import java.util.List;

public interface IEmailRepository {
    List<String>showLanguages();
    List<Integer>showPageSize();
    Email findById(int id);
    List<Email>findAll();
    void edit(Email email);
}
