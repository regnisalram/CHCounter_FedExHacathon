package com.chcounter.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Created by regnisalram on 1/2/17.
 */
@Entity
@Table(name = "meal_type")
public class Type {

    @Id
    public String code;
    public String description;
    public float percentOfDaily;

    @OneToOne(mappedBy = "typeOfFood")
    public Meal meal;

    Type() {
    }

    public Type(String code, String description, float percentOfDaily) {
        this.code = code;
        this.description = description;
        this.percentOfDaily = percentOfDaily;
    }

    public String getDescription() {
        return description;
    }
}
