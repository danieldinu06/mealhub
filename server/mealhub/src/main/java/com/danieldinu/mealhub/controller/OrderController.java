package com.danieldinu.mealhub.controller;

import com.danieldinu.mealhub.model.Drink;
import com.danieldinu.mealhub.model.Meal;
import com.danieldinu.mealhub.model.Order;
import com.danieldinu.mealhub.service.DrinkService;
import com.danieldinu.mealhub.service.MealService;
import com.danieldinu.mealhub.service.OrderService;
import com.danieldinu.mealhub.service.utils.UtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

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
        Order order = orderService.getOrder(id);

        if (order == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } else
            return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PostMapping(path = "/{order_id}/meal/{meal_id}")
    public ResponseEntity<String> addMealToOrder(@PathVariable("order_id") Long order_id, @PathVariable("meal_id") Long meal_id) {
        Meal meal = mealService.getMeal(meal_id);
        Order order = orderService.getOrder(order_id);

        UtilService.checkMealAndOrder(order, meal);

        orderService.addMealToOrder(order_id, meal);
        return new ResponseEntity<>("Meal added successfully.", HttpStatus.OK);
    }

    @DeleteMapping(path = "{order_id}/meal/{meal_id}/delete")
    public ResponseEntity<String> deleteMealFromOrder(@PathVariable("order_id") Long order_id, @PathVariable("meal_id") Long meal_id) {
        Meal meal = mealService.getMeal(meal_id);
        Order order = orderService.getOrder(order_id);

        UtilService.checkMealAndOrder(order, meal);

        orderService.removeMealFromOrder(order_id, meal);
        return new ResponseEntity<>("Meal removed successfully.", HttpStatus.OK);
    }

    @PostMapping(path = "/{order_id}/drink/{drink_id}")
    public ResponseEntity<String> addDrinkToOrder(@PathVariable("order_id") Long order_id, @PathVariable("drink_id") Long drink_id) {
        Drink drink = drinkService.getDrink(drink_id);
        Order order = orderService.getOrder(order_id);

        UtilService.checkDrinkAndOrder(order, drink);

        orderService.addDrinkToOrder(order_id, drink);
        return new ResponseEntity<>("Drink added successfully.", HttpStatus.OK);
    }

    @DeleteMapping(path = "{order_id}/drink/{drink_id}/delete")
    public ResponseEntity<String> deleteDrinkFromOrder(@PathVariable("order_id") Long order_id, @PathVariable("drink_id") Long drink_id) {
        Drink drink = drinkService.getDrink(drink_id);
        Order order = orderService.getOrder(order_id);

        UtilService.checkDrinkAndOrder(order, drink);

        orderService.removeDrinkFromOrder(order_id, drink);
        return new ResponseEntity<>("Drink removed successfully.", HttpStatus.OK);
    }

    @DeleteMapping(path = "/{order_id}/delete")
    public ResponseEntity<String> deleteOrder(@PathVariable("order_id") Long order_id) {
        if(orderService.getOrder(order_id) == null) { return new ResponseEntity<>("Order not found.", HttpStatus.NOT_FOUND); }

        orderService.deleteOrder(order_id);
        return new ResponseEntity<>("Order removed successfully.", HttpStatus.OK);
    }
}
