package com.jindekara.controllers;

import com.jindekara.models.Event;
import com.jindekara.models.Personage;
import com.jindekara.repo.PersonageRepository;
import com.jindekara.repo.SpecializationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class PersonageController {
    @Autowired
    private PersonageRepository personageRepository;
    @Autowired
    private SpecializationRepository specializationRepository;

    @RequestMapping(value = "/personages")
    public String characters_page(Model model,
                                  @RequestParam(defaultValue = "0", value = "select") Long id) {
        Iterable<Personage> personages = personageRepository.findAll();

        if (id > 0 && personageRepository.findById(id).isPresent()) {
            Optional<Personage> personage = personageRepository.findById(id);
            model.addAttribute("selected_personage", personage.get());
        }

        if (id <= 0) {
            model.addAttribute("specializations", specializationRepository.findAll());
        }

        model.addAttribute("select", id);
        model.addAttribute("personages", personages);
        return "personages";
    }

    @RequestMapping(value = "personages/save", method = RequestMethod.POST)
    public String save_personage(@ModelAttribute("personage") Personage personage) {
        personageRepository.save(personage);
        return "redirect:../personages";
    }

    @RequestMapping(value = "personages/delete", method = RequestMethod.POST)
    public String delete_personage(@RequestParam("select") Long id) {
        personageRepository.deleteById(id);
        return "redirect:../personages";
    }

}
