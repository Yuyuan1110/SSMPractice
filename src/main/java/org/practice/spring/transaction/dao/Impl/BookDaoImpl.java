package org.practice.spring.transaction.dao.Impl;

import org.practice.spring.transaction.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int getBookPriceByBookID(int bookID) {
        String sql = "select price from l_book where book_id = ?";
        Integer price = jdbcTemplate.queryForObject(sql, Integer.class, bookID);

        return price;
    }

    @Override
    public void updateStock(int bookID) {
        String sql = "update l_book set stock = stock - 1 where book_id = ?";
        jdbcTemplate.update(sql, bookID);


    }

    @Override
    public void updateUserBalance(int userID, int price) {
        String sql = "update l_user set balance = balance - ? where id = ?";
        jdbcTemplate.update(sql, price, userID);
    }
}
