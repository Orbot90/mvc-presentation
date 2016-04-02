package ru.mbkcapital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.mbkcapital.dto.SimpleFormDto;
import ru.mbkcapital.service.ToDoService;

/**
 * Created by orbot on 02.04.16.
 */
@Controller
public class ToDoController {

    @Autowired
    private ToDoService service;

    @RequestMapping(value = "/process", method = RequestMethod.POST)
    @ResponseBody
    public SimpleFormDto process(@RequestBody SimpleFormDto dto) {
        return service.getSomeDto(dto);
    }
}
