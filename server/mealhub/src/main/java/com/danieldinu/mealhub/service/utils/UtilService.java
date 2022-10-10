package com.danieldinu.mealhub.service.utils;

import com.danieldinu.mealhub.model.Drink;
import com.danieldinu.mealhub.model.Meal;
import com.danieldinu.mealhub.model.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class UtilService {
    public static void checkDrinkAndOrder(Order order, Drink drink) {
        if (drink == null) {
            new ResponseEntity<>("Drink not found.", HttpStatus.NOT_FOUND);
            return; }

        if(order == null) {
            new ResponseEntity<>("Order not found.", HttpStatus.NOT_FOUND);
            return; }

        ResponseEntity.ok("Drink and Order found. Proceeding further...");
    }

    public static void checkMealAndOrder(Order order, Meal meal) {
        if (meal == null) {
            new ResponseEntity<>("Meal not found.", HttpStatus.NOT_FOUND);
            return; }

        if(order == null) {
            new ResponseEntity<>("Order not found.", HttpStatus.NOT_FOUND);
            return; }

        ResponseEntity.ok("Meal and Order found. Proceeding further...");
    }
}
