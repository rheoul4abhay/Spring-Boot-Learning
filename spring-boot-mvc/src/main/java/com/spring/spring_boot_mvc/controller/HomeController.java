package com.spring.spring_boot_mvc.controller;

import com.spring.spring_boot_mvc.model.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/")
    public String displayHomePage(Model model){
        model.addAttribute("message", "Welcome to home page!");
        return "index";
    }

    @GetMapping("/users")
    public String showUsers(Model model){
        List<UserDTO> usersList = new ArrayList<>();
        usersList.add(new UserDTO("Abhay", 22));
        usersList.add(new UserDTO("Ramesh", 24));
        usersList.add(new UserDTO("Anil", 26));
        model.addAttribute("users", usersList);
        return "users";
    }
}
