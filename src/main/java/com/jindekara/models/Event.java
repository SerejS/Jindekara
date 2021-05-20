package com.jindekara.models;

import com.jindekara.enums.Affect;
import com.jindekara.util.JindekaraCalender;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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

    public Event() {
    }

    public Event(Long id, String nameEvent, short dateStart, short yearStart, short dateEnd, short yearEnd, Affect affect) {
        this.id = id;
        this.nameEvent = nameEvent;
        this.dateStart = dateStart;
        this.yearStart = yearStart;
        this.dateEnd = dateEnd;
        this.yearEnd = yearEnd;
        this.affect = affect;
    }
/*

    public void copy(Event event) {
        nameEvent = event.getNameEvent();
        dateStart = event.getDateStart();
        dateEnd = event.getDateEnd();
        yearStart = event.getYearStart();
        yearEnd = event.getYearEnd();
        affect = event.getAffect();
    }
*/

    public String getDateYearOfEvent() {
        if (yearStart == yearEnd && dateStart == dateEnd) {
            return JindekaraCalender.numberDayToDate(dateStart) + "." +  yearStart;
        } else {
            return JindekaraCalender.numberDayToDate(dateStart) + "." + yearStart
                    + " - " +
                    JindekaraCalender.numberDayToDate(dateEnd) + "." + yearEnd;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameEvent() {
        return nameEvent;
    }

    public void setNameEvent(String nameEvent) {
        this.nameEvent = nameEvent;
    }

    public short getDateStart() {
        return dateStart;
    }

    public void setDateStart(short dateStart) {
        this.dateStart = dateStart;
    }

    public short getYearStart() {
        return yearStart;
    }

    public void setYearStart(short yearStart) {
        this.yearStart = yearStart;
    }

    public short getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(short dateEnd) {
        this.dateEnd = dateEnd;
    }

    public short getYearEnd() {
        return yearEnd;
    }

    public void setYearEnd(short yearEnd) {
        this.yearEnd = yearEnd;
    }

    public Affect getAffect() {
        return affect;
    }

    public void setAffect(Affect affect) {
        this.affect = affect;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", nameEvent='" + nameEvent + '\'' +
                ", dateStart=" + dateStart +
                ", yearStart=" + yearStart +
                ", dateEnd=" + dateEnd +
                ", yearEnd=" + yearEnd +
                ", affect=" + affect +
                '}';
    }
}
