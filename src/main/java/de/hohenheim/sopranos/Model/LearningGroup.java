package de.hohenheim.sopranos.model;

import javax.persistence.*;
import java.util.List;


@Entity
public class LearningGroup {

    @Id
    @GeneratedValue
    Integer lgId;

    String name;

    String description;

    @ManyToMany
    @JoinTable(
            name = "GROUPPARTICIPANTS",
            joinColumns = @JoinColumn(name = "GROUP_ID"),
            inverseJoinColumns = @JoinColumn(name = "USER_ID"))
    public List<SopraUser> sopraUsers;

    @OneToMany(mappedBy = "learningGroup")
    public List<Post> postSet;


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

    public List<SopraUser> getSopraUsers() {
        return sopraUsers;
    }

    public void setSopraUsers(List<SopraUser> sopraUsers) {
        this.sopraUsers = sopraUsers;
    }

    public List<Post> getPostSet() {
        return postSet;
    }

    public void setPostSet(List<Post> postSet) {
        this.postSet = postSet;
    }
}
