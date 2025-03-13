package com.spring.spring_model_attribute_methodLevel.controller;

import com.spring.spring_model_attribute_methodLevel.model.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @ModelAttribute //It will be called before every other request handler methods
    public void modelData(Model m) {
        m.addAttribute("role", "Employee");
    }

    @RequestMapping("/")
    public String displayHomePage(){
        return "home";
    }

    @RequestMapping("/addUser")
    public String addUser(@ModelAttribute("user") UserDTO userDTO){
        return "result";
    }
}
