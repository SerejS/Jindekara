package com.jindekara.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @RequestMapping("/")
    public String home_page() {
        return "jindekara";
    }

    @RequestMapping(value = "/tales")
    public String tales_page() {
        return "tales";
    }

    @RequestMapping("/bestiary")
    public String bestiary_page() {
        return "bestiary";
    }
}
