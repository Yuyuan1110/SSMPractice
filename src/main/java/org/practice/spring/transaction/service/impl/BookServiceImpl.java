package org.practice.spring.transaction.service.impl;

import org.practice.spring.transaction.dao.BookDao;
import org.practice.spring.transaction.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

//    @Transactional(propagation = Propagation.MANDATORY)
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void buyBook(int bookID, int userID) {
        // query book id
        int price = bookDao.getBookPriceByBookID(bookID);

        //update book stock
        bookDao.updateStock(bookID);

        //update user balance
        bookDao.updateUserBalance(userID, price);
    }
}
