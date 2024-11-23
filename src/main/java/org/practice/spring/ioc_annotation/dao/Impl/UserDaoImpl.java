package org.practice.spring.ioc_annotation.dao.Impl;

import org.practice.spring.ioc_annotation.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository("dao")
public class UserDaoImpl implements UserDao {
    @Override
    public void saveUser() {
        System.out.println("saveUser success");
    }
}
