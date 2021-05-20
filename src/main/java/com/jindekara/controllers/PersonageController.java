package com.jindekara.controllers;

import com.jindekara.util.FileUtils;
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

        //В зависимости от режима отображения шаблону выдаются соответствующие атрибуты
        if (id > 0 && personageRepository.findById(id).isPresent()) {
            Optional<Personage> personage = personageRepository.findById(id);
            model.addAttribute("selected_personage", personage.get());
            model.addAttribute("bio", FileUtils.loadBio(id));
        } else {
            model.addAttribute("specializations", specializationRepository.findAll());
            if (id < 0) {
                Optional<Personage> personage = personageRepository.findById(-id);
                model.addAttribute("selected_personage", personage.get());
                String bio = FileUtils.loadBio(-id);
                model.addAttribute("bio", bio.substring(31, bio.length()-4));
            }
        }

        model.addAttribute("select", id);
        model.addAttribute("personages", personages);
        return "personages";
    }

    @RequestMapping(value = "personages/save", method = RequestMethod.POST)
    public String save_personage(@ModelAttribute("personage") Personage personage,
                                 @RequestParam String bio) {
        personageRepository.save(personage);
        if (bio != null && !bio.equals("")) {
            FileUtils.saveBio(personage.getId(), bio);
        }
        return "redirect:../personages";
    }

    @RequestMapping(value = "personages/edit", method = RequestMethod.POST)
    public String edit_personage(@RequestParam("select") Long id,
                                 @ModelAttribute("personage") Personage personage,
                                 @RequestParam("bio") String bio) {
        personage.setId(id);
        if (bio !=  null && !bio.equals("")) {
            FileUtils.saveBio(personage.getId(), bio);
        }
        personageRepository.save(personage);
        return "redirect:../personages";
    }

    @RequestMapping(value = "personages/delete", method = RequestMethod.POST)
    public String delete_personage(@RequestParam("select") Long id) {
        personageRepository.deleteById(id);
        FileUtils.deleteBio(id);
        return "redirect:../personages";
    }
}
