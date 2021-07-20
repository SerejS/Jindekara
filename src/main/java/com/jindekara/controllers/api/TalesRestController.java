package com.jindekara.controllers.api;

import com.jindekara.models.Event;
import com.jindekara.repo.EventRepository;
import com.jindekara.util.FileUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/tales")
public class TalesRestController {
    private final EventRepository eventRepository;

    TalesRestController(EventRepository repository) {this.eventRepository = repository;}

    @PostMapping("all")
    public List<Event> findAll() {
        return eventRepository.findAll();
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
