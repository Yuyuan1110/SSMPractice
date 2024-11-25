package org.practice.spring.test.transaction;

import org.junit.jupiter.api.Test;
import org.practice.spring.transaction.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

@SpringJUnitConfig(locations = "classpath:spring-jdbc.xml")
public class JdbcTemplateTest {


    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Test
    public void TestInsert() {
        String sql = "insert into t_user values(null, ?, ? ,? ,?, ?)";
        jdbcTemplate.update(sql, "root2", "123456", "30", "F", "root123@mail.com");
    }

    @Test
    public void TestSelect() {

        String sql = "select * from t_user where id = ?";
        User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), 2);
        System.out.println(user);
    }

    @Test
    public void TestGetAllUser(){
        String sql = "select * from t_user";
        List<User> userList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
        userList.forEach(System.out::println);
    }

    @Test
    public void TestGetCount(){
        String sql = "select count(*) from t_user";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println(count);
    }
}
