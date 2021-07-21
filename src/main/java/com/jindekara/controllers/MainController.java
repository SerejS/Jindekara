package com.jindekara.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @RequestMapping("/")
    public String home_page() {
        return "jindekara";
    }

    @RequestMapping(value = {"/tales", "/bestiary", "/personages"})
    public String table_page() {
        return "default";
    }
}
