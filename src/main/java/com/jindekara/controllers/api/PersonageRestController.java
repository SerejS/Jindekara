package com.jindekara.controllers.api;

import com.jindekara.models.Personage;
import com.jindekara.models.Race;
import com.jindekara.repo.PersonageRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/personages")
public class PersonageRestController {
    private final PersonageRepository personageRepository;

    public PersonageRestController(PersonageRepository personageRepository) {
        this.personageRepository = personageRepository;
    }

    @PostMapping(value = "all")
    public List<Personage> findAll() {
        return personageRepository.findAll();
    }
}
