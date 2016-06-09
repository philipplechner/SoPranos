package de.hohenheim.sopranos.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Burakhan on 07.06.2016.
 */

@Entity
public class Post {

    @Id
    @GeneratedValue
    Integer id;

    String text;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
