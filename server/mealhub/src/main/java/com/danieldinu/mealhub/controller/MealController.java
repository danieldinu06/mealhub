package com.danieldinu.mealhub.controller;

import com.danieldinu.mealhub.model.Meal;
import com.danieldinu.mealhub.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping(path = "/restaurant/{id}/meals")
@CrossOrigin
public class MealController {
    private final MealService mealService;

    @Autowired
    public MealController(MealService mealService) {
        this.mealService = mealService;
    }

    @GetMapping
    public Set<Meal> getAllMealsFromRestaurant(@PathVariable(value = "id") Long id) {
        return mealService.getMeals(id);
    }
}
