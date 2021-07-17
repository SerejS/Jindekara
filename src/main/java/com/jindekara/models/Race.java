package com.jindekara.models;

import com.jindekara.enums.FoodChain;
import com.jindekara.enums.LevelStrength;
import com.jindekara.enums.Regard;
import com.jindekara.enums.SectionBestiary;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.lang.reflect.Field;

@Data
@Entity
public class Race {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
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

    public String[] getFields() {
        String[] fields = {nameRace,
                strength.toString(),
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
