package ru.mbkcapital.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.mbkcapital.utils.DataCreator;

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
    public ModelAndView showLoop() {
        ModelAndView view = new ModelAndView("ThymeleafLoop");
        view.addObject("dataList", DataCreator.initDataList());
        view.addObject("dataMap", DataCreator.initDataMap());
        return view;
    }

    @RequestMapping(value = "/model", method = RequestMethod.GET)
    public String showModelExample(ModelMap modelMap) {
        modelMap.addAttribute("cheburator", DataCreator.createCheburator());
        modelMap.addAttribute("numberOfTheBeast", 666);
        return "ThymeleafModel";
    }

    @RequestMapping(value = "/locales", method = RequestMethod.GET)
    public String showLocalesExample() {
        return "ThymeleafLocales";
    }

    @RequestMapping(value = "/fragments", method = RequestMethod.GET)
    public String showFragmentsExample(ModelMap model, @RequestParam Boolean someparam) {
        model.addAttribute("someparam", someparam);
        return "ThymeleafFragments";
    }

}
