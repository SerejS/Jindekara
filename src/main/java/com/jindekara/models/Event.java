package com.jindekara.models;

import com.jindekara.enums.Affect;

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
}