package ru.mbkcapital.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.mbkcapital.dto.SimpleFormDto;

/**
 * Created by plevako on 10.03.2016.
 */
@Controller
@RequestMapping(value = "/thymeleaf")
public class ThymeleafExamplesController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String showThymeleafExamples() {
        return "thymeleaf";
    }

    @RequestMapping(value = "/loop", method = RequestMethod.GET)
    public String showLoop() {
        return "ThymeleafLoop";
    }

    @RequestMapping(value = "/model", method = RequestMethod.GET)
    public String showModelExample(ModelMap modelMap) {
        SimpleFormDto dto = new SimpleFormDto();
        dto.setName("Чебурашка");
        dto.setEmail("cheburator1488@gmail.com");
        modelMap.addAttribute("cheburator", dto);
        modelMap.addAttribute("numberOfTheBeast", 666);
        return "ThymeleafModel";
    }

    @RequestMapping(value = "/locales", method = RequestMethod.GET)
    public String showLocalesExample() {
        return "ThymeleafLocales";
    }

}
