package com.jindekara.models;

import com.jindekara.enums.Sex;
import com.jindekara.functions.FileUtils;
import com.jindekara.functions.JindekaraCalender;

import javax.persistence.*;

@Entity
public class Personage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false, unique=true)
    private Long id;

    @Column(nullable = false)
    private String name;
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

    public Personage(Long id, String name, short lvl, short date_born, short year_born,
                     short date_death, short year_death, Specialization specialisation, Sex sex) {
        this.id = id;
        this.name = name;
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
                ", name_character='" + name + '\'' +
                ", lvl=" + lvl +
                ", date_born=" + date_born +
                ", year_born=" + year_born +
                ", date_death=" + date_death +
                ", year_death=" + year_death +
                ", specialisation=" + specialisation +
                ", sex=" + sex +
                '}';
    }

    public String getDateYearOfLife() {
        return JindekaraCalender.numberDayToDate(date_born) + "." + year_born
                + " - " +
                JindekaraCalender.numberDayToDate(date_death) + "." +year_death;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name_character) {
        this.name = name_character;
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
