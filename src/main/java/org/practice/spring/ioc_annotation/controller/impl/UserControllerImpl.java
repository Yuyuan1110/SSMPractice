package org.practice.spring.ioc_annotation.controller.impl;

import org.practice.spring.ioc_annotation.controller.UserController;
import org.practice.spring.ioc_annotation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserControllerImpl implements UserController {

    @Autowired
    private UserService userService;

    public  void saveUser(){
        userService.saveUser();
    }
}
