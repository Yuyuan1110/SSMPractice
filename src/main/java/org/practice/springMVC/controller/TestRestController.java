package org.practice.springMVC.controller;

import org.practice.springMVC.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@RequestMapping("/user")
public class TestRestController {

    @RequestMapping(value="/user", method = RequestMethod.GET)
    public String getAllUsers(){
        System.out.println("getAllUsers");
        return "success";
    }

    @RequestMapping(value="/user/{id}", method = RequestMethod.GET)
    public String getUserById(@PathVariable("id") int id){
        System.out.println("Get user by id:" +id);
        return "success";
    }

    @RequestMapping(value="/user", method = RequestMethod.POST)
    public String addUser(User user){
        System.out.println(user);
        return "success";
    }

    @RequestMapping(value="/user/{id}", method = RequestMethod.DELETE)
    public String deleteUserById(@PathVariable("id")int id){
        System.out.println("User:"+id+"was destroy.");
        return "success";
    }
    @RequestMapping(value="/user", method = RequestMethod.PUT)
    public String updateUserById(){
        System.out.println("User was updated.");
        return "success";
    }


}
