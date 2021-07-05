package com.jindekara.models;

import com.jindekara.enums.FoodChain;
import com.jindekara.enums.LevelStrength;
import com.jindekara.enums.Regard;
import com.jindekara.enums.SectionBestiary;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.lang.reflect.Field;

@Entity
public class Race {
    @Override
    public String toString() {
        return "Race{" +
                "id=" + id +
                ", nameRace='" + nameRace + '\'' +
                ", strength=" + strength +
                ", sectionBestiary=" + sectionBestiary +
                ", lifespan=" + lifespan +
                ", population=" + population +
                ", location='" + location + '\'' +
                ", food=" + food +
                ", regardToHumanoid=" + regardToHumanoid +
                ", regardToAll=" + regardToAll +
                '}';
    }

    public Race() {
    }

    public Race(long id, String nameRace, LevelStrength strength, SectionBestiary sectionBestiary, int lifespan, int population, String location, FoodChain food, Regard regardToHumanoid, Regard regardToAll) {
        this.id = id;
        this.nameRace = nameRace;
        this.strength = strength;
        this.sectionBestiary = sectionBestiary;
        this.lifespan = lifespan;
        this.population = population;
        this.location = location;
        this.food = food;
        this.regardToHumanoid = regardToHumanoid;
        this.regardToAll = regardToAll;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    //Название расы
    private String nameRace;
    //Средний уровень силы представителя
    private LevelStrength strength;
    //Место в бестиарии
    private SectionBestiary sectionBestiary;
    //Продолжительность жизни
    private int lifespan;
    //Среднее количество в группе
    private int population;
    //Ареал обитания
    private String location;
    //Всеядный, травоядный, всеядный
    private FoodChain food;
    //Отношение к разумным (Враждебный, нейтр, дружелюбный)
    private Regard regardToHumanoid;
    //Отношение к остальным  (Враждебный, нейтр, дружелюбный)
    private Regard regardToAll;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameRace() {
        return nameRace;
    }

    public void setNameRace(String nameRace) {
        this.nameRace = nameRace;
    }

    public LevelStrength getStrength() {
        return strength;
    }

    public void setStrength(LevelStrength strength) {
        this.strength = strength;
    }

    public int getLifespan() {
        return lifespan;
    }

    public void setLifespan(int lifespan) {
        this.lifespan = lifespan;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public FoodChain getFood() {
        return food;
    }

    public void setFood(FoodChain food) {
        this.food = food;
    }

    public Regard getRegardToHumanoid() {
        return regardToHumanoid;
    }

    public void setRegardToHumanoid(Regard regardToHumanoid) {
        this.regardToHumanoid = regardToHumanoid;
    }

    public Regard getRegardToAll() {
        return regardToAll;
    }

    public void setRegardToAll(Regard regardToAll) {
        this.regardToAll = regardToAll;
    }

    public SectionBestiary getSectionBestiary() {
        return sectionBestiary;
    }

    public void setSectionBestiary(SectionBestiary sectionBestiary) {
        this.sectionBestiary = sectionBestiary;
    }

    public String[] getFields() {
        String[] fields = {nameRace,
                strength.getStrength(),
                Integer.toString(lifespan),
                Integer.toString(population),
                location,
                food.getFoodChainStatus(),
                regardToHumanoid.getRegard(),
                regardToAll.getRegard()
        };
        return fields;
    }
}
