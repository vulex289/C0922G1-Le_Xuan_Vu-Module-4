package com.example.booklibrary.service;

import com.example.booklibrary.model.Book;

import java.util.List;

public interface IBookService {
    Book findByCode(String code);

    List<Book> findAll();

    void save(Book book);

    Book findById(int id);

}
