package com.danieldinu.mealhub.service;

import com.danieldinu.mealhub.model.Drink;
import com.danieldinu.mealhub.model.Meal;
import com.danieldinu.mealhub.model.Order;
import com.danieldinu.mealhub.model.Restaurant;
import com.danieldinu.mealhub.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public void addRestaurant(Restaurant restaurant) {
        restaurantRepository.save(restaurant);
    }

    public void addRestaurants(List<Restaurant> restaurants) {
        restaurantRepository.saveAll(restaurants);
    }

    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    public Optional<Restaurant> getRestaurant(Long id) {
        return restaurantRepository.findById(id);
    }

    public void updateRestaurant(Long id, Double rating, Double deliveryFree, Time estimatedTime) {
        Restaurant restaurant = restaurantRepository.findById(id).get();

        restaurant.setRating(rating);
        restaurant.setDeliveryFee(deliveryFree);
        restaurant.setEstimatedTime(estimatedTime);

        restaurantRepository.save(restaurant);
    }

    public void addMealToRestaurant(Long id, Meal meal) {
        Restaurant restaurant = restaurantRepository.findById(id).get();

        meal.addRestaurant(restaurant);
        restaurant.addMeal(meal);

        restaurantRepository.save(restaurant);
    }

    public void addMealsToRestaurant(Long id, List<Meal> meals) {
        Restaurant restaurant = restaurantRepository.findById(id).get();

        meals.forEach(meal -> {
            meal.addRestaurant(restaurant);
            restaurant.addMeal(meal);
        });

        restaurantRepository.save(restaurant);
    }

    public void addDrinkToRestaurant(Long id, Drink drink) {
        Restaurant restaurant = restaurantRepository.findById(id).get();

        drink.addRestaurant(restaurant);
        restaurant.addDrink(drink);

        restaurantRepository.save(restaurant);
    }

    public void addDrinksToRestaurant(Long id, List<Drink> drinks) {
        Restaurant restaurant = restaurantRepository.findById(id).get();

        drinks.forEach(drink -> {
            drink.addRestaurant(restaurant);
            restaurant.addDrink(drink);
        });

        restaurantRepository.save(restaurant);
    }

    public void deleteRestaurant(Long id){
        restaurantRepository.deleteById(id);
    }
}
