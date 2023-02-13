package com.example.booklibrary.controller;

import com.example.booklibrary.customException.ZeroQuantityException;
import com.example.booklibrary.model.Book;
import com.example.booklibrary.model.BookLoanCard;
import com.example.booklibrary.service.IBookLoanCardService;
import com.example.booklibrary.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class BookController {
    @Autowired
  private IBookLoanCardService bookLoanCardService;
    @Autowired
    IBookService bookService;

    @GetMapping("/book")
    public String showList(Model model) {
        model.addAttribute("bookList", bookService.findAll());
        return "list";
    }

    @GetMapping("/book/create")
    public String showFormCreate(Model model) {
        model.addAttribute("book", new Book());
        return "create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Book book, RedirectAttributes attributes) {
        bookService.save(book);
        attributes.addFlashAttribute("msg", "Thêm mới thành công");
        return "redirect:/book";
    }

    @GetMapping("book/detail/{id}")
    public String ShowFormBorrow(Model model, @PathVariable int id) throws ZeroQuantityException {
        model.addAttribute("book", bookService.findById(id));
        if (bookService.findById(id).getQuantity() == 0) {
            throw new ZeroQuantityException();
        }
        return "detail";
    }

    @GetMapping("/bookLoanCard")
    public String showCardList(Model model) {
        model.addAttribute("bookLoanList", bookLoanCardService.findAll());
        return "bookLoanCardList";
    }

    @PostMapping("/borrow")
    public String borrow(@ModelAttribute(value = "book") Book book, RedirectAttributes redirectAttributes) {
        Random random = new Random();
        String bookCode = String.valueOf(random.nextInt(99999 - 10000 + 1) + 10000);
        BookLoanCard bookLoanCard = new BookLoanCard(bookCode, book.getCode());
        bookLoanCardService.save(bookLoanCard);
        book.setQuantity(book.getQuantity() - 1);
        bookService.save(book);
        redirectAttributes.addFlashAttribute("msg", "Mượn sách thành công");
        return "redirect:/book";
    }

    @GetMapping("/book/pay")
    public String showFormPay() {
        return "pay";
    }

    @PostMapping("/pay")
    public String pay(@RequestParam String cardName, RedirectAttributes attributes) {
        BookLoanCard bookLoanCard = bookLoanCardService.findByCardName(cardName);
        if (bookLoanCard == null) {
            return "error";
        } else {
            Book book = bookService.findByCode(bookLoanCard.getBookCode());
            bookLoanCardService.deleteById(bookLoanCard.getId());
            book.setQuantity(book.getQuantity() + 1);
            bookService.save(book);
            attributes.addFlashAttribute("msg", "Trả sách thành công");
            return "redirect:/book";
        }
    }

    @ExceptionHandler(ZeroQuantityException.class)
    public String handlerException() {
        return "error1";
    }
}
