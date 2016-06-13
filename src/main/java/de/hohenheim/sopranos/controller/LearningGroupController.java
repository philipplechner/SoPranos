package de.hohenheim.sopranos.controller;

import de.hohenheim.sopranos.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by MortmannMKII v2 on 08.06.2016.
 */
@Controller
public class LearningGroupController {

    @Autowired
    LearningGroupRepository learningGroupRepository;

    @Autowired
    SopraUserRepository sopraUserRepository;

    @RequestMapping(value = "/learninggrouppost", method = RequestMethod.GET)
    public String post(Model model) {
        model.addAttribute("posttest", new Post());
        return "learninggrouppost";
    }

    @RequestMapping(value = "/learninggrouppost", method = RequestMethod.POST)
    public String registerSubmit(Post post, Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String mail = user.getUsername();
        String s = post.getText();
        Post p = new Post();
        p.setText(s.toString() + " by " + mail);
        model.addAttribute("post", p);
        return "learninggroup";
    }

    @RequestMapping(value = "/learninggroupcreate", method = RequestMethod.GET)
    public String create(Model model) {


        model.addAttribute("group", new LearningGroup());
        return "learninggroupcreate";
    }

    @RequestMapping(value = "/learninggroupcreate", method = RequestMethod.POST)
    public String createFinish(LearningGroup lg, Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        SopraUser host = sopraUserRepository.findByEmail(user.getUsername());
        lg.setSopraHost(host);
        learningGroupRepository.save(lg);
        return "index";
    }

    @RequestMapping("/learninggroup")
    public String show(Model model) {

        return "learninggroup";
    }
}
 