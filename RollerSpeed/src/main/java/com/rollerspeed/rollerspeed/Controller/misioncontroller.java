package com.rollerspeed.rollerspeed.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class misioncontroller {
@GetMapping("/mision")
    public String mision(Model model) {
        model.addAttribute("contenido", "mision");
        return "layout";
    }
    
}
