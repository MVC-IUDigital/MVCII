package com.rollerspeed.rollerspeed.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;


@Controller

@RequestMapping("/")

public class indexcontroller {
    @GetMapping("index")
    public String index() {
        return "index";

    }


    

}
