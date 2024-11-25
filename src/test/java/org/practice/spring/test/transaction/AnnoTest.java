package org.practice.spring.test.transaction;

import org.junit.jupiter.api.Test;
import org.practice.spring.transaction.SpringConfig;
import org.practice.spring.transaction.controller.BookController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnoTest {

    @Test
    public void test() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        BookController bookController = context.getBean("bookController", BookController.class);
        bookController.buyBook(1,1);
    }
}
