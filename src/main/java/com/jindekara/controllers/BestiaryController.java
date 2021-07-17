package com.jindekara.controllers;

import com.jindekara.enums.SectionBestiary;
import com.jindekara.models.Race;
import com.jindekara.repo.RaceRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
