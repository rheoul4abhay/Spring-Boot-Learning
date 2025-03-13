package com.spring.spring_controller_mappings.controller;

import com.spring.spring_controller_mappings.model.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {

    @ModelAttribute
    public void modelData(Model m) {
        m.addAttribute("role", "Employee");
    }

    @RequestMapping("/")
    public String homePage(){
        return "home";
    }

    @GetMapping("users") //For demonstration purpose we hardcode these users like below, but once we add a database then we can show the users who are actually added
    public String showAllUsers(Model model){
        List<UserDTO> usersList = Arrays.asList(new UserDTO(101, "Abhay", 22), new UserDTO(102, "Kiran", 23), new UserDTO(103, "Alex", 25));
        model.addAttribute("users", usersList);
        return "users";
    }

    @PostMapping(value="user")
    public String addUser(@ModelAttribute("newUser") UserDTO userDTO){
        return "user";
    }
}
