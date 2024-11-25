package org.practice.spring.transaction.service.impl;

import org.practice.spring.transaction.service.BookService;
import org.practice.spring.transaction.service.CheckOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CheckOutServiceImpl implements CheckOutService {

    @Autowired
    private BookService bookService;


    @Transactional
    @Override
    public void checkOut(int[] bookIDs, int userID) {
        for (int bookID : bookIDs) {
            bookService.buyBook(bookID, userID);
        }

    }
}
