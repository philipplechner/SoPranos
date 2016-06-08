package de.hohenheim.sopranos.security.controller;

import org.springframework.core.Ordered;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by bumiller on 06.06.2016.
 */
@Controller
public class ExampleController extends WebMvcConfigurerAdapter {

  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/signin").setViewName("signin");
    registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
  }


  @RequestMapping(value = "/admin/home")
  public String adminHome() {
    return "adminhome";
  }

  @RequestMapping(value = "/home")
  public String userHome() {
    return "userhome";
  }

  /**
   * Request mapping for the disputeResolutionOverview page or administrationOverview page depending on user role.
   * Propagates to respective methods
   *
   * @return home url?
   */
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String displayHome() {
    if (((User) SecurityContextHolder.getContext().getAuthentication()
        .getPrincipal()).getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
      return "redirect:/admin/home";
    } else {
      return "redirect:/home";
    }
  }
}
