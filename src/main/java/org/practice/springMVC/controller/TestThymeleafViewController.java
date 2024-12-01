package org.practice.springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestThymeleafViewController {

    @RequestMapping("/view/thymeleaf")
    public ModelAndView thymeleafView(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("success");
        return modelAndView;
    }
    @RequestMapping("/view/forward")
    public String internalResourceView(){
        return "forward:/model";
    }
    @RequestMapping("/view/redirect")
    public String redirectView(){
        return "redirect:/model";
    }
}
