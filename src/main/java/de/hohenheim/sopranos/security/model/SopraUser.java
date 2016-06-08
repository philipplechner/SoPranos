package de.hohenheim.sopranos.security.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by bumiller on 06.06.2016.
 */
@Entity
public class SopraUser {

  private String username;

  @Id
  @GeneratedValue
  private Integer id;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


}
