package com.rollerspeed.rollerspeed.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class servicioscontroller {
@GetMapping("/servicios")
    public String servicios(Model model) {
        model.addAttribute("contenido", "servicios");
        return "layout";
    }
}
