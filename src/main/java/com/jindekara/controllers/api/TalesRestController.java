package com.jindekara.controllers.api;

import com.jindekara.models.Event;
import com.jindekara.repo.EventRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
