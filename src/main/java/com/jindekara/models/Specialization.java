package com.jindekara.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jindekara.enums.PersonageClass;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Specialization {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false, unique=true)
    Long id;
    String title;
    PersonageClass personage_class;

    @JsonProperty("string")
    @Override
    public String toString() {
        return personage_class + ", " + title;
    }
}
