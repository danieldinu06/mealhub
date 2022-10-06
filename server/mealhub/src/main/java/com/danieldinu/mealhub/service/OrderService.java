package com.danieldinu.mealhub.service;

import com.danieldinu.mealhub.model.Drink;
import com.danieldinu.mealhub.model.DrinkOrderElement;
import com.danieldinu.mealhub.model.Meal;
import com.danieldinu.mealhub.model.Order;
import com.danieldinu.mealhub.repository.DrinkOrderElementRepository;
import com.danieldinu.mealhub.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final DrinkOrderElementService drinkOrderElementService;

    public OrderService(OrderRepository orderRepository, DrinkOrderElementService drinkOrderElementService) {
        this.orderRepository = orderRepository;
        this.drinkOrderElementService = drinkOrderElementService;
    }

    public void addMealToOrder(Long id, Meal meal) {
        Order order = orderRepository.findById(id).get();
        order.addMeal(meal);
        order.setPrice(calculateOrderPrice(order));

        orderRepository.save(order);
    }

    public void addDrinkToOrder(Long id, Drink drink) {
        Order order = orderRepository.findById(id).get();
        order.addDrink(drink);
        order.setPrice(calculateOrderPrice(order));

        DrinkOrderElement drinkOrderElement = order.getDrink(drink);
        drinkOrderElementService.addDrink(drinkOrderElement);

        orderRepository.save(order);
    }

    public void removeDrinkFromOrder(Long id, Drink drink) {
        Order order = orderRepository.findById(id).get();
        order.removeDrink(drink);
        order.setPrice(calculateOrderPrice(order));

        orderRepository.save(order);
    }

    public void addOrder(Order order) {
        order.setPrice(calculateOrderPrice(order));
        orderRepository.save(order);
    }

    public Optional<Order> getOrder(Long id) {
        Optional<Order> order = orderRepository.findById(id);

        order.get().setPrice(calculateOrderPrice(order.get()));
        return order;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    private Double calculateOrderPrice(Order order) {
        List<Meal> meals = order.getMeals();
        List<DrinkOrderElement> drinkOrderElements = order.getDrinks();

        Double price = 0.0;

        if (!meals.isEmpty()) {
            for (Meal meal : meals) {
                price += meal.getPrice();
            }
        }

        for (DrinkOrderElement drinkOrderElement : drinkOrderElements) {
            price += (drinkOrderElement.getDrink().getPrice() * drinkOrderElement.getQuantity());
        }

        return price;
    }
}
