package com.eazybytes.eazyschool.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping(value = { "", "/", "home" })
    public String Home(Model model) {
        model.addAttribute("username", "John Wick 2");
        return "home.html";
    }

}
