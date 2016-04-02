package ru.mbkcapital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.mbkcapital.dto.SimpleFormDto;
import ru.mbkcapital.model.CoolEntity;
import ru.mbkcapital.service.ToDoService;

import java.util.List;

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

    @RequestMapping(value = "/post_entity", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void postEntity(@RequestBody CoolEntity entity) {
        service.saveEntity(entity);
    }

    @RequestMapping(value = "/get_entities", method = RequestMethod.GET)
    @ResponseBody
    public List<CoolEntity> getEntities() {
        return service.getEntities();
    }
}
