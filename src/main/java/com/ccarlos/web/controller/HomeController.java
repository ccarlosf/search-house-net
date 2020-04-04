package com.ccarlos.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value = {"/"})
    public String index(Model model) {
        model.addAttribute("name","Hello World");
        return "index";
    }
}