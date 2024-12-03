package org.practice.springMVC.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.practice.springMVC.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@Controller
public class TestAjaxController {

    @PostMapping(value = "/ajax", consumes = "application/json")
    public void testAjax(@RequestBody User user , HttpServletResponse response) throws IOException {
//        System.out.println("get id::" +id);
        System.out.println("get request body::" +user);
        response.getWriter().write("hello, ajax");
    }
    @PostMapping(value = "/ajax/map", consumes = "application/json")
    public void testMap(@RequestBody Map<String, Object> map, HttpServletResponse response) throws IOException {
//        System.out.println("get id::" +id);
        System.out.println("get request body map:" + map);
        response.getWriter().write("hello, ajax");
    }

//    @GetMapping(value = "/response/body")
//    @ResponseBody
//    public String testResponseBody(){
//
//        return "hello, response body";
//    }
    @GetMapping(value = "/response/body")
    @ResponseBody
    public User testResponseBody(){
            User user = new User();
            user.setId(1);
            user.setUsername("王");
            user.setPassword("1234");
//        System.out.println(user);
        return user;
    }
}
