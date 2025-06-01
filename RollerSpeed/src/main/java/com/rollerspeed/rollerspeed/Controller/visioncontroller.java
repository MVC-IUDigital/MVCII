package com.rollerspeed.rollerspeed.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class visioncontroller {
@GetMapping("/vision")
    public String vision(Model model) {
        model.addAttribute("contenido", "vision");
        return "layout";
    }
}
