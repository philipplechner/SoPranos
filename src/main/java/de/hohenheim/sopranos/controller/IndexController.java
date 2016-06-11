package de.hohenheim.sopranos.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index(@RequestParam(value = "username", required = false, defaultValue = "user") String username, Model model) {

        return "index";
    }


}

