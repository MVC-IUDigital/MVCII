package com.rollerspeed.rollerspeed.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class valorescontroller {
@GetMapping("/valores")
    public String valores(Model model) {
        model.addAttribute("contenido", "valores");
        return "layout";
    }
    
}
