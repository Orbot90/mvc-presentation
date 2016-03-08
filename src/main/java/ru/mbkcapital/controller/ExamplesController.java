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

    @RequestMapping(value = "/angularapp", method = RequestMethod.GET)
    public String showAngularApp() {
        return "angular";
    }

    @RequestMapping(value = "/thirdpagepost", method = RequestMethod.POST)
    @ResponseBody
    public SimpleFormDto postThirdPage(@Valid SimpleFormDto dto, BindingResult errors) {
        if(errors.hasErrors()) {
            throw new InvalidRequestException("Invalid request", errors);
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        dto.setName(dto.getName() + ", великий и ужасный!");
        return dto;
    }
}
