package com.rollerspeed.rollerspeed.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; // FALTABA ESTO
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

    @Autowired
    public userController(userService userService) {
        this.userService = userService;
    }

    // Mostrar formulario de registro en /registro
    @GetMapping("/registro")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("user", new user());
        return "users"; // Nombre del archivo .html en templates
    }

    // Procesar formulario POST a /users
    @PostMapping
    public String registrarUsuario(@ModelAttribute("user") user user) {
        userService.save(user);
        return "redirect:/users/registro?success"; // redirige con parámetro de éxito
    }

    // Lista de usuarios
    @GetMapping("/listar")
    public String getAllUsers(Model model) {
        List<user> listUsers = userService.listUsers();
        model.addAttribute("users", listUsers);
        return "listaUsuarios"; // Vista que debes crear para mostrar la lista
    }

    @GetMapping
public String redirigirARegistro() {
    return "redirect:/users/registro";
}
}
