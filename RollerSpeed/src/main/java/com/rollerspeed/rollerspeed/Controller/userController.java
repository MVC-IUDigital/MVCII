package com.rollerspeed.rollerspeed.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.rollerspeed.rollerspeed.Models.user;
import com.rollerspeed.rollerspeed.Services.userService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Usuarios", description = "Métodos de gestión de usuarios")
@Controller
@RequestMapping("/users")
public class userController {

    private final userService userService;

    public userController(userService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Muestra el formulario para registrar un nuevo usuario", description = "Carga el HTML con el formulario de registro de usuarios.")
    @GetMapping("/nuevo")
    public String nuevoUsuario(Model model) {
        model.addAttribute("user", new user());
        model.addAttribute("contenido", "usersForm");
        return "layout";
    }

    @Operation(summary = "Mostrar formulario", description = "Muestra directamente el formulario, pero sin cargar datos previos.")
    @GetMapping("/usersForm")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("user", new user());
        return "layout";
    }

    @Operation(summary = "Guardar usuario", description = "Guarda un nuevo registro de usuario o actualiza uno que ya existe, solo si el atributo correo no está repetido.")
    @PostMapping("/guardarusuario")
    public String registrarUsuario(@ModelAttribute("user") user user, Model model) {
        if (userService.emailYaExiste(user.getCorreo())) {
            model.addAttribute("error", "El correo ya está registrado.");
            model.addAttribute("contenido", "usersForm");
            return "layout";
        }
        userService.save(user);
        return "redirect:/users/listar";
    }

    @Operation(summary = "Listar usuarios", description = "Muestra el HTML con los registros.")
    @GetMapping("/listar")
    public String getAllUsers(Model model) {
        List<user> listUsers = userService.listUsers();
        model.addAttribute("users", listUsers);
        model.addAttribute("contenido", "users");
        return "layout";
    }

    @Operation(summary = "Redirigir a el listado", description = "Redirige a la ruta /users/listar.")
    @GetMapping
    public String redirigirARegistro() {
        return "redirect:/users/listar";
    }

    @Operation(summary = "Editar usuario", description = "Carga el formulario con los datos del usuario seleccionado previamente cargados y listos para su edición.")
    @GetMapping("/editar/{id}")
    public String editarUsuario(@PathVariable("id") Long id, Model model) {
        user usuario = userService.getById(id);
        model.addAttribute("user", usuario);
        model.addAttribute("contenido", "usersForm");
        return "layout";
    }

    @Operation(summary = "Eliminar usuario", description = "Elimina el usuario según su ID y redirige al listado.")
    @GetMapping("/eliminar/{id}")
    public String eliminarUsuario(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return "redirect:/users/listar";
    }
}

