package com.chcounter.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FoodOption {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    String name;
    float cHContent;
    String foodOptionType;

    public FoodOption() {
        this.foodOptionType = "Zöldség";
    }

    public FoodOption(String name, long cHContent, String foodOptionType) {
        this.name = name;
        this.cHContent = cHContent;
        this.foodOptionType = foodOptionType;
    }

}
