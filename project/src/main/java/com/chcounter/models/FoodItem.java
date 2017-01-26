package com.chcounter.models;

import javax.persistence.*;

import static java.lang.Math.round;

@Entity
public class FoodItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;

    int quantity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "meal_id")
    Meal meal;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "foodoption_id")
    FoodOption foodOption;

    public FoodItem() {
    }

    public FoodItem(int quantity, Meal meal, FoodOption foodOption) {
        this.quantity = quantity;
        this.meal = meal;
        this.foodOption = foodOption;
    }

    public FoodItem(int quantity, FoodOption foodOption) {
        this.quantity = quantity;
        this.foodOption = foodOption;
    }

    public int calcFoodItemCH(int quantity) {
        int foodItemCH;
        foodItemCH = round(this.foodOption.cHContent * quantity * this.meal.getTypeOfFood().percentOfDaily);
        return foodItemCH;
    }
}
