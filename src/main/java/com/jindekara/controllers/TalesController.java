package com.jindekara.controllers;

import com.jindekara.models.Event;
import com.jindekara.repo.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class TalesController {
    @Autowired
    private EventRepository eventRepository;

    @RequestMapping(value = "/tales")
    public String tales_page(Model model, @RequestParam(defaultValue = "0", value = "select") long id) {
        Iterable<Event> events = eventRepository.findAll(Sort.by(Sort.Direction.ASC, "yearStart"));

        model.addAttribute("select", id);
        model.addAttribute("events", events);
        if(eventRepository.findById(id).isPresent())
            model.addAttribute("selected_event", eventRepository.findById(id).get());
        return "tales";
    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("event") Event event) {
        eventRepository.save(event);
        return "redirect:tales";
    }
}
