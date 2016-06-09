

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
public class GreetingController {


    @Autowired
    LearningGroupRepository learningGroupRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PostRespository postRespository;


    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value = "name",
            required = false, defaultValue = "User")
                                   String name,
                           Model model) {

        List<User> userList = new ArrayList<User>();

        User user1 = new User("brk@live.de" , "bg2ez");
        User user2 = new User("abc@cde" , "bb");

        userRepository.save(user1);
        userRepository.save(user2);

        LearningGroup lg1 = new LearningGroup("Lerngruppe Eins");

        userList.add(user1);
        userList.add(user2);
        lg1.setUsers(userList);

        learningGroupRepository.save(lg1);

        model.addAttribute("name" , name);


        return "greeting";
    }
}