package org.practice.spring.ioc_annotation.service.Impl;

import org.practice.spring.ioc_annotation.dao.UserDao;
import org.practice.spring.ioc_annotation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void saveUser() {
        userDao.saveUser();
    }
}
