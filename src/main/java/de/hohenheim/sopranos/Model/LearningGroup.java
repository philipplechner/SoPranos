package de.hohenheim.sopranos.model;

import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class LearningGroup {

    @Id
    @GeneratedValue
    Integer id;

    String name;

    @ManyToMany
    @JoinTable(
            name="GROUPPARTICIPANTS",
            joinColumns = @JoinColumn(name="GROUP_ID"),
            inverseJoinColumns=@JoinColumn(name="USER_ID"))

    List<User> users = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}


