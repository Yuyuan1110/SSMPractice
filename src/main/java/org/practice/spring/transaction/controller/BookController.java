package org.practice.spring.transaction.controller;

import org.practice.spring.transaction.service.BookService;
import org.practice.spring.transaction.service.CheckOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookController {

    @Autowired
    private BookService bookService;

    public void buyBook(int bookID, int userID){
        bookService.buyBook(bookID, userID);

    }
    @Autowired
    private CheckOutService checkOutService;

    public void buyMoreBook(int[] bookIDs, int userID){
        checkOutService.checkOut(bookIDs, userID);

    }
}
