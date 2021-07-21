package com.jindekara.controllers.api;

import com.jindekara.models.Event;
import com.jindekara.models.Race;
import com.jindekara.repo.EventRepository;
import com.jindekara.util.FileUtils;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("api/tales")
public class TalesRestController {
    private final EventRepository eventRepository;

    TalesRestController(EventRepository repository) {this.eventRepository = repository;}

    @PostMapping("all")
    public List<Event> findAll() {
        return eventRepository.findAll();
    }

    @PostMapping("save")
    public ResponseEntity<Long> save_event(@ModelAttribute("event") Event event,
                                           @ModelAttribute("desc_events") String desc) {
        try {
            Long id = eventRepository.save(event).getId();
            if (!desc.equals("")) FileUtils.saveDesc(id, desc);
            return ResponseEntity.status(HttpStatus.CREATED).body(id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping(value = "info/{id}")
    public ResponseEntity<List<String>> getMoreInfo(@PathVariable("id") Long id) {
        return ResponseEntity
                .ok()
                .cacheControl(CacheControl.maxAge(2, TimeUnit.MINUTES))
                .body(Arrays.asList(FileUtils.loadDesc(id)));
    }

    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            eventRepository.deleteById(id);
            FileUtils.deleteDesc(id);

            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }
}
