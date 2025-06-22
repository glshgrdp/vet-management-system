package com.vet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/anasayfa")
    public String anasayfa() {
        return "anasayfa";
    }

    @GetMapping({"/", "/index"})
    public String home() {
        return "index";
    }

}
