package org.practice.spring.transaction.dao;

public interface BookDao {
    int getBookPriceByBookID(int bookID);

    void updateStock(int bookID);

    void updateUserBalance(int userID, int price);
}
