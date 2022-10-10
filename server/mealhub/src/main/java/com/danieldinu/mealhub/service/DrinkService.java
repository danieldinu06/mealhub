package com.danieldinu.mealhub.service;

import com.danieldinu.mealhub.model.Drink;
import com.danieldinu.mealhub.model.Restaurant;
import com.danieldinu.mealhub.repository.DrinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class DrinkService {
    private final DrinkRepository drinkRepository;
    private final RestaurantService restaurantService;

    @Autowired
    public DrinkService(DrinkRepository drinkRepository, RestaurantService restaurantService) {
        this.drinkRepository = drinkRepository;
        this.restaurantService = restaurantService;
    }

    public void addDrink(Restaurant restaurant, Drink drink) {
        drinkRepository.save(drink);
        restaurantService.addDrinkToRestaurant(restaurant.getId(), drink);
    }

    public void addDrinks(Restaurant restaurant, List<Drink> drinks) {
        drinkRepository.saveAll(drinks);
        restaurantService.addDrinksToRestaurant(restaurant.getId(), drinks);
    }

    public Drink getDrink(Long id) {
        return drinkRepository.findById(id).isPresent() ? drinkRepository.findById(id).get() : null;
    }

    public Set<Drink> getDrinks(Long id) {
        return drinkRepository.findByRestaurantId(id);
    }
}
