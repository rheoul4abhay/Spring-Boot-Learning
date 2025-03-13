package com.spring.spring_boot_mvc_implementation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(){
        return "home";
    }

    @RequestMapping("/add")
    public String add(@RequestParam("num1") int a, @RequestParam("num2") int b, Model model){
        int num3 = a + b;
        model.addAttribute("num3", num3);
        return "result";
    }
}
