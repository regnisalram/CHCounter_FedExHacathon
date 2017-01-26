package com.caloriecounter.services;

import com.caloriecounter.models.Meal;
import com.caloriecounter.models.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Created by regnisalram on 1/9/17.
 */
@Service
public class MealService {

    private MealRepository mealRepository;

    private TypeRepository typeRepository;

    @Autowired
    public MealService(MealRepository mealRepository, TypeRepository typeRepository) {
        this.mealRepository = mealRepository;
        this.typeRepository = typeRepository;
    }

    public Iterable<Meal> list() {
        return mealRepository.findAll();
    }

    public Iterable<Type> getTypes() {
        return typeRepository.findAll();
    }

    public void create(String date, String time, Type type, String description, Integer calories) {
        mealRepository.save(new Meal(LocalDate.parse(date), LocalTime.parse(time), type, description, calories));
    }

    public Meal getMeal(long id) {
        return mealRepository.findOne(id);
    }

    public void update(Long id, String date, String time, Type type, String description, Integer calories) {
        Meal meal = mealRepository.findOne(id);
        meal.setDateAdded(LocalDate.parse(date));
        meal.setTimeAdded(LocalTime.parse(time));
        meal.setTypeOfFood(type);
        meal.setDescription(description);
        meal.setCalories(calories);
        mealRepository.save(meal);
    }

//    public int sumCalories()
}
