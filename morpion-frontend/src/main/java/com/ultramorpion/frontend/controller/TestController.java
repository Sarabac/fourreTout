package com.ultramorpion.frontend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class TestController {

    @GetMapping("/{nom}")
    public ModelAndView hello(@PathVariable String nom){
        ModelAndView modelAndView = new ModelAndView("testage");
        modelAndView.addObject("user", nom);
        return modelAndView;
    }
}
