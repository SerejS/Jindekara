package com.jindekara.models;

import com.jindekara.enums.PersonageClass;

import javax.persistence.*;

@Entity
public class Specialization {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false, unique=true)
    Long id;

    String title;

    PersonageClass personage_class;

    public Specialization() {
    }

    public Specialization(Long id, String title, PersonageClass personage_class) {
        this.id = id;
        this.title = title;
        this.personage_class = personage_class;
    }

    @Override
    public String toString() {
        return personage_class + ", " + title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public PersonageClass getPersonage_class() {
        return personage_class;
    }

    public void setPersonage_class(PersonageClass character_class) {
        this.personage_class = character_class;
    }
}
