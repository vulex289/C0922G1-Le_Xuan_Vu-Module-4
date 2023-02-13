package com.example.booklibrary.service;

import com.example.booklibrary.model.BookLoanCard;
import com.example.booklibrary.repository.IBookLoanCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookLoanService implements IBookLoanCardService {
    @Autowired
    private IBookLoanCardRepository bookLoanCardRepository;

    @Override
    public List<BookLoanCard> findAll() {
        return bookLoanCardRepository.findAll();
    }

    @Override
    public BookLoanCard findById(int id) {
        return bookLoanCardRepository.findById(id).orElse(null);
    }


    @Override
    public void deleteById(int id) {
        bookLoanCardRepository.deleteById(id);
    }

    @Override
    public void save(BookLoanCard bookLoanCard) {
        bookLoanCardRepository.save(bookLoanCard);
    }

    @Override
    public BookLoanCard findByCardName(String cardName) {
        return bookLoanCardRepository.findByCardName(cardName);
    }
}
