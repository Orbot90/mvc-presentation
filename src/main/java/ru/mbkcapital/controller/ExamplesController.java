package ru.mbkcapital.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.mbkcapital.dto.SimpleFormDto;
import ru.mbkcapital.error.InvalidRequestException;

import javax.validation.Valid;

/**
 * Created by orbot on 08.03.16.
 */
@Controller
public class ExamplesController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showIndex() {
        return "index";
    }

}
