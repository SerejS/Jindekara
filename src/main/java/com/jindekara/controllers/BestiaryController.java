package com.jindekara.controllers;

import com.jindekara.repo.RaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BestiaryController {
    @Autowired
    private RaceRepository raceRepository;

    @RequestMapping("/bestiary")
    public String bestiary_page(Model model) {
        model.addAttribute("races", raceRepository.findAll());
        return "bestiary";
    }
}
