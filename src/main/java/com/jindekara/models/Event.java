package com.jindekara.models;

import com.jindekara.enums.Affect;
import com.jindekara.util.JindekaraCalender;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nameEvent;

    private short dateStart;
    private short yearStart;

    private short dateEnd;
    private short yearEnd;

    private Affect affect;


    public String getDateYearOfEvent() {
        if (yearStart == yearEnd && dateStart == dateEnd) {
            return JindekaraCalender.numberDayToDate(dateStart) + "." +  yearStart;
        } else {
            return JindekaraCalender.numberDayToDate(dateStart) + "." + yearStart
                    + " - " +
                    JindekaraCalender.numberDayToDate(dateEnd) + "." + yearEnd;
        }
    }

}
