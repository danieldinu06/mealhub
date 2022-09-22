package com.danieldinu.mealhub.controller;

import com.danieldinu.mealhub.model.Drink;
import com.danieldinu.mealhub.service.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping(path = "/api/public/restaurants/{id}/drinks")
@CrossOrigin
public class DrinkController {
    private final DrinkService drinkService;

    @Autowired
    public DrinkController(DrinkService drinkService) {
        this.drinkService = drinkService;
    }

    @GetMapping
    public Set<Drink> getAllDrinksFromRestaurant(@PathVariable(value = "id") Long id) {
        return drinkService.getDrinks(id);
    }
}
