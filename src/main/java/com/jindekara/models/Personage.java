package com.jindekara.models;

import com.jindekara.enums.Sex;

import javax.persistence.*;

@Entity
public class Personage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false, unique=true)
    private Long id;

    @Column(nullable = false)
    private String name_character;
    private short lvl;
    private short date_born;
    private short year_born;
    private short date_death;
    private short year_death;

    @ManyToOne
    @JoinColumn(name="specialization_id")
    private Specialization specialisation;

    private Sex sex;

    public Personage() {
    }

    public Personage(Long id, String name_character, short lvl, short date_born, short year_born,
                     short date_death, short year_death, Specialization specialisation, Sex sex) {
        this.id = id;
        this.name_character = name_character;
        this.lvl = lvl;
        this.date_born = date_born;
        this.year_born = year_born;
        this.date_death = date_death;
        this.year_death = year_death;
        this.specialisation = specialisation;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Personage{" +
                "id=" + id +
                ", name_character='" + name_character + '\'' +
                ", lvl=" + lvl +
                ", date_born=" + date_born +
                ", year_born=" + year_born +
                ", date_death=" + date_death +
                ", year_death=" + year_death +
                ", specialisation=" + specialisation +
                ", sex=" + sex +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName_character() {
        return name_character;
    }

    public void setName_character(String name_character) {
        this.name_character = name_character;
    }

    public short getLvl() {
        return lvl;
    }

    public void setLvl(short lvl) {
        this.lvl = lvl;
    }

    public short getDate_born() {
        return date_born;
    }

    public void setDate_born(short date_born) {
        this.date_born = date_born;
    }

    public short getYear_born() {
        return year_born;
    }

    public void setYear_born(short year_born) {
        this.year_born = year_born;
    }

    public short getDate_death() {
        return date_death;
    }

    public void setDate_death(short date_death) {
        this.date_death = date_death;
    }

    public short getYear_death() {
        return year_death;
    }

    public void setYear_death(short year_death) {
        this.year_death = year_death;
    }

    public Specialization getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(Specialization specialisation) {
        this.specialisation = specialisation;
    }
    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }
}
