package org.practice.springMVC.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

//    @RequestMapping("/")
//    public String protal(){
//
//        return "index";
//    }

    @GetMapping("/upload/and/download")
    public String cloud(){
        return "upload_and_downlaod";
    }

    @RequestMapping("/hello")
    public String hello(){

        return "success";
    }

    @RequestMapping("/test/exception")
    public String testException(){
        int a = 1/0;
        System.out.println("error: 1/0"+ a);
        return "success";
    }
}
