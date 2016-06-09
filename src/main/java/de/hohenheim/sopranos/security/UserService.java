package de.hohenheim.sopranos.security;

import de.hohenheim.sopranos.security.model.SopraUser;
import de.hohenheim.sopranos.security.model.SopraUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

/**
 * Created by bumiller on 06.06.2016.
 */
@Service
public class UserService {

  @Autowired
  private SopraUserRepository sopraUserRepository;

  public SopraUser getCurrentNegoisstUser() {
    return sopraUserRepository.findByUsername(((User) SecurityContextHolder.getContext().getAuthentication()
        .getPrincipal()).getUsername());
  }


}
