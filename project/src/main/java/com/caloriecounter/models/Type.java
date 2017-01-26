package com.caloriecounter.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalTime;

/**
 * Created by regnisalram on 1/2/17.
 */
@Entity
@Table (name = "meal_type")
public class Type {

    @Id
    public String code;
    public String description;

    @OneToOne(mappedBy = "typeOfFood")
    public Meal meal;

    Type() {}

    public Type(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
