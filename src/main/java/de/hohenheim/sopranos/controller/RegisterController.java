package de.hohenheim.sopranos.controller;

import de.hohenheim.sopranos.security.model.SopraUser;
import de.hohenheim.sopranos.security.model.SopraUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by MortmannMKII v2 on 08.06.2016.
 */
@Controller
public class RegisterController {
    @Autowired
    private UserDetailsManager userDetailsManager;
    @Autowired
    private SopraUserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @RequestMapping(value="/register", method=RequestMethod.GET)
    public String signin(@RequestParam(value="name",
            required=false, defaultValue="World")
                                 String name,
                         Model model) {
    	model.addAttribute("SopraUser", new SopraUser());
        return "register";
    }

    @RequestMapping(value="/register", method=RequestMethod.POST)
    public String registerSubmit( SopraUser user, Model model) {
    	if(user.getEmail().isEmpty() && user.getPassword().isEmpty() && user.getUsername().isEmpty()){
    		return "register?error";
    	}
        model.addAttribute("SopraUser", user);
        Collection<GrantedAuthority> auth = new ArrayList<>();
        auth.add(new SimpleGrantedAuthority("ROLE_USER"));
        userDetailsManager.createUser(new User(user.getUsername(), passwordEncoder.encode(user.getPassword()), auth));
        userRepository.save(user);
        return "login";
    }

}
