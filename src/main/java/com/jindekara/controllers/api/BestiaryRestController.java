package com.jindekara.controllers.api;

import com.jindekara.models.Race;
import com.jindekara.repo.RaceRepository;
import com.jindekara.util.FileUtils;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping(value = "api/bestiary")
public class BestiaryRestController {
    private final RaceRepository raceRepository;

    public BestiaryRestController(RaceRepository raceRepository) {
        this.raceRepository = raceRepository;
    }

    @PostMapping(value = "all")
    public List<Race> findAll() {
        return raceRepository.findAll();
    }

    @GetMapping(value = "info/{id}")
    public ResponseEntity<List<String>> getMoreInfo(@PathVariable("id") Long id) {
        return ResponseEntity
                .ok()
                .cacheControl(CacheControl.maxAge(2, TimeUnit.MINUTES))
                .body(Arrays.asList(FileUtils.loadWeakness(id), FileUtils.loadNote(id)));
    }

    @PostMapping(value = "save")
    public ResponseEntity<Long> save_race(@RequestParam("weakness") String weak, @RequestParam("notes") String note,
                                          @ModelAttribute("race") Race race) {
        try {
            Long id = raceRepository.save(race).getId();
            if (!weak.equals("")) FileUtils.saveWeakness(id, weak);
            if (!note.equals("")) FileUtils.saveNote(id, note);
            return ResponseEntity.status(HttpStatus.CREATED).body(id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            raceRepository.deleteById(id);

            FileUtils.deleteWeakness(id);
            FileUtils.deleteNotes(id);

            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }
}
