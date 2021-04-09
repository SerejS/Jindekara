package com.jindekara.controllers;

import com.jindekara.models.Event;
import com.jindekara.repo.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class MainController {
    @GetMapping("/")
    public String home_page() {
        return "jindekara";
    }
}
