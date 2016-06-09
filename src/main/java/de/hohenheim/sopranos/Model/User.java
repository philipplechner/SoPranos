
package de.hohenheim.sopranos.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    String email;

    String password;

    String name;

    String courseOfStudys;

    Integer rankpoints;

    public User() {

    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
        this.name = null;
        this.courseOfStudys = null;
        this.rankpoints = 0;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourseOfStudys() {
        return courseOfStudys;
    }

    public void setCourseOfStudys(String courseOfStudys) {
        this.courseOfStudys = courseOfStudys;
    }

    public Integer getRankpoints() {
        return rankpoints;
    }

    public void setRankpoints(Integer rankpoints) {
        this.rankpoints = rankpoints;
    }
}