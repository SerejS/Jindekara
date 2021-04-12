package com.jindekara.controllers;

import com.jindekara.models.Personage;
import com.jindekara.repo.PersonageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class PersonageController {
    @Autowired
    private PersonageRepository personageRepository;

    @RequestMapping(value = "/personages")
    public String characters_page(Model model) {
        Iterable<Personage> personages = personageRepository.findAll();
        model.addAttribute("personages", personages);
        return "personages";
    }

}
