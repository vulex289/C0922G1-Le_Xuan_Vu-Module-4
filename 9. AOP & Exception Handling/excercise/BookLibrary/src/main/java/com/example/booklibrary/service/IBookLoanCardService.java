package com.example.booklibrary.service;

import com.example.booklibrary.model.BookLoanCard;

import java.util.List;

public interface IBookLoanCardService {
    List<BookLoanCard> findAll();
    BookLoanCard findById(int id);
    void deleteById(int id);
    void save(BookLoanCard bookLoanCard);
    BookLoanCard findByCardName(String cardName);
}
