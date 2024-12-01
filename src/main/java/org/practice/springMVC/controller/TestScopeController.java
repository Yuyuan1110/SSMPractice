package org.practice.springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class TestScopeController {

    @RequestMapping("mav")
    public ModelAndView mav() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message", "Hello, model and view");
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping("/model")
    public String model(Model model){
        model.addAttribute("message", "Hello, model ");
        return "success";
    }

    @RequestMapping("/modelmap")
    public String modelmap(ModelMap modelMap){
        modelMap.addAttribute("message", "Hello, model map");
        return "success";
    }

    @RequestMapping("/map")
    public String map(Map<String, Object> map){
        map.put("message", "Hello, map");
        return "success";
    }
}
