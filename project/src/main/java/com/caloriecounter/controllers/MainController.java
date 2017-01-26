package com.caloriecounter.controllers;

import com.caloriecounter.models.Meal;
import com.caloriecounter.models.Type;
import com.caloriecounter.services.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by regnisalram on 1/2/17.
 */
@Controller
public class MainController {

    private MealService service;

    @Autowired
    public MainController(MealService service) {
        this.service = service;
    }

    @RequestMapping(value={"", "/"})
    public String index(Model model) {
        model.addAttribute("meals", service.list());
        return "meals/main_page";
    }

    @GetMapping("/add")
    public String addMeal(Model model) {
        model.addAttribute("types", service.getTypes());
        model.addAttribute("meal", new Meal());
        return "meals/add_meal";
    }

    @PostMapping("/create")
    public String createMeal(@RequestParam("dateAdded") String date,
                             @RequestParam("timeAdded") String time,
                             @RequestParam("typeOfFood") Type type,
                             @RequestParam("description") String description,
                             @RequestParam("calories") Integer calories) {
        service.create(date, time, type, description, calories);
        return "redirect:/";
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
