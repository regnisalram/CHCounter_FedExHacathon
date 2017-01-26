package com.chcounter.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

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

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "type_id")
    Type typeOfFood;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.EAGER, mappedBy = "meal")
    public List<FoodItem> foodItems;

    String description;
    int carbohydrate;

    public Meal() {
    }

    public Meal(LocalDate dateAdded, LocalTime timeAdded, Type typeOfFood, String description) {
        this.dateAdded = dateAdded;
        this.timeAdded = timeAdded;
        this.typeOfFood = typeOfFood;
        this.description = description;
    }

    public Meal(LocalDate dateAdded, LocalTime timeAdded, Type typeOfFood, String description, int carbohydrate) {
        this.dateEntered = LocalDateTime.now();
        this.dateAdded = dateAdded;
        this.timeAdded = timeAdded;
        this.typeOfFood = typeOfFood;
        this.description = description;
        this.carbohydrate = carbohydrate;
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

    public int getCarbohydrate() {
        return carbohydrate;
    }

    public void setCarbohydrate(int carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    public long getId() {
        return id;
    }

    public void setDateAdded(LocalDate dateAdded) {
        this.dateAdded = dateAdded;
    }
}
