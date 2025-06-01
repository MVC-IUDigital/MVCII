package com.rollerspeed.rollerspeed.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class indexcontroller {
 @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("contenido", "index");
        return "layout";
    }
}
