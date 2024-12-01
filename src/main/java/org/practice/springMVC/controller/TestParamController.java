package org.practice.springMVC.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.practice.springMVC.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class TestParamController {

    @RequestMapping("/param/servletAPI")
    public String getParamServletApi(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username: " + username + " password: " + password);
        return "success";
    }

    @RequestMapping(value = "/param", method = {RequestMethod.GET, RequestMethod.POST})
    public String getParam(@RequestParam(value = "username", required = false, defaultValue = "user1") String username,
                           @RequestParam("password") String password,
                           @RequestHeader("referer") String referer,
                           @CookieValue("JSESSIONID") String jsessionId) {
        System.out.println("username: " + username + " password: " + password);
        System.out.println("header: " + referer);
        System.out.println("jsessionId: " + jsessionId);
        return "success";
    }

    @RequestMapping("/getUser")
    public String getUser(User user) {

        System.out.println("User: " + user);
        return "success";
    }

}
