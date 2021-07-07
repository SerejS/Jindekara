package com.jindekara.controllers;

import com.jindekara.util.FileUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JindekaraRestController {

    @RequestMapping(value = "bestiary/info", method = RequestMethod.POST)
    public String [] getMoreInfo(@RequestParam("id") Long id) {
        return new String[] {FileUtils.loadWeakness(id), FileUtils.loadNote(id)};
    }
}
