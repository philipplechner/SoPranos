package de.hohenheim.sopranos.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class LearningGroup {

    @Id
    @GeneratedValue
    Integer lgId;

    String name;

    String description;

    public LearningGroup() {
    }

    public LearningGroup(String name) {
        this.name = name;
    }

    public Integer getLgId() {
        return lgId;
    }

    public void setLgId(Integer lgId) {
        this.lgId = lgId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @ManyToMany
    @JoinTable(
            name = "GROUPPARTICIPANTS",
            joinColumns = @JoinColumn(name = "GROUP_ID"),
            inverseJoinColumns = @JoinColumn(name = "USER_ID"))

    List<User> users = new ArrayList<>();


}


