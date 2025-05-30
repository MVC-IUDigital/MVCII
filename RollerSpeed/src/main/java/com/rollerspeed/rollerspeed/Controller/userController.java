package com.rollerspeed.rollerspeed.Controller;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



import com.rollerspeed.rollerspeed.Services.userService;

public class userController {

    private final userService userService;

    public userController (userService userService) {
        this.userService=userService;
    }

    @GetMapping("/users")

    public String listUsers (Model model) {
        model.addAttribute("users",userService.listUsers());
        return "users";
    }

    

}
