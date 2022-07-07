package com.danieldinu.mealhub.controller;

import com.danieldinu.mealhub.model.Restaurant;
import com.danieldinu.mealhub.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/restaurant")
@CrossOrigin
public class RestaurantController {
    private final RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @PostMapping
    public void addRestaurant(@Valid @RequestBody Restaurant restaurant) {
        restaurantService.addRestaurant(restaurant);
    }

    @GetMapping
    @ResponseBody
    public List<Restaurant> getAllRestaurants() {
        return restaurantService.getAllRestaurants();
    }

    @GetMapping(path = {"/{id}"})
    @ResponseBody
    public ResponseEntity<Restaurant> getRestaurant(@PathVariable(value = "id") Long id) {
        Optional<Restaurant> restaurant = restaurantService.getRestaurant(id);

        return restaurant.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteRestaurant(@PathVariable(value = "id") Long id) {
        Optional<Restaurant> restaurant = restaurantService.getRestaurant(id);

        if (restaurant.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        restaurantService.deleteRestaurant(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
