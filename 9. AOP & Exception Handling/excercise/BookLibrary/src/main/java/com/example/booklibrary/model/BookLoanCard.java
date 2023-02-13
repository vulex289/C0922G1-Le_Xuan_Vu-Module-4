package com.example.booklibrary.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BookLoanCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String cardName;
    private String bookCode;

    public BookLoanCard() {
    }

    public BookLoanCard(int id, String name, String bookCode) {
        this.id = id;
        this.cardName = name;
        this.bookCode = bookCode;
    }

    public BookLoanCard(String name, String bookCode) {
        this.cardName = name;
        this.bookCode = bookCode;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookCode() {
        return bookCode;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }
}
