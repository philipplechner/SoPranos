package de.hohenheim.sopranos.controller;

import de.hohenheim.sopranos.model.Text;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by MortmannMKII v2 on 08.06.2016.
 */
@Controller
public class LearningGroupController {
    @RequestMapping(value="/learninggrouppost", method=RequestMethod.GET)
    public String post(Model model) {
    	model.addAttribute("texttest", new Text());
        return "learninggrouppost";
    }  

    @RequestMapping(value="/learninggrouppost", method=RequestMethod.POST)
    public String registerSubmit( Text text, Model model) {
    	 User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
         String name = user.getUsername();
         String s = text.getContentInput();
         Text t = new Text();
         t.setContentInput(s.toString() + " by " +  name);
         model.addAttribute("text",t);
        return "learninggroup";
    }
     
    @RequestMapping("/learninggroup" )
    public String show(Model model) { 
       
        return "learninggroup";
    } 
}
 