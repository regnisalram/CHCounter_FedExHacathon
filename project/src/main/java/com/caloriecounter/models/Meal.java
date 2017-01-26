package com.caloriecounter.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Created by regnisalram on 1/2/17.
 */
@Entity
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    LocalDateTime dateEntered;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate dateAdded;

    @DateTimeFormat(pattern = "HH-mm")
    LocalTime timeAdded;

    @OneToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "type_id")
    Type typeOfFood;

    String description;
    int calories;

    public Meal() {}

    public Meal(LocalDate dateAdded, LocalTime timeAdded, Type typeOfFood, String description, int calories) {
        this.dateEntered = LocalDateTime.now();
        this.dateAdded = dateAdded;
        this.timeAdded = timeAdded;
        this.typeOfFood = typeOfFood;
        this.description = description;
        this.calories = calories;
    }

    public LocalDate getDateAdded() {
        return dateAdded;
    }

    public LocalTime getTimeAdded() {
        return timeAdded;
    }

    public void setTimeAdded(LocalTime timeAdded) {
        this.timeAdded = timeAdded;
    }

    public Type getTypeOfFood() {
        return typeOfFood;
    }

    public void setTypeOfFood(Type typeOfFood) {
        this.typeOfFood = typeOfFood;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public long getId() {
        return id;
    }

    public void setDateAdded(LocalDate dateAdded) {
        this.dateAdded = dateAdded;
    }
}
