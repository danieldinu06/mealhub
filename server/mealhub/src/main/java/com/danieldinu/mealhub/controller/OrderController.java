package com.danieldinu.mealhub.controller;

import com.danieldinu.mealhub.model.Drink;
import com.danieldinu.mealhub.model.DrinkOrderElement;
import com.danieldinu.mealhub.model.Meal;
import com.danieldinu.mealhub.model.Order;
import com.danieldinu.mealhub.repository.DrinkOrderElementRepository;
import com.danieldinu.mealhub.service.DrinkOrderElementService;
import com.danieldinu.mealhub.service.DrinkService;
import com.danieldinu.mealhub.service.MealService;
import com.danieldinu.mealhub.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/private/checkout")
@CrossOrigin
public class OrderController {
    private final OrderService orderService;

    private final MealService mealService;

    private final DrinkService drinkService;


    @Autowired
    public OrderController(OrderService orderService, MealService mealService, DrinkService drinkService) {
        this.orderService = orderService;
        this.mealService = mealService;
        this.drinkService = drinkService;
    }

    @PostMapping
    public void addOrder(@Valid @RequestBody Order order) {
        orderService.addOrder(order);
    }

    @GetMapping
    @ResponseBody
    public List<Order> getOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping(path = "/{order_id}")
    @ResponseBody
    public ResponseEntity<Order> getOrder(@PathVariable(value = "order_id") Long id) {
        Optional<Order> order = orderService.getOrder(id);

        if (order.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } else
            return new ResponseEntity<>(order.get(), HttpStatus.OK);
    }

    @PostMapping(path = "/{order_id}/meal/{meal_id}")
    public void addMealToOrder(@PathVariable("order_id") Long order_id, @PathVariable("meal_id") Long meal_id) {
        Meal meal = mealService.getMeal(meal_id).get();
        orderService.addMealToOrder(order_id, meal);
    }

    @PostMapping(path = "/{order_id}/drink/{drink_id}")
    public void addDrinkToOrder(@PathVariable("order_id") Long order_id, @PathVariable("drink_id") Long drink_id) {
        Drink drink = drinkService.getDrink(drink_id).get();

        orderService.addDrinkToOrder(order_id, drink);
    }

    @DeleteMapping(path = "/{order_id}/delete")
    public void deleteOrder(@PathVariable("order_id") Long order_id) {
        orderService.deleteOrder(order_id);
    }
}
