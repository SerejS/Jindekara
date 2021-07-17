package com.jindekara.controllers.api;

import com.jindekara.models.Race;
import com.jindekara.repo.RaceRepository;
import com.jindekara.util.FileUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "api/bestiary")
public class BestiaryRestController {
    private final RaceRepository raceRepository;

    public BestiaryRestController(RaceRepository raceRepository) {
        this.raceRepository = raceRepository;
    }

    @RequestMapping(value = "races", method = RequestMethod.POST)
    public List<Race> findAll() {
        return raceRepository.findAll();
    }

    @RequestMapping(value = "info", method = RequestMethod.POST)
    public List<String> getMoreInfo(@RequestParam("id") Long id) {
        return Arrays.asList(FileUtils.loadWeakness(id), FileUtils.loadNote(id));
    }

    @PostMapping(value = "save")
    public ResponseEntity<Long> save_race(@ModelAttribute("race") Race race) {
        try {
            Long id = raceRepository.save(race).getId();
            return ResponseEntity.status(HttpStatus.CREATED).body(id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            raceRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }
}
