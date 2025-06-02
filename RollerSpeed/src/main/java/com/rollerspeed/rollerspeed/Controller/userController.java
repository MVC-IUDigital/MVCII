package com.rollerspeed.rollerspeed.Controller;

import java.util.List;


import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rollerspeed.rollerspeed.Models.user;
import com.rollerspeed.rollerspeed.Services.userService;

@Controller
@RequestMapping("/users")
public class userController {

    private final userService userService;

    
    public userController(userService userService) {
        this.userService = userService;
    }


    @GetMapping("/registro")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("user", new user());
        return "users"; 
    }

    @PostMapping
    public String registrarUsuario(@ModelAttribute("user") user user) {
        userService.save(user);
        return "redirect:/users/registro?success"; 
    }

    
    @GetMapping("/listar")
    public String getAllUsers(Model model) {
        List<user> listUsers = userService.listUsers();
        model.addAttribute("users", listUsers);
        return "listaUsuarios";
    }

    @GetMapping
public String redirigirARegistro() {
    return "redirect:/users/registro";
}
}
