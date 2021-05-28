package com.jindekara.models;

import com.jindekara.enums.FoodChain;
import com.jindekara.enums.LevelStrength;
import com.jindekara.enums.Regard;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Race {
    @Override
    public String toString() {
        return "Race{" +
                "id=" + id +
                ", nameRace='" + nameRace + '\'' +
                ", strength=" + strength +
                ", lifespan=" + lifespan +
                ", population=" + population +
                ", location='" + location + '\'' +
                ", weaknesses='" + weaknesses + '\'' +
                ", food=" + food +
                ", regardToHumanoid=" + regardToHumanoid +
                ", regardToAll=" + regardToAll +
                '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nameRace;
    //Средний уровень силы представителя
    private LevelStrength strength;

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

    public String getWeaknesses() {
        return weaknesses;
    }

    public void setWeaknesses(String weaknesses) {
        this.weaknesses = weaknesses;
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

    //Продолжительность жизни
    private int lifespan;
    //Среднее количество в группе
    private int population;
    //Ареал обитания
    private String location;
    //Слабости
    private String weaknesses;
    //Всеядный, травоядный, всеядный
    private FoodChain food;
    //Отношение к гуманоидам (Враждебный, нейтр, дружелюбный)
    private Regard regardToHumanoid;
    //Отношение к остальным  (Враждебный, нейтр, дружелюбный)
    private Regard regardToAll;
}
