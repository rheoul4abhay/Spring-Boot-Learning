package com.spring.spring_model_attribute.controller;

import com.spring.spring_model_attribute.model.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String displayHomePage(){
        return "home";
    }

    @RequestMapping("/addUser")
    public String addUser(@ModelAttribute("user") UserDTO userDTO) {
        return "result";
    }
}
