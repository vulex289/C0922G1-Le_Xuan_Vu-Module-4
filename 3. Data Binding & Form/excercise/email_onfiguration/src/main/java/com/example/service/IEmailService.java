package com.example.service;

import com.example.model.Email;

import java.util.List;

public interface IEmailService {
    List<String> showLanguages();
    List<Integer>showPageSize();
    Email findById(int id);
    List<Email>findAll();
    void edit(Email email);
}
