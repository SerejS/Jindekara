package com.jindekara.models;

import com.jindekara.enums.Sex;
import com.jindekara.util.JindekaraCalender;
import lombok.Data;

import javax.persistence.*;

@Data
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
    @JoinColumn(name = "race_id")
    private Race race;

    @ManyToOne
    @JoinColumn(name="specialization_id")
    private Specialization specialization;

    private Sex sex;


    public String getDateYearOfLife() {
        return JindekaraCalender.numberDayToDate(date_born) + "." + year_born
                + " - " +
                JindekaraCalender.numberDayToDate(date_death) + "." +year_death;
    }
}
