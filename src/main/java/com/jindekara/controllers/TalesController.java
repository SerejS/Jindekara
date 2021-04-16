package com.jindekara.controllers;

import com.jindekara.models.Event;
import com.jindekara.repo.EventRepository;
import com.jindekara.functions.JindekaraCalender;
import com.jindekara.functions.FileUtils;

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
    public String tales_page(Model model,
                             @RequestParam(defaultValue = "0", value = "select") Long id) {
        //Создание итератора со всеми событиями сортированными по году начала
        Iterable<Event> events = eventRepository.findAll(Sort.by(Sort.Direction.ASC, "yearStart"));
        model.addAttribute("events", events);

        //Добавление атрибута, показыващего выбранный режим отображения
        model.addAttribute("select", id);

        //Добавление параметров необходимых для отображения конкретного события
        if (id > 0 && eventRepository.findById(id).isPresent()) {
            Event event = eventRepository.findById(id).get();
            model.addAttribute("selected_event", event);
            model.addAttribute("description", FileUtils.loadPrefEvent(id));
        }
        //Добавление параметров необходимых для изменения события
        else if (id < 0 && eventRepository.findById(-id).isPresent()) {
            model.addAttribute("selected_event", eventRepository.findById(-id).get());
            model.addAttribute("description", FileUtils.loadDesc(id));
        }

        return "tales";
    }


    @RequestMapping(value = "tales/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("event") Event event, @RequestParam String description) {
        eventRepository.save(event);
        if (description != null) {
            FileUtils.save(event.getId(), description);
        }
        return "redirect:../tales";
    }

    @RequestMapping(value = "tales/delete", method = RequestMethod.POST)
    public String delete(@RequestParam(value = "select") Long id) {
        eventRepository.deleteById(id);
        return "redirect:../tales";
    }

    @RequestMapping(value = "tales/edit", method = RequestMethod.POST)
    public String edit(@RequestParam(value = "select") Long id,
                       @ModelAttribute("event") Event event,
                       @RequestParam String description) {
        event.setId(id);
        if (description != null) {
            FileUtils.save(event.getId(), description);
        }
        eventRepository.save(event);
        return "redirect:../tales";
    }
}
