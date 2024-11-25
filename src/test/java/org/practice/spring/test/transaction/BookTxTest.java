package org.practice.spring.test.transaction;

import org.junit.jupiter.api.Test;
import org.practice.spring.transaction.controller.BookController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(locations = "classpath:spring-jdbc.xml")
public class BookTxTest {
    @Autowired
    private BookController bookController;

    @Test
    public void testBuyBook(){
        bookController.buyBook(1,1);
    }

    @Test
    public void testMoreBook(){
        int[] bookIDs = {1,2};
        bookController.buyMoreBook(bookIDs, 1);
    }
}
