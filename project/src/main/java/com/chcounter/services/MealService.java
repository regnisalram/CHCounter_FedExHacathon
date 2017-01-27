package com.chcounter.services;

import com.chcounter.models.FoodItem;
import com.chcounter.models.FoodOption;
import com.chcounter.models.Meal;
import com.chcounter.models.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 * Created by regnisalram on 1/9/17.
 */
@Service
public class MealService {

    public MealRepository mealRepository;

    private TypeRepository typeRepository;

    private FoodItemRepository foodItemRepository;

    private FoodOptionRepository foodOptionRepository;

    @Autowired
    public MealService(MealRepository mealRepository, TypeRepository typeRepository, FoodItemRepository foodItemRepository, FoodOptionRepository foodOptionRepository) {
        this.mealRepository = mealRepository;
        this.typeRepository = typeRepository;
        this.foodItemRepository = foodItemRepository;
        this.foodOptionRepository = foodOptionRepository;
    }

    public Iterable<FoodOption> listAllFoodOption() {
        return foodOptionRepository.findAll();
    }

    public Iterable<Meal> list() {
        return mealRepository.findAll();
    }

    public Iterable<Type> getTypes() {
        return typeRepository.findAll();
    }

    public void create(String date, String time, Type type, String description) {
        mealRepository.save(new Meal(LocalDate.parse(date), LocalTime.parse(time), type, description));
    }

    public void addIngredient(Meal meal, FoodOption foodOption, int quantity) {
        foodItemRepository.save(new FoodItem(quantity, meal, foodOption));
    }

    public void passIngredients(Meal meal, List<FoodItem> foodItemList) {
        for (FoodItem foodItem : foodItemList) {
            meal.foodItems.add(foodItem);
            foodItemRepository.save(foodItem);
            foodItemList.remove(foodItem);
        }
    }

    public Meal getMeal(long id) {
        return mealRepository.findOne(id);
    }

    public void update(Long id, String date, String time, Type type, String description, Integer carbohydrate) {
        Meal meal = mealRepository.findOne(id);
        meal.setDateAdded(LocalDate.parse(date));
        meal.setTimeAdded(LocalTime.parse(time));
        meal.setTypeOfFood(type);
        meal.setDescription(description);
        meal.setCarbohydrate(carbohydrate);
        mealRepository.save(meal);
    }

//    public int sumCalories()
}
