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

  private String email;
  private String password;
  
  private String name;
  
  public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

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

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
