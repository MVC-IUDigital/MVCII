package com.rollerspeed.rollerspeed.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")

public class misioncontroller {

    @GetMapping("mision")
    public String mision() {
        return "mision";
    }
    

    
}
