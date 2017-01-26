package com.chcounter.controllers;

import com.chcounter.models.FoodItem;
import com.chcounter.models.Meal;
import com.chcounter.models.Type;
import com.chcounter.services.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by regnisalram on 1/2/17.
 */
@Controller
public class MainController {

    private MealService service;
    private List<FoodItem> foodItemList;
    public long mealId;

    @Autowired
    public MainController(MealService service) {
        this.service = service;
        foodItemList = new ArrayList<>();
    }

    @RequestMapping(value = {"", "/"})
    public String index(Model model) {
        model.addAttribute("meals", service.list());
        return "meals/main_page";
    }

    @GetMapping("/add")
    public String addMeal(Model model) {
        Meal meal = new Meal();
        model.addAttribute("types", service.getTypes());
        model.addAttribute("meal", meal);
        mealId = meal.getId();
        return "meals/add_meal";
    }

    @PostMapping("/create")
    public String createMeal(@RequestParam("dateAdded") String date,
                             @RequestParam("timeAdded") String time,
                             @RequestParam("typeOfFood") Type type,
                             @RequestParam("description") String description) {
        service.create(date, time, type, description);
        return "redirect:/add/ingredients";
    }

    @GetMapping("/add/ingredients")
    public String addIngredients(Model model) {
        model.addAttribute("foodItemList", foodItemList);
        model.addAttribute("foodOptionsList", service.listAllFoodOption());
        return "meals/add_ingredients";
    }

    @PostMapping("/create/ingredients")
    public String createIngredients(@ModelAttribute List<FoodItem> foodItemList, @ModelAttribute int mealId) {
        this.foodItemList = foodItemList;
        service.passIngredients(service.getMeal(mealId), foodItemList);
        return "redirect:/create";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable long id, Model model) {
        model.addAttribute("meal", service.getMeal(id));
        model.addAttribute("types", service.getTypes());
        return "meals/edit";
    }

    @PostMapping("/{id}/update")
    public String updateMeal(@RequestParam("id") Long id,
                             @RequestParam("dateAdded") String date,
                             @RequestParam("timeAdded") String time,
                             @RequestParam("typeOfFood") Type type,
                             @RequestParam("description") String description,
                             @RequestParam("calories") Integer calories) {
        service.update(id, date, time, type, description, calories);
        return "redirect:/";
    }

}
