package com.danieldinu.mealhub.service;

import com.danieldinu.mealhub.model.Meal;
import com.danieldinu.mealhub.model.Restaurant;
import com.danieldinu.mealhub.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class MealService {
    private final MealRepository mealRepository;
    private final RestaurantService restaurantService;

    @Autowired
    public MealService(MealRepository mealRepository, RestaurantService restaurantService) {
        this.mealRepository = mealRepository;
        this.restaurantService = restaurantService;
    }

    public void addMeal(Restaurant restaurant, Meal meal) {
        mealRepository.save(meal);
        restaurantService.addMealToRestaurant(restaurant.getId(), meal);
    }

    public void addMeals(Restaurant restaurant, List<Meal> meals) {
        mealRepository.saveAll(meals);
        restaurantService.addMealsToRestaurant(restaurant.getId(), meals);
    }

    public Optional<Meal> getMeal(Long id) {
        return mealRepository.findById(id);
    }

    public Set<Meal> getMeals(Long id) {
        return mealRepository.findByRestaurantId(id);
    }

}
