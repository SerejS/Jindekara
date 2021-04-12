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

    PersonageClass character_class;

    public Specialization() {
    }

    public Specialization(Long id, String title, PersonageClass character_class) {
        this.id = id;
        this.title = title;
        this.character_class = character_class;
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

    public PersonageClass getCharacter_class() {
        return character_class;
    }

    public void setCharacter_class(PersonageClass character_class) {
        this.character_class = character_class;
    }
}
