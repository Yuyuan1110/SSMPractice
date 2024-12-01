package org.practice.springMVC.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/test")
public class PortalController {

//    @RequestMapping("/")
//    public String portal(){
//        return "index";
//    }
    @RequestMapping("/rest/{username}/{id}")
    public String placeholder(@PathVariable("id") int id, @PathVariable("username") String username){
        System.out.println("id:" + id);
        System.out.println("username:" + username);

        return "success";
    }
}
