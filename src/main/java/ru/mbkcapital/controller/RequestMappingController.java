package ru.mbkcapital.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;
import ru.mbkcapital.dto.SimpleFormDto;
import ru.mbkcapital.utils.DataCreator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Locale;

/**
 * Created by Ruslan Sibgatullin on 09.03.2016.
 */
@RequestMapping("/rmp")
@Controller
public class RequestMappingController {

    @RequestMapping(value = "/ind", method = RequestMethod.GET)
    public String ind() {
        return "rmp/ind";
    }



    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String show() {
        return "rmp/show";
    }

    @RequestMapping(value = "/show", method = RequestMethod.POST)
    public String showPost() {
        return "rmp/press";
    }



    @RequestMapping(value = "/param", params = "view=ji", method = RequestMethod.GET)
    public String param() {
        return "rmp/param";
    }

    @RequestMapping(value = "/param", method = RequestMethod.GET)
    public String param2(@RequestParam("view") String ji) {
        return "rmp/param";
    }




    @RequestMapping(value = "/path/{id}", method = RequestMethod.GET)
    public String path() {
        return "rmp/path";
    }

    @RequestMapping(value = "/path", method = RequestMethod.GET)
    public String path2(@PathVariable("id") String id) {
        return "rmp/path";
    }



    @RequestMapping(value = "/rrs", method = RequestMethod.GET)
    public String rrs(HttpSession session) {
        session.setAttribute("mySessionAttribute", "Make love not war!");
        return "rmp/rrs";
    }

    @RequestMapping(value = "/rrs", method = RequestMethod.POST)
    public String rrs2(HttpServletRequest request,
                      HttpServletResponse response) {
        Locale locale = RequestContextUtils.getLocale(request);
        if (Locale.ITALY.getLanguage().equals(locale.getLanguage())) {
            try {
                response.sendRedirect("path/2");
            } catch (IOException e) {
                System.out.println(e);
            }
        }
        return "rmp/rrs";
    }



    @RequestMapping(value = "/mm", method = RequestMethod.GET)
    public String mm(Model model) {
        model.addAttribute("bob", DataCreator.createBob());
        return "rmp/mm";
    }

    @RequestMapping(value = "/mm1", method = RequestMethod.GET)
    public ModelAndView mm1() {
        return new ModelAndView("rmp/mm","bob", DataCreator.createBob());
    }

    @ModelAttribute("sara")
    public SimpleFormDto mm2() {
        return DataCreator.createSara();
    }







}
