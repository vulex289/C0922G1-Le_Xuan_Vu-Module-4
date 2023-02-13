package com.example.booklibrary.repository;

import com.example.booklibrary.model.BookLoanCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookLoanCardRepository extends JpaRepository<BookLoanCard,Integer> {
    BookLoanCard findByCardName(String cardName);
}
