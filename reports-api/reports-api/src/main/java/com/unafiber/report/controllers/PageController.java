package com.unafiber.report.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

    @GetMapping("/home")
    public ModelAndView home() {
        ModelAndView home = new ModelAndView("index.html");
        return home;
    }

    @GetMapping("/new-report")
    public ModelAndView newReport() {
        ModelAndView newReport = new ModelAndView("new-report.html");
        return newReport;
    }

}
