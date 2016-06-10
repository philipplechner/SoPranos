package de.hohenheim.sopranos.controller;

import de.hohenheim.sopranos.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;


@Controller
public class IndexController {

    @Autowired
    LearningGroupRepository learningGroupRepository;

    @Autowired
    SopraUserRepository sopraUserRepository;

    @Autowired
    PostRepository postRepository;

    @RequestMapping("/index")
    public String index(@RequestParam(value="name",
            required=false, defaultValue="World")
                                 String name,
                         Model model) {

        List<SopraUser> users = new ArrayList<SopraUser>();

        LearningGroup lg1 = new LearningGroup("Lerngruppe 1");
        lg1.setDescription("Dies ist eine Lerngruppe für Sopra");

        SopraUser user1 = new SopraUser("ilikburi@abc.com", "pass");
        SopraUser user2 = new SopraUser("abc@def.de", "pw");

        users.add(user1);
        users.add(user2);


        lg1.setSopraUsers(users);

        sopraUserRepository.save(user1);
        sopraUserRepository.save(user2);

        learningGroupRepository.save(lg1);

        Post post1 = new Post("Dies ist ein fucking Post von brk");
        Post post2 = new Post("dies ist ebenfalls ein fucking  Post von abc");

        post1.sopraUser = user1;
        post2.sopraUser = user2;

        post1.learningGroup = lg1;
        post2.learningGroup = lg1;

        postRepository.save(post1);
        postRepository.save(post2);

        return "index";
    }
}
