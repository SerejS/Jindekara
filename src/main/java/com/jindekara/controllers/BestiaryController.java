package com.jindekara.controllers;

import com.jindekara.repo.RaceRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BestiaryController {
    private final RaceRepository raceRepository;

    public BestiaryController(RaceRepository raceRepository) {
        this.raceRepository = raceRepository;
    }

    @RequestMapping("/bestiary")
    public String bestiary_page() {
        return "bestiary";
    }
}
