package de.hohenheim.sopranos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by MortmannMKII v2 on 08.06.2016.
 */
@Controller
public class LoginController {

    @RequestMapping("/login")
    public String signin(@RequestParam(value="name",
            required=false, defaultValue="World")
                                 String name,
                         Model model) {

        return "login";
    }
}
