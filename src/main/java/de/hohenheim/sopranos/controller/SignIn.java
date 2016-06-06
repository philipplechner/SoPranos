

package de.hohenheim.sopranos.controller;

import de.hohenheim.sopranos.model.LearningGroup;
import de.hohenheim.sopranos.model.LearningGroupRepository;
import de.hohenheim.sopranos.model.User;
import de.hohenheim.sopranos.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;


@Controller
public class SignIn {


    @RequestMapping("/signin")
    public String signin(@RequestParam(value="name",
            required=false, defaultValue="World")
                                   String name,
                           Model model) {

        return "signin";
    }
}