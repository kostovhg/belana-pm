package com.belana.production.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {


    @GetMapping("/")
    public ModelAndView getIndexView(ModelAndView modelAndView, HttpSession session) {

        modelAndView.setViewName("index");
        return modelAndView;
    }

}
