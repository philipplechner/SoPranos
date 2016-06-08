package de.hohenheim.sopranos.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Burakhan on 07.06.2016.
 */

@Entity
public class Beitrag {

    @Id
    @GeneratedValue
    Integer id;

    String text;





}
